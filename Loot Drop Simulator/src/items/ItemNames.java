package items;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ItemNames {

	public static ArrayList<String[]> records;
	public static int[] recordSizes;
	
	public static void readItemNames() throws IOException {
		Scanner s = new Scanner(new File("ItemNameAffixes.csv"));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
		    list.add(s.next());
		}
		s.close();
		records = new ArrayList<String[]>();
		for(String str: list) {
			records.add(str.split(","));
		}
		recordSizes = new int[list.size()];
		for(int i = 0; i< records.size(); i++) {
			recordSizes[i]=records.get(i).length;
		}
	}
	
	public static void initialize() {
		try {
			ItemNames.readItemNames();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
