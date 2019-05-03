package items;

import java.util.Comparator;

public class AffixSorter implements Comparator<Affix>{

	@Override
	public int compare(Affix o1, Affix o2) {
		if(o1.getPriority()<o2.getPriority()) 
			return -1;
		else if(o2.getPriority()<o1.getPriority()) 
			return 1;
		else
			return 0;
	}
	
}

