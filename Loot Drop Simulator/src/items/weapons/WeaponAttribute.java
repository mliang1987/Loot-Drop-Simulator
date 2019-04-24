package items.weapons;

import items.Attribute;

public class WeaponAttribute extends Attribute{
	
	public enum Type{
		RATE_OF_FIRE, 
		KINETIC_DAMAGE, 
		VOID_DAMAGE, 
		ENTROPY_DAMAGE, 
		QUANTUM_DAMAGE, 
		RANGE, 
		CRITICAL_CHANCE,
		CRITICAL_MULTIPLIER,
		MAGAZINE,
		FIRE_MODE;
	}

	Type type;
	double value;
	
	public WeaponAttribute(Type weaponAttributeType) {
		super(Attribute.Category.WEAPON);
		this.type = weaponAttributeType;
	}
	
	public double getWeaponAttributeValue() {
		return this.value;
	}
	public Type getWeaponAttributeType() {
		return this.type;
	}
	
}
