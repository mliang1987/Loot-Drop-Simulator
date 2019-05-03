package items;

import java.util.ArrayList;
import java.util.Random;

public class Item {

	public enum Type{
		WEAPON, ARMOR, CONSUMABLE;
		public static Type getRandomItemType() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
	}
	
	public enum Rarity{
		COMMON, UNCOMMON, RARE, LEGENDARY, MYTHIC;
		public static Rarity getRandomItemRarity() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
	}

	Type type;
	Rarity rarity;
	String name;
	String base;
	int itemLevel;
	protected ArrayList<Affix> prefixes;
	protected ArrayList<Affix> suffixes;
	protected Affix implicit;
	protected double[] attributes;
	
	public Item(Type type, Rarity rarity, int itemLevel, String name, double[] attributes) {
		this.type = type;
		this.rarity = rarity;
		this.name = name;
		this.base = name;
		this.itemLevel = itemLevel;
		this.rarity = Rarity.COMMON;
		this.prefixes = new ArrayList<Affix>();
		this.suffixes= new ArrayList<Affix>();
		this.implicit = null;
		this.attributes = attributes;
	}
	
	public Type getItemType() {
		return type;
	}
	
	public int getItemLevel() {
		return this.itemLevel;
	}
	
	public String getItemName() {
		return this.name;
	}
	
	public String getItemBase() {
		return this.base;
	}

	public void changeItemName(String name) {
		this.name = name;
	}
	
	public void changeRarity(Item.Rarity rarity) {
		this.rarity = rarity;
	}
	
	public Rarity getRarity() {
		return this.rarity;
	}
	
	public static String generateItemName(Item.Type itemType, Item.Rarity itemRarity, String currentName) {
		String name = currentName;
		if(itemRarity==Item.Rarity.UNCOMMON||itemRarity==Item.Rarity.RARE) {
			int prefixSize = ItemNames.recordSizes[0];
			int suffixSize = ItemNames.recordSizes[1];
			String prefix = ItemNames.records.get(0)[((int)(Math.random()*prefixSize))];
			String suffix = ItemNames.records.get(1)[((int)(Math.random()*suffixSize))];
			name = prefix +" "+suffix;
		}
		return name;
	}
	
	/**
	 * Static helper method for randomly determining the amount of prefixes and suffixes to roll for an item.
	 * @return An size-3 array of ints: array[0]->total rolls, array[1]->prefix rolls, array[2]->suffix rolls
	 */
	public static int[] generateRareAffixAmounts() {
		int totalRolls  = ((int) (Math.random()*4)+3);
		int prefixRolls = 1;
		int suffixRolls = 1;
		while(prefixRolls + suffixRolls <totalRolls) {
			int flip = (int) (Math.random()*2);
			if(flip == 0) {
				if(prefixRolls < 3) {
					prefixRolls++;
				}
			}
			else {
				if(suffixRolls < 3) {
					suffixRolls++;
				}
			}
		}
		return new int[] {totalRolls, prefixRolls, suffixRolls};
	}
	
	
}
