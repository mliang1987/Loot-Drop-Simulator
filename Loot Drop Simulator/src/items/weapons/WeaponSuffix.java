package items.weapons;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;

import items.ExplicitAffix;

public class WeaponSuffix extends ExplicitAffix{

	public enum Type{
		INCREASE,
		INCREASE_PERCENTAGE,
		ADD_100,
		ADD_PERCENTAGE;
	}
	
	ArrayList<String> stats;
	Type type;
	
	public WeaponSuffix(String name, ArrayList<String> affixStats) {
		super(ExplicitAffix.Type.SUFFIX,
				name, 
				Double.parseDouble(affixStats.get(WeaponSuffix.LOW)),
				Double.parseDouble(affixStats.get(WeaponSuffix.HIGH)),
				0,0,
				Integer.parseInt(affixStats.get(WeaponSuffix.PRIORITY)),
				null);
		stats = new ArrayList<String>(affixStats);	
		type = Enum.valueOf(Type.class, this.stats.get(WeaponSuffix.MOD_TYPE));
	}
	
	public static final int NUMBER_OF_CATEGORIES = 12;
	public static final int ATTRIBUTE_TYPE 		= 0,
							TIER				= 1,
							MOD_TYPE			= 2,
							TOTAL_TIERS			= 3,
							LEVEL_RESTRICTION	= 4,
							SCOPE				= 5,
							LOW					= 6,
							HIGH				= 7,
							SPREAD				= 8,
							HIGH_PER_TIER		= 9,	
							TEXT				= 10,
							PRIORITY			= 11;
	
	public static HashMap<String, ArrayList<String>> weaponSuffixes;
	public static HashMap<Integer, ArrayList<String>> suffixRangeByLevel;
	
	public static void initialize() {
		weaponSuffixes = new HashMap<String,ArrayList<String>>();
		suffixRangeByLevel = new HashMap<Integer, ArrayList<String>>();
		for(int i = 1; i<=100; i++) {
			suffixRangeByLevel.put( i, new ArrayList<String>());
		}
		try {
			readWeaponSuffixes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void readWeaponSuffixes() throws IOException {
		List<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
		try (CSVReader csvReader = new CSVReader(new FileReader("WeaponSuffixList.csv"));) {
		    String[] values = null;
		    while ((values = csvReader.readNext()) != null) {
		        records.add(new ArrayList<String>(Arrays.asList(values)));
		    }
		}
		records.remove(0);
		for(ArrayList<String> l : records) {
			String baseID = l.remove(0);
			int restrict = Integer.parseInt(l.get(WeaponSuffix.LEVEL_RESTRICTION));
			for(int i = restrict+1 ; i<=100 && i< restrict + 60 ; i++){
				suffixRangeByLevel.get(i).add(baseID);
			}
			weaponSuffixes.put(baseID, l);

		}
	}
	
	public static ArrayList<String> getWeaponSuffixRange(int level){
		return suffixRangeByLevel.get(level);
	}
	
	public static WeaponSuffix getWeaponSuffix(String key) {
		return null;
	}
	
	public static ArrayList<String> getWeaponSuffixStats(String key) {
		return weaponSuffixes.get(key);
	}
	
	
}
