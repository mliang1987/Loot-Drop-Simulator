package items.weapons;

import items.*;

public class Weapon extends Item {
	
	public enum Slot{
		PRIMARY, SECONDARY, TERTIARY;
	}
	
	public enum Type{
		PISTOL,
		RIFLE,
		SUBMACHINE,
		SHOTGUN,
		SNIPER,
		MACHINE,
		LAUNCHER;
	}
	
	
	Slot slot;
	double[] attributes;
	Type type;
	
	public Weapon(Slot slot, Type type, double[] attributes, int itemLevel,  String name) {
		super(Item.Type.WEAPON, itemLevel, name);
		this.slot = slot;
		this.type = type;
		this.attributes = attributes;
	}
	
	public Slot getWeaponSlot() {
		return this.slot;
	}
	public Type getWeaponType() {
		return this.type;
	}
	
	public double getAttribute(int index) {
		return attributes[index];
	}
	
	public String toString() {
		String toReturn = "-------------------------------\n"+this.getItemName()+"\n-------------------------------\n";
		double rawDamage = (attributes[WeaponAttributes.KINETIC_DAMAGE]+attributes[WeaponAttributes.VOID_DAMAGE]
				+attributes[WeaponAttributes.QUANTUM_DAMAGE]+attributes[WeaponAttributes.ENTROPY_DAMAGE])
				*attributes[WeaponAttributes.PROJECTILES]*attributes[WeaponAttributes.RATE_OF_FIRE];
		double critChance = attributes[WeaponAttributes.CRITICAL_CHANCE]/100;
		double critMulti = attributes[WeaponAttributes.CRITICAL_MULTIPLIER];
		double damagePerSecond = ((1-critChance)*rawDamage + (critChance*critMulti*rawDamage))/60;

		toReturn+="Regular DPS: " + (int) damagePerSecond +"\n";
		if(attributes[WeaponAttributes.PRECISION_MULTIPLIER]>1) {	
			toReturn+="Precision DPS: " + (int) (damagePerSecond*attributes[WeaponAttributes.PRECISION_MULTIPLIER]) +"\n";
		}
		toReturn+="Kinetic Damage: " + (int) (attributes[WeaponAttributes.KINETIC_DAMAGE])+"\n";
		if(attributes[WeaponAttributes.VOID_DAMAGE]>0) {
			toReturn+="Void Damage: " + (int) (attributes[WeaponAttributes.VOID_DAMAGE])+"\n";
		}
		if(attributes[WeaponAttributes.ENTROPY_DAMAGE]>0) {
			toReturn+="Entropy Damage: " + (int) (attributes[WeaponAttributes.ENTROPY_DAMAGE])+"\n";
		}
		if(attributes[WeaponAttributes.QUANTUM_DAMAGE]>0) {
			toReturn+="Quantum Damage: " + (int) (attributes[WeaponAttributes.QUANTUM_DAMAGE])+"\n";
		}
		toReturn+="Rate of Fire: " + (int) (attributes[WeaponAttributes.RATE_OF_FIRE])+"\n";
		if(attributes[WeaponAttributes.CRITICAL_CHANCE]>0) {
			toReturn+="Critical Chance: " + (int) (attributes[WeaponAttributes.CRITICAL_CHANCE])+"%\n";
		}
		if(attributes[WeaponAttributes.PROJECTILES]>1) {
			toReturn+="Projectiles: " + (int) (attributes[WeaponAttributes.PROJECTILES])+"\n";
		}
		if(attributes[WeaponAttributes.BLAST_RADIUS]>0) {
			toReturn+="Blast Radius: " + (int) (attributes[WeaponAttributes.BLAST_RADIUS])+"\n";
		}
		if(attributes[WeaponAttributes.VELOCITY]<2000) {
			toReturn+="Velocity: " + (int) (attributes[WeaponAttributes.VELOCITY])+"\n";
		}
		if(attributes[WeaponAttributes.RANGE]<2000) {
			toReturn+="Range: " + (int) (attributes[WeaponAttributes.RANGE])+"\n";
		}
		toReturn+="Stability: " + (int) (attributes[WeaponAttributes.STABILITY])+"\n";
		toReturn+="Handling: " + (int) (attributes[WeaponAttributes.HANDLING])+"\n";
		toReturn+="Reload Speed: " + (int) (attributes[WeaponAttributes.RELOAD_SPEED])+"\n";
		toReturn+="Magazine Size: " + (int) (attributes[WeaponAttributes.MAGAZINE])+"\n";
		toReturn+="Reserve Ammo: " + (int) (attributes[WeaponAttributes.RESERVES])+"\n";
		return toReturn;
	}
	
}
