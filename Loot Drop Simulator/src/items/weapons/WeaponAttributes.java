package items.weapons;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WeaponAttributes{
	
	public static final int NUMBER_OF_WEAPON_ATTRIBUTES = 28;
	public static final double KINETIC_SCALING_RATIO 	= 1.2;

	public static final int 
		KINETIC_LOW				= 0,
		KINETIC_HIGH 			= 1,
		BASE_ENERGY_LOW			= 2,
		BASE_ENERGY_HIGH		= 3,
		BASE_ENERGY_TYPE		= 4,
		VOID_LOW				= 5,
		VOID_HIGH				= 6,
		ENTROPY_LOW				= 7,
		ENTROPY_HIGH			= 8,
		QUANTUM_LOW				= 9,
		QUANTUM_HIGH			= 10,
		RATE_OF_FIRE			= 11,
		CRITICAL_CHANCE			= 12,
		CRITICAL_MULTIPLIER		= 13,
		PRECISION_MULTIPLIER	= 14,
		RANGE					= 15,
		HANDLING				= 16,
		STABILITY				= 17,
		RELOAD_SPEED			= 18,
		MAGAZINE				= 19,
		RESERVE_MULTIPLIER		= 20,
		RESERVE_AMMO			= 21,
		AIM_ASSIST				= 22,
		PROJECTILES				= 23,
		SPREAD					= 24,
		BLAST_RADIUS			= 25,
		VELOCITY				= 26,
		FIRE_MODE				= 27;

	public static HashMap<String, double[]> weaponBases = new HashMap<>();
	
	public static void readWeaponBases() throws IOException {
		List<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
		try (CSVReader csvReader = new CSVReader(new FileReader("BaseWeapons.csv"));) {
		    String[] values = null;
		    while ((values = csvReader.readNext()) != null) {
		        records.add(new ArrayList<String>(Arrays.asList(values)));
		    }
		}
		ArrayList<String> listHeaders = records.remove(0);
		for(ArrayList<String> l : records) {
			String baseID = l.remove(0);
			double[] attributeValues = Arrays.stream(l.toArray(new String[0]))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
			weaponBases.put(baseID, attributeValues);
		}
	}
	
	public static double[] getAttributes(String baseID) {
		return weaponBases.get(baseID);
	}
	
	
	
}
