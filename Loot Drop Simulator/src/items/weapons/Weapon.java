package items.weapons;

public class Weapon extends items.Item {
	
	public enum Type{
		PISTOL, SUBMACHINE, RIFLE, MACHINE, SNIPER, SHOTGUN, LAUNCHER;
	}
	
	Type type;
	
	public Weapon(Type type) {
		super(items.Item.Type.WEAPON);
		this.type = type;
	}
	
	public Type getWeaponType() {
		return this.type;
	}
}
