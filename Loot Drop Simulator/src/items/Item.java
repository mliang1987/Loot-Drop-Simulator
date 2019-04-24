package items;

public class Item {

	public enum Type{
		WEAPON, ARMOR, CONSUMABLE;
	}

	Type type;
	
	public Item(Type type) {
		this.type = type;
	}
	
	public Type getItemType() {
		return type;
	}
	
}
