package items.weapons;

import java.util.ArrayList;
import java.util.Random;

import items.*;
import items.weapons.WeaponAttributes;
import items.weapons.Weapon.Archetype;
import items.weapons.Weapon.Slot;
import items.weapons.Weapon.Type;

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
	int tier;
	
	
	public Weapon(Slot slot, Type type, Archetype archetype, double[] attributes, int itemLevel, int tier, String name) {
		super(Item.Type.WEAPON, Item.Rarity.COMMON, itemLevel, name, attributes);
		this.slot = slot;
		this.type = type;
		this.tier = tier;
		this.archetype=archetype;
	}
	
	public void changeWeaponRarity(Rarity rarity) {
		if(rarity != this.getRarity()) {
			if(rarity == Rarity.COMMON) {
				
			}
			else if (rarity == Rarity.UNCOMMON) {
				
			}
			else {
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
		if(attributes[WeaponAttributes.KINETIC_LOW]>0) {
			toReturn+="Kinetic Damage: " 
					+ (int) Math.floor((attributes[WeaponAttributes.KINETIC_LOW]))
					+" - "
					+ (int) Math.ceil((attributes[WeaponAttributes.KINETIC_HIGH]))
					+"\n";
		}
		if(attributes[WeaponAttributes.ENTROPY_LOW]>0) {
			toReturn+="Entropy Damage: " 
					+ (int) Math.floor((attributes[WeaponAttributes.ENTROPY_LOW]))
					+" - "
					+ (int) Math.ceil((attributes[WeaponAttributes.ENTROPY_HIGH]))
					+"\n";
		}
		if(attributes[WeaponAttributes.QUANTUM_LOW]>0) {
			toReturn+="Quantum Damage: " 
					+ (int) Math.floor((attributes[WeaponAttributes.QUANTUM_LOW]))
					+" - "
					+ (int) Math.ceil((attributes[WeaponAttributes.QUANTUM_HIGH]))
					+"\n";
		}
		if(attributes[WeaponAttributes.VOID_LOW]>0) {
			toReturn+="Void Damage: " 
					+ (int) Math.floor((attributes[WeaponAttributes.VOID_LOW]))
					+" - "
					+ (int) Math.ceil((attributes[WeaponAttributes.VOID_HIGH]))
					+"\n";
		}
			
		toReturn	+="Rate of Fire: " 
					+ (int) (attributes[WeaponAttributes.RATE_OF_FIRE])
					+"\n";
		if(attributes[WeaponAttributes.CRITICAL_CHANCE]>0) {
			toReturn+="Critical Chance: " 
					+ (int) (attributes[WeaponAttributes.CRITICAL_CHANCE])
					+"%\n";
			toReturn+="Critical Multiplier: " 
					+ (int) (attributes[WeaponAttributes.CRITICAL_MULTIPLIER]*100)
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
	
	@SuppressWarnings("unchecked")
	public static void rerollRareWeapon(Weapon weapon, Item.Rarity rarity) {
		int level = weapon.getItemLevel();
		ArrayList<String> possibleRolls = (ArrayList<String>) WeaponPrefix.getWeaponPrefixRange(level).clone();
		weapon.prefixes = new ArrayList<Affix>();
		weapon.suffixes = new ArrayList<Affix>();
		int totalRolls  = ((int) (Math.random()*4)+3);
		int prefixRolls = 1;
		int suffixRolls = 1;
		while(prefixRolls + suffixRolls <totalRolls) {
			int flip = (int) (Math.random()*2);
			if(flip == 0) {
				if(prefixRolls < 3) {
					prefixRolls++;
				}
			}
			else {
				if(suffixRolls < 3) {
					suffixRolls++;
				}
			}
		}
		System.out.println("Affixes: "+totalRolls);
		System.out.println("Prefixes: "+prefixRolls);
		ArrayList<String> prefixes = new ArrayList<String>(); 
		ArrayList<String> suffixes = new ArrayList<String>(); 
		for(int p = 0; p< prefixRolls; p++) {
			Random random = new Random();
			String roll = possibleRolls.get(random.nextInt(possibleRolls.size()));
			String roll2 = null;
			if(	roll.substring(0,roll.length()-2).endsWith("FLAT_LOW")) {
				roll2 = roll.split("_")[0]+"_FLAT_HIGH_"+roll.substring(roll.length()-1);
				prefixes.add(roll);
				prefixes.add(roll2);
			}
			else if(roll.substring(0,roll.length()-2).endsWith("FLAT_HIGH")) {
				roll2 = roll.split("_")[0]+"_FLAT_LOW_"+roll.substring(roll.length()-1);
				prefixes.add(roll2);
				prefixes.add(roll);
				
			}
			else {
				prefixes.add(roll);
			}
			ArrayList<String> toRemove = new ArrayList<String>();
			for(String s : possibleRolls) {
				if(s.substring(0,s.length()-2).equals(roll.substring(0,roll.length()-2))){
					toRemove.add(s);
				}
				if(roll2!=null) {
					if(s.substring(0,s.length()-2).equals(roll2.substring(0,roll2.length()-2))){
						toRemove.add(s);
					}	
				}
			}
			for(String s : toRemove) {
				possibleRolls.remove(s);
			}
		}
		System.out.println(prefixes);
		
	}
	
	public static Weapon generateWeapon(Slot slot, Type type, int zoneLevel, int tier) {
		Weapon.Archetype archetype = null;
		while(archetype == null || (slot==Slot.TERTIARY && archetype==Archetype.RAPID)) {
			archetype = Archetype.getRandomWeaponArchetype();
		}
		
		String baseName = generateBaseName(type, tier, archetype);
		double[] attributes = WeaponAttributes.getAttributes(type+"_"+archetype).clone();
		
		if(attributes[WeaponAttributes.BASE_ENERGY_LOW]>0) {
			int energy =(int) ((3*Math.random())+1);
			attributes[WeaponAttributes.BASE_ENERGY_TYPE] = energy;
			switch (energy) {
				case 1:
					attributes[WeaponAttributes.ENTROPY_LOW]=attributes[WeaponAttributes.BASE_ENERGY_LOW]*tier;
					attributes[WeaponAttributes.ENTROPY_HIGH]=attributes[WeaponAttributes.BASE_ENERGY_HIGH]*tier;					
					break;
				case 2:
					attributes[WeaponAttributes.QUANTUM_LOW]=attributes[WeaponAttributes.BASE_ENERGY_LOW]*tier;
					attributes[WeaponAttributes.QUANTUM_HIGH]=attributes[WeaponAttributes.BASE_ENERGY_HIGH]*tier;
					break;
				default:
					attributes[WeaponAttributes.VOID_LOW]=attributes[WeaponAttributes.BASE_ENERGY_LOW]*tier;
					attributes[WeaponAttributes.VOID_HIGH]=attributes[WeaponAttributes.BASE_ENERGY_HIGH]*tier;
					break;
			}
		}
		else{
			attributes[WeaponAttributes.KINETIC_LOW]=attributes[WeaponAttributes.KINETIC_LOW]*tier;
			attributes[WeaponAttributes.KINETIC_HIGH]=attributes[WeaponAttributes.KINETIC_HIGH]*tier;
		}		
		
		Weapon toReturn = new Weapon(slot, type, archetype, attributes, zoneLevel, tier, baseName);
		toReturn.changeWeaponRarity(Item.Rarity.getRandomItemRarity());
		System.out.println(toReturn);
		return toReturn;
	}


	public static int generateRandomTier(int zoneLevel) {
		int tierTop = (zoneLevel / 6 + 1 > 14) ? 14 : zoneLevel / 6 + 1;
		int tierBottom = 0;
		tierBottom = (tierTop - 6 >= 0) ? tierTop - 6 : 0;
		int tierRange = ((int) (Math.random() * (tierTop - tierBottom))) + 1;
		return tierBottom + tierRange;
	}
	
	public static String generateBaseName(Type type, int tier, Archetype archetype ) {
		String toReturn;
		if (tier > 14) {
			tier = 14;
		}
		switch (tier) {
			case 1:
				toReturn = "Crumbling";
				break;
			case 2:
				toReturn = "Corroded";
				break;
			case 3:
				toReturn = "Rusted";
				break;
			case 4:
				toReturn = "Battered";
				break;
			case 5:
				toReturn = "Worn";
				break;
			case 6:
				toReturn = "Clean";
				break;
			case 7:
				toReturn = "Burnished";
				break;
			case 8:
				toReturn = "Anodized";
				break;
			case 9:
				toReturn = "Fancy";
				break;
			case 10:
				toReturn = "Elegant";
				break;
			case 11:
				toReturn = "Jewelled";
				break;
			case 12:
				toReturn = "Ornate";
				break;
			case 13:
				toReturn = "Gilded";
				break;
			default:
				toReturn = "Exquisite";
				break;
		}
		switch (archetype) {
			case HEAVY:
				toReturn += " " + "Heavy";
				break;
			case BALANCED:
				toReturn += " " + "Balanced";
				break;
			case LIGHT:
				toReturn += " " + "Light";
				break;
			default:
				toReturn += " " + "Rapid";
				break;
		}
		switch (type) {
			case PISTOL:
				toReturn += " " + "Pistol";
				break;
			case RIFLE:
				toReturn += " " + "Rifle";
				break;
			case SUBMACHINE:
				toReturn += " " + "Submachine Gun";
				break;
			case MACHINE:
				toReturn += " " + "Machine Gun";
				break;
			case SHOTGUN:
				toReturn += " " + "Shotgun";
				break;
			case BEAM:
				toReturn += " " + "Beam Rifle";
				break;
			case MELEE:
				toReturn += " " + "Sword";
				break;	
			case SNIPER:
				toReturn += " " + "Sniper Rifle";
				break;
			default:
				toReturn += " " + "Rocket Launcher";
				break;
		}
		return toReturn;
	}

	
}
