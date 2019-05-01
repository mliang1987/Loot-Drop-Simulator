package items.weapons;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVReader;

import items.ExplicitAffix;

public class WeaponPrefix extends ExplicitAffix{
	
	ArrayList<String> stats;
	
	public WeaponPrefix(String name, ArrayList<String> affixStats) {
		super(ExplicitAffix.Type.PREFIX,name, 0,0,null);
		stats = new ArrayList<String>(affixStats);			
	}
	
	public String getStatString(int index) {
		return stats.get(index);
	}
	public double getStatDouble(int index) throws NumberFormatException{
		return Double.parseDouble(stats.get(index));
	}
	
	public static final int NUMBER_OF_CATEGORIES = 12;
	public static final int ATTRIBUTE_TYPE 		= 0,
							TIER				= 1,
							MOD_TYPE			= 2,
							TOTAL_TIERS			= 3,
							LEVEL_RESTRICTION	= 4,
							SCOPE				= 5,
							BASE_LOW			= 6,
							BASE_HIGH			= 7,
							SPREAD				= 8,
							HIGH_PER_TIER		= 9,
							LOW					= 10,
							HIGH				= 11;
	
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
			for(int i = 100 ; i > Integer.parseInt(l.get(WeaponPrefix.LEVEL_RESTRICTION)); i--){
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
