package items.weapons;

import items.*;

public class Weapon extends items.Item {
	
	public enum Type{
		PISTOL, SUBMACHINE, RIFLE, MACHINE, SNIPER, SHOTGUN, LAUNCHER;
	}
	
	Type type;
	WeaponAttribute[] attributes;
	Affix implicitAffix;
	Affix[] prefix;
	Affix[] suffix;
	int itemLevel;
	
	public Weapon(Type type, double[] attributeValues, int itemLevel, Affix implicit, Affix[] pre, Affix[] suf) {
		super(items.Item.Type.WEAPON);
		this.itemLevel = itemLevel;
		this.type = type;
		WeaponAttribute.Type[] weaponAttributeNames = WeaponAttribute.Type.values();
		attributes = new WeaponAttribute[weaponAttributeNames.length];
		for(int i = 0; i<weaponAttributeNames.length; i++) {
			attributes[i] = new WeaponAttribute(weaponAttributeNames[i], attributeValues[i]);
		}
		this.implicitAffix = implicit;
		this.prefix = pre;
		this.suffix = suf;
	}
	
	public Type getWeaponType() {
		return this.type;
	}
	public WeaponAttribute getAttribute(int i) {
		return attributes[i];
	}
	public Affix getImplicitAffix() {
		return this.implicitAffix;
	}
	public Affix getPrefix(int i) {
		return this.prefix[i];
	}
	public Affix getSuffix(int i) {
		return this.suffix[i];
	}
	public int getItemLevel() {
		return this.itemLevel;
	}
}
