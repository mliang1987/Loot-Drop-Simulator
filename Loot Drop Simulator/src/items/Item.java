package items;

import java.io.IOException;

public class Item {

	public enum Type{
		WEAPON, ARMOR, CONSUMABLE;
	}
	
	public enum Rarity{
		COMMON, UNCOMMON, RARE, LEGENDARY, MYTHIC;
	}

	Type type;
	Rarity rarity;
	String name;
	String base;
	int itemLevel;
	
	public Item(Type type, Rarity rarity, int itemLevel, String name) {
		this.type = type;
		this.rarity = rarity;
		this.name = name;
		this.base = name;
		this.itemLevel = itemLevel;
		this.rarity = Rarity.COMMON;
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
	
	public void changeName(String name) {
		this.name = name;
	}
	
	public void changeRarity(Item.Rarity rarity) {
		this.rarity = rarity;
	}
	
	public static String generateItemName(Item.Type itemType, Item.Rarity itemRarity, String currentName) {
		try {
			ItemNames.readItemNames();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public static void main(String[] args) {
		for(int i = 0; i<10; i++) {
			System.out.println(generateItemName(Item.Type.WEAPON, Item.Rarity.RARE, null));
		}
	}

}
