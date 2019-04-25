package items;

public class Item {

	public enum Type{
		WEAPON, ARMOR, CONSUMABLE;
	}

	Type type;
	String name;
	int itemLevel;
	
	public Item(Type type, int itemLevel, String name) {
		this.type = type;
		this.name = name;
		this.itemLevel = itemLevel;
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

}
