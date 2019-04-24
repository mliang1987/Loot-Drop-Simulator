package items.armor;

import items.*;

public class ArmorAttribute extends Attribute{

	public enum Type{
		SHIELD, ARMOR, VOID_RESISTANCE, ENTROPY_RESISTANCE, QUANTUM_RESISTANCE;
	}
	
	Type type;
	double value;
	
	public ArmorAttribute(Type armorAttributeType) {
		super(Attribute.Category.ARMOR);
		this.type = armorAttributeType;
	}
	
	public double getArmorAttributeValue() {
		return this.value;
	}
	
	public Type getArmorAttributeType() {
		return this.type;
	}
}
