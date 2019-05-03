package items.weapons;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;

import items.ExplicitAffix;

public class WeaponPrefix extends ExplicitAffix{
	
	public enum Type{
		INCREASE,
		ADD;
	}
	public enum Subtype{
		LOW_HIGH,
		PERCENTAGE,
		FLAT;
	}
	
	ArrayList<String> stats;
	Type type;
	Subtype subtype;
	
	public WeaponPrefix(String name, ArrayList<String> affixStats) {
		super(ExplicitAffix.Type.PREFIX,
				name, 
				Double.parseDouble(affixStats.get(WeaponPrefix.LOW)),
				Double.parseDouble(affixStats.get(WeaponPrefix.HIGH)),
				Double.parseDouble(affixStats.get(WeaponPrefix.LOW2)),
				Double.parseDouble(affixStats.get(WeaponPrefix.HIGH2)),
				Integer.parseInt(affixStats.get(WeaponPrefix.PRIORITY)),
				null);
		stats = new ArrayList<String>(affixStats);	
		type = Enum.valueOf(Type.class, this.stats.get(WeaponPrefix.MOD_TYPE));
		subtype = Enum.valueOf(Subtype.class, this.stats.get(WeaponPrefix.MOD_SUBTYPE));
	}
	
	public String getStatString(int index) {
		return stats.get(index);
	}
	public double getStatDouble(int index) throws NumberFormatException{
		return Double.parseDouble(stats.get(index));
	}
	
	public static final int NUMBER_OF_CATEGORIES = 15;
	public static final int ATTRIBUTE_TYPE 		= 0,
							TIER				= 1,
							MOD_TYPE			= 2,
							MOD_SUBTYPE			= 3,
							TOTAL_TIERS			= 4,
							LEVEL_RESTRICTION	= 5,
							SCOPE				= 6,
							LOW					= 7,
							HIGH				= 8,
							LOW2				= 9,
							HIGH2				= 10,
							SPREAD				= 11,
							HIGH_PER_TIER		= 12,	
							TEXT				= 13,
							PRIORITY			= 14;
	
	
	public static HashMap<String, ArrayList<String>> weaponPrefixes;
	public static HashMap<Integer, ArrayList<String>> prefixRangeByLevel;
	
	public static void initialize() {
		weaponPrefixes = new HashMap<String,ArrayList<String>>();
		prefixRangeByLevel = new HashMap<Integer, ArrayList<String>>();
		for(int i = 1; i<=100; i++) {
			prefixRangeByLevel.put( i, new ArrayList<String>());
		}
		try {
			readWeaponPrefixes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readWeaponPrefixes() throws IOException {
		List<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
		try (CSVReader csvReader = new CSVReader(new FileReader("WeaponPrefixList.csv"));) {
		    String[] values = null;
		    while ((values = csvReader.readNext()) != null) {
		        records.add(new ArrayList<String>(Arrays.asList(values)));
		    }
		}
		records.remove(0);
		for(ArrayList<String> l : records) {
			String baseID = l.remove(0);
			int restrict = Integer.parseInt(l.get(WeaponPrefix.LEVEL_RESTRICTION));
			for(int i = restrict+1 ; i<=100 && i< restrict + 60 ; i++){
				prefixRangeByLevel.get(i).add(baseID);
			}
			weaponPrefixes.put(baseID, l);

		}
	}
	
	public static ArrayList<String> getWeaponPrefixRange(int level){
		return prefixRangeByLevel.get(level);
	}
	
	public static WeaponPrefix getWeaponPrefix(String key) {
		return null;
	}
	
	public static ArrayList<String> getWeaponPrefixStats(String key) {
		return weaponPrefixes.get(key);
	}
	
}
