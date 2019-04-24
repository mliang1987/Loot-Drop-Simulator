package items.armor;

public class Armor extends items.Item{

	public enum Type{
		HELM, BODY, GLOVES, BOOTS, CLASS;
	}
	
	Type type;
	
	public Armor(Type armorType) {
		super(items.Item.Type.ARMOR);
		this.type = armorType;
	}
	
	public Type getArmorType() {
		return this.type;
	}
}
