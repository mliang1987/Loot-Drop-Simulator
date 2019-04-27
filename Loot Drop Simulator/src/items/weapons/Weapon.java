package items.weapons;

import java.util.Random;

import items.*;
import items.weapons.WeaponAttributes;

public class Weapon extends Item {
	
	public enum Slot{
		PRIMARY, SECONDARY, TERTIARY;
	}
	
	public enum Archetype{
		HEAVY,
		BALANCED,
		LIGHT,
		RAPID;
		public static Archetype getRandomWeaponArchetype() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
		}
	}
	
	public enum Type{
		PISTOL,
		RIFLE,
		SUBMACHINE,
		SHOTGUN,
		SNIPER,
		BEAM,
		MELEE,
		MACHINE,
		ROCKET;
		public static Type getRandomWeaponType() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
	}
	
	
	Slot slot;
	Type type;
	Archetype archetype;
	double[] attributes;
	int tier;
	
	public Weapon(Slot slot, Type type, Archetype archetype, double[] attributes, int itemLevel, int tier, String name) {
		super(Item.Type.WEAPON, Item.Rarity.COMMON, itemLevel, name);
		this.slot = slot;
		this.type = type;
		this.tier = tier;
		this.archetype=archetype;
		this.attributes = attributes;
	}
	
	public void changeWeaponRarity(Rarity rarity) {
		if(rarity != this.getRarity()) {
			changeRarity(rarity);
			if(rarity!=Rarity.COMMON) {
				this.changeItemName(Item.generateItemName(Item.Type.WEAPON, Item.Rarity.RARE, this.getItemName()));
			}
		}
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
	
	public double calculateDPS() {
		double dps = 0;
		return dps;
	}
	
	
	public String toString() {
		
		String toReturn = ""; 
		if(this.getRarity() != Item.Rarity.COMMON) {
			toReturn+="-------------------------------\n"+this.getItemName()+"\n";
		}
		toReturn 	+="-------------------------------\n"+this.getItemBase()+"\n-------------------------------\n";
		toReturn 	+="Kinetic Damage: " 
					+ (int) Math.floor((attributes[WeaponAttributes.KINETIC_LOW]))
					+" - "
					+ (int) Math.ceil((attributes[WeaponAttributes.KINETIC_HIGH]))
					+"\n";
		toReturn	+="Rate of Fire: " 
					+ (int) (attributes[WeaponAttributes.RATE_OF_FIRE])
					+"\n";
		if(attributes[WeaponAttributes.CRITICAL_CHANCE]>0) {
			toReturn+="Critical Chance: " 
					+ (int) (attributes[WeaponAttributes.CRITICAL_CHANCE])
					+"%\n";
		}
		if(attributes[WeaponAttributes.PROJECTILES]>1) {
			toReturn+="Projectiles: " 
					+ (int) (attributes[WeaponAttributes.PROJECTILES])
					+"\n";
		}
		if(attributes[WeaponAttributes.BLAST_RADIUS]>0) {
			toReturn+="Blast Radius: " + (int) (attributes[WeaponAttributes.BLAST_RADIUS])+"\n";
		}
		if(attributes[WeaponAttributes.VELOCITY]<1000) {
			toReturn+="Velocity: " + (int) (attributes[WeaponAttributes.VELOCITY])+"\n";
		}
		if(attributes[WeaponAttributes.RANGE]<1000) {
			toReturn+="Range: " + (int) (attributes[WeaponAttributes.RANGE])+"\n";
		}
		toReturn+="Stability: " + (int) (attributes[WeaponAttributes.STABILITY])+"\n";
		toReturn+="Handling: " + (int) (attributes[WeaponAttributes.HANDLING])+"\n";
		toReturn+="Reload Speed: " + (int) (attributes[WeaponAttributes.RELOAD_SPEED])+"\n";
		toReturn+="Magazine Size: " + (int) (attributes[WeaponAttributes.MAGAZINE])+"\n";
		toReturn+="Reserve Ammo: " + (int) (attributes[WeaponAttributes.RESERVE_AMMO])+"\n";
		toReturn+="Tier: " + tier+"\n";
		toReturn+="Item Level: " + this.getItemLevel() +"\n";
		return toReturn;
	}
	
}
