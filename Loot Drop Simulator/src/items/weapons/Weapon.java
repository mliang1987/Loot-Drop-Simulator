package items.weapons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import items.*;
import items.weapons.WeaponAttributes;

/**
 * Class for representing a Weapon.  Contains class-based methods to generate and 
 * roll weapon attributes.
 * @author Michael Liang
 * @version 0.9
 */
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
	public enum Element{
		VOID,
		QUANTUM,
		ENTROPY;
	}
	
	protected Slot slot;
	protected Type type;
	protected Archetype archetype;
	protected int tier;
	
	 /**
	   * Constructor for the Weapon class.
	   * This class inherits properties from the Item class.
	   * @param slot 		Weapon equip slot: 	Primary, Secondary, or Tertiary
	   * @param type		Weapon type: 		Pistol, Rifle, SMG, Shotgun, Sniper, Beam Rifle, Melee, LMG, or Rocket 
	   * @param archetype	Weapon archetype: 	Heavy, Balanced, Rapid, or Light
	   * @param attributes	An array of doubles that contain attribute values for this specific weapon.
	   * @param itemLevel	An int representing the level of the zone the item dropped in.
	   * @param tier		An int representing the tier of weapon.
	   * @param name		A String representing the name of the item.
	   */
	public Weapon(Slot slot, Type type, Archetype archetype, double[] attributes, int itemLevel, int tier, String name) {
		super(Item.Type.WEAPON, Item.Rarity.COMMON, itemLevel, name, attributes);
		this.slot = slot;
		this.type = type;
		this.tier = tier;
		this.archetype=archetype;
	}
	
	public double calculateDPS() {
		double dps = 0;
		return dps;
	}
	
	/**
	 * Converts a WeaponPrefix to a String, scaled for this specific Weapon.
	 * @param wp A WeaponPrefix to convert to a String form.
	 * @return A String representing the WeaponPrefix.
	 */
	public String prefixToString(WeaponPrefix wp) {
		String toReturn = "";
		switch (wp.type) {
			case ADD:
				toReturn+= "Adds ";
				switch (wp.subtype) {
					case LOW_HIGH:
						toReturn+= (int) (wp.getValue()*this.attributes[WeaponAttributes.EFFECTIVNESS])
								+ "-"
								+ (int) Math.ceil(wp.getValue2()*this.attributes[WeaponAttributes.EFFECTIVNESS])
								+ " to ";
						break;
					case PERCENTAGE:
						toReturn+= (int) wp.getValue()
								+ "% ";
						break;
					default:
						toReturn+= (int) wp.getValue()
								+ " to ";
						break;

				}
				toReturn+= wp.stats.get(WeaponPrefix.TEXT) + "\n";
				break;
			default:
				toReturn+= (int) wp.getValue()
						+ "% increased "
						+ wp.stats.get(WeaponPrefix.TEXT)
						+ "\n";
				break;
		}		
		return toReturn;
	}
	
	/**
	 * Converts a WeaponSuffix to a String, scaled for this specific Weapon.
	 * @param wp A WeaponSuffix to convert to a String form.
	 * @return A String representing the WeaponSuffix.
	 */
	public String suffixToString(WeaponSuffix wp) {
		String toReturn = "";
		double value  = wp.getValue();
		switch (wp.type) {
			case ADD_100:
				toReturn+= "Adds "
						+ (int) Math.floor(value*100)
						+ "% to "
						+ wp.stats.get(WeaponSuffix.TEXT);
				break;
			case ADD_PERCENTAGE:
				toReturn+= (int) Math.floor(value)
						+ "% "
						+ wp.stats.get(WeaponSuffix.TEXT);
				break;
			case INCREASE_PERCENTAGE:
				toReturn+= (int) Math.floor(value)
						+ "% increased "
						+ wp.stats.get(WeaponSuffix.TEXT);
				break;
			default:
				toReturn+= Math.floor(value)
				+ " increased "
				+ wp.stats.get(WeaponSuffix.TEXT);
				break;
		}		
		return toReturn+"\n";
	}
	
	/**
	 * Converts this Weapon a String.
	 * @return A String representing this Weapon.
	 */
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
		if(attributes[WeaponAttributes.PRECISION_MULTIPLIER]>0) {
			toReturn+="Precision Multiplier: " 
					+ (int) (attributes[WeaponAttributes.PRECISION_MULTIPLIER]*100)
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
		toReturn+="Item Level: " + this.getItemLevel() +"\n-------------------------------\n";
		for(Affix aff : this.prefixes) {
			WeaponPrefix wp = (WeaponPrefix) aff;
			toReturn+= this.prefixToString(wp);
		}
		for(Affix aff : this.suffixes) {
			WeaponSuffix wp = (WeaponSuffix) aff;
			toReturn+= this.suffixToString(wp);
		}
		return toReturn;
	}
	
	/**
	 * Static type method for recalculating the prefix rolls for any Weapon.
	 * For every WeaponPrefix owned by the Weapon, the method recalculates
	 * the Weapon's attributes according to the prefixes.  Should only be utilized
	 * upon weapon generation!
	 * @param w Weapon to have its prefix rolls recalculated.
	 */
	public static void recalcPrefixRolls(Weapon w) {
		for(Affix a : w.prefixes) {
			WeaponPrefix wp = (WeaponPrefix) a;
			String n = wp.getName();
			if(n.startsWith("WEAPON_TIER")) {
				Weapon newWeap = generateWeapon(
						w.slot, 
						w.type, 
						w.archetype, 
						w.getItemLevel(), 
						(int) (w.tier+wp.getValue()));
				w.attributes[WeaponAttributes.KINETIC_LOW]=newWeap.attributes[WeaponAttributes.KINETIC_LOW];
				w.attributes[WeaponAttributes.KINETIC_HIGH]=newWeap.attributes[WeaponAttributes.KINETIC_HIGH];
				w.tier += (int)wp.getValue();
			}
			else if(n.startsWith("KINETIC_FLAT")) {
				w.attributes[WeaponAttributes.KINETIC_LOW]+=wp.getValue()*w.attributes[WeaponAttributes.EFFECTIVNESS];
				w.attributes[WeaponAttributes.KINETIC_HIGH]+=wp.getValue2()*w.attributes[WeaponAttributes.EFFECTIVNESS];
			}
			else if(n.startsWith("VOID_FLAT")) {
				w.attributes[WeaponAttributes.VOID_LOW]+=wp.getValue()*w.attributes[WeaponAttributes.EFFECTIVNESS];
				w.attributes[WeaponAttributes.VOID_HIGH]+=wp.getValue2()*w.attributes[WeaponAttributes.EFFECTIVNESS];				
			}
			else if(n.startsWith("QUANTUM_FLAT")) {
				w.attributes[WeaponAttributes.QUANTUM_LOW]+=wp.getValue()*w.attributes[WeaponAttributes.EFFECTIVNESS];
				w.attributes[WeaponAttributes.QUANTUM_HIGH]+=wp.getValue2()*w.attributes[WeaponAttributes.EFFECTIVNESS];
			}
			else if(n.startsWith("ENTROPY_FLAT")) {
				w.attributes[WeaponAttributes.ENTROPY_LOW]+=wp.getValue()*w.attributes[WeaponAttributes.EFFECTIVNESS];
				w.attributes[WeaponAttributes.ENTROPY_HIGH]+=wp.getValue2()*w.attributes[WeaponAttributes.EFFECTIVNESS];				
			}
			else if(n.startsWith("KINETIC_INCREASE")) {
				w.attributes[WeaponAttributes.KINETIC_LOW]*=(wp.getValue()/100)+1;
				w.attributes[WeaponAttributes.KINETIC_HIGH]*=(wp.getValue()/100)+1;				
			}
		}
	}
	
	/**
	 * Static method for recalculating the suffix rolls for any Weapon.
	 * For every WeaponSuffix owned by the Weapon, the method recalculates
	 * the Weapon's attributes according to the suffixes.  Should only be utilized
	 * upon weapon generation!
	 * @param w Weapon to have its suffix rolls recalculated.
	 */
	public static void recalcSuffixRolls(Weapon w) {
		for(Affix a: w.suffixes) {
			WeaponSuffix ws = (WeaponSuffix) a;
			if(ws.stats.get(WeaponSuffix.SCOPE).startsWith("L")) {
				String n = ws.stats.get(WeaponSuffix.ATTRIBUTE_TYPE);
				if(n.startsWith("CRITICAL_C")) {
					w.attributes[WeaponAttributes.CRITICAL_CHANCE]*=ws.getValue()/100+1;
				}
				else if(n.startsWith("CRITICAL_M")) {
					w.attributes[WeaponAttributes.CRITICAL_MULTIPLIER]+=ws.getValue();					
				}
				else if(n.startsWith("HAN")) {
					w.attributes[WeaponAttributes.HANDLING]*=ws.getValue()/100+1;
				}
				else if(n.startsWith("MAG")) {
					w.attributes[WeaponAttributes.MAGAZINE]*=ws.getValue()/100+1;
				}
				else if(n.startsWith("PREC")) {
					w.attributes[WeaponAttributes.PRECISION_MULTIPLIER]+=ws.getValue();					
				}
				else if(n.startsWith("RANGE")) {
					w.attributes[WeaponAttributes.RANGE]*=ws.getValue()/100+1;
				}
				else if(n.startsWith("RATE")) {
					w.attributes[WeaponAttributes.RATE_OF_FIRE]*=ws.getValue()/100+1;					
				}
				else if(n.startsWith("REL")) {
					w.attributes[WeaponAttributes.RELOAD_SPEED]*=ws.getValue()/100+1;			
				}
				else if(n.startsWith("RES")) {
					w.attributes[WeaponAttributes.RESERVE_AMMO]*=ws.getValue()/100+1;			
				}
				else if(n.startsWith("VEL")) {
					w.attributes[WeaponAttributes.VELOCITY]*=ws.getValue()/100+1;			
				}
			}
		}
	}
	
	/**
	 * Static helper method that generates a list of possible prefix names specific to a Weapon (based on item level and type).
	 * @param w The Weapon from which the method generates prefix names.
	 * @return An ArrayList of prefix name Strings.
	 */
	public static ArrayList<String> generatePossiblePrefixes(Weapon w){
		int level = w.getItemLevel();
		@SuppressWarnings("unchecked")
		ArrayList<String> toReturn = (ArrayList<String>) WeaponPrefix.getWeaponPrefixRange(level).clone();
		if(w.type == Weapon.Type.BEAM) {
			ArrayList<String> toRemove = new ArrayList<String>();
			for(String s: toReturn) {
				if(s.startsWith("KINETIC")) {
					toRemove.add(s);
				}
			}
			for(String s: toRemove) {
				toReturn.remove(s);
			}
		}
		return toReturn;
	}

	/**
	 * Static helper method that generates a list of possible suffix names specific to a Weapon (based on item level and type).
	 * @param w The Weapon from which the method generates suffix names.
	 * @return An ArrayList of suffix name Strings.
	 */
	public static ArrayList<String> generatePossibleSuffixes(Weapon w){
		int level = w.getItemLevel();
		@SuppressWarnings("unchecked")
		ArrayList<String> toReturn = (ArrayList<String>) WeaponSuffix.getWeaponSuffixRange(level).clone();
		if(w.type != Weapon.Type.ROCKET) {
			ArrayList<String> toRemove = new ArrayList<String>();
			for(String s: toReturn) {
				if(s.startsWith("VELOCITY")) {
					toRemove.add(s);
				}
			}
			for(String s: toRemove) {
				toReturn.remove(s);
			}
		}
		return toReturn;
	}
	
	/**
	 * Static helper method to set a weapon's energy damage according to the base
	 * energy damage roll and the energy type.
	 * @param weapon The Weapon for which the energy damage will be set by the method.
	 * @param energy An int representing energy type: 1->entropy, 2->quantum, 3->void
	 */
	static void setEnergyDamage(Weapon weapon, int energy) {
		weapon.attributes[WeaponAttributes.ENTROPY_LOW]=0;
		weapon.attributes[WeaponAttributes.ENTROPY_HIGH]=0;					
		weapon.attributes[WeaponAttributes.QUANTUM_LOW]=0;
		weapon.attributes[WeaponAttributes.QUANTUM_HIGH]=0;
		weapon.attributes[WeaponAttributes.VOID_LOW]=0;
		weapon.attributes[WeaponAttributes.VOID_HIGH]=0;
		switch (energy) {
			case 1:
				weapon.attributes[WeaponAttributes.ENTROPY_LOW]=weapon.attributes[WeaponAttributes.BASE_ENERGY_LOW]*weapon.tier;
				weapon.attributes[WeaponAttributes.ENTROPY_HIGH]=weapon.attributes[WeaponAttributes.BASE_ENERGY_HIGH]*weapon.tier;					
				break;
			case 2:
				weapon.attributes[WeaponAttributes.QUANTUM_LOW]=weapon.attributes[WeaponAttributes.BASE_ENERGY_LOW]*weapon.tier;
				weapon.attributes[WeaponAttributes.QUANTUM_HIGH]=weapon.attributes[WeaponAttributes.BASE_ENERGY_HIGH]*weapon.tier;
				break;
			default:
				weapon.attributes[WeaponAttributes.VOID_LOW]=weapon.attributes[WeaponAttributes.BASE_ENERGY_LOW]*weapon.tier;
				weapon.attributes[WeaponAttributes.VOID_HIGH]=weapon.attributes[WeaponAttributes.BASE_ENERGY_HIGH]*weapon.tier;
				break;
		}
	}
	
	/**
	 * Static method that rerolls a weapon into a rare version of it, with a random amount (>2) of affixes added.
	 * @param w The Weapon to reroll into a rare version.
	 * @return A rare version of the parameter Weapon.
	 */
	public static Weapon rerollWeaponToRare(Weapon w) {
		// Generate range of all possible prefixes and suffixes for a specific weapon
		ArrayList<String> possiblePrefixes = generatePossiblePrefixes(w);
		ArrayList<String> possibleSuffixes = generatePossibleSuffixes(w);
		
		// Reset weapon to base weapon.
		int energy = (int) w.attributes[WeaponAttributes.BASE_ENERGY_TYPE];
		Weapon weapon = generateWeapon(w.slot, w.type, w.archetype, w.getItemLevel(), w.tier);
		setEnergyDamage(weapon, energy);
		
		// Randomly determine how many affixes are necessary for new rare weapon.
		int[] affixRolls = Item.generateRareAffixAmounts();
		
		// Generate prefixes for new weapon and add to item prefix list.
		weapon.prefixes = new ArrayList<Affix>();
		ArrayList<String> prefixes = new ArrayList<String>(); 
		for(int p = 0; p< affixRolls[1]; p++) {
			Random random = new Random();
			String roll = possiblePrefixes.get(random.nextInt(possiblePrefixes.size()));
			prefixes.add(roll);
			ArrayList<String> toRemove = new ArrayList<String>();
			for(String s : possiblePrefixes) {
				if(s.substring(0,s.length()-2).equals(roll.substring(0,roll.length()-2))){
					toRemove.add(s);
				}
			}
			for(String s : toRemove) {
				possiblePrefixes.remove(s);
			}
		}		
		for(String s : prefixes) {
			ArrayList<String> tempAffix = WeaponPrefix.weaponPrefixes.get(s);
			String tempName = tempAffix.get(WeaponPrefix.ATTRIBUTE_TYPE)+"_"+tempAffix.get(WeaponPrefix.TIER);
			weapon.prefixes.add(new WeaponPrefix(tempName,tempAffix));
		}
		Collections.sort( weapon.prefixes, new AffixSorter());
		
		// Generate suffixes for new weapon and add to item suffix list.
		weapon.suffixes = new ArrayList<Affix>();
		ArrayList<String> suffixes = new ArrayList<String>(); 
		for(int p = 0; p< affixRolls[2]; p++) {
			Random random = new Random();
			String roll = possibleSuffixes.get(random.nextInt(possibleSuffixes.size()));
			suffixes.add(roll);
			ArrayList<String> toRemove = new ArrayList<String>();
			for(String s : possibleSuffixes) {
				if(s.substring(0,s.length()-2).equals(roll.substring(0,roll.length()-2))){
					toRemove.add(s);
				}
			}
			for(String s : toRemove) {
				possibleSuffixes.remove(s);
			}
		}		
		for(String s : suffixes) {
			ArrayList<String> tempAffix = WeaponSuffix.weaponSuffixes.get(s);
			String tempName = tempAffix.get(WeaponSuffix.ATTRIBUTE_TYPE)+"_"+tempAffix.get(WeaponSuffix.TIER);
			weapon.suffixes.add(new WeaponSuffix(tempName,tempAffix));
		}
		Collections.sort( weapon.suffixes, new AffixSorter());
		
		// Finalizes weapon setup by:
		// - Changing rarity.
		// - Generating new name.
		// - Recalculating the rolls based on the impact of the new affixes.
		weapon.changeRarity(Item.Rarity.RARE);
		weapon.changeItemName(Item.generateItemName(Item.Type.WEAPON, Item.Rarity.RARE, weapon.getItemName()));
		recalcPrefixRolls(weapon);
		recalcSuffixRolls(weapon);
		return weapon;
	}
	
	/**
	 * Static method that, given [slot, type, level, and tier] generates a Weapon with a random Archetype.  
	 * @param slot Weapon Slot enum: PRIMARY, SECONDARY, or TERTIARY
	 * @param type Weapon Type enum: PISTOL, RIFLE, SUBMACHINE, SHOTGUN, SNIPER, BEAM, MELEE, MACHINE, ROCKET
	 * @param zoneLevel The level of the item (based on the zone in which the item dropped.
	 * @param tier The tier of the weapon.
	 * @return A Weapon with a random Archetype and the specified parameters.
	 */
	public static Weapon generateRandomArchetypeWeapon(Slot slot, Type type, int zoneLevel, int tier) {
		Weapon.Archetype archetype = null;
		while(archetype == null || (slot==Slot.TERTIARY && archetype==Archetype.RAPID)) {
			archetype = Archetype.getRandomWeaponArchetype();
		}
		return generateWeapon(slot,type,archetype,zoneLevel,tier);	
	}
	
	/**
	 * Static method that, given [slot, type, level, and tier] generates a Weapon with a random Archetype.  
	 * @param slot Weapon Slot enum: PRIMARY, SECONDARY, or TERTIARY
	 * @param type Weapon Type enum: PISTOL, RIFLE, SUBMACHINE, SHOTGUN, SNIPER, BEAM, MELEE, MACHINE, ROCKET
	 * @param archetype Weapon Archetype enum: BALANCED, HEAVY, LIGHT, RAPID
	 * @param zoneLevel The level of the item (based on the zone in which the item dropped.
	 * @param tier The tier of the weapon.
	 * @return A Weapon with the specified parameters.
	 */
	public static Weapon generateWeapon(Slot slot, Type type, Archetype archetype, int zoneLevel, int tier) {
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
		toReturn.changeRarity(Item.Rarity.COMMON);
		return toReturn;
	}
	
	/**
	 * Static helper method that generates a random weapon tier, given the zone's level.
	 * @param zoneLevel The level of the current zone or dropped item.
	 * @return An int representing the randomly generated tier.
	 */
	public static int generateRandomTier(int zoneLevel) {
		int tierTop = (zoneLevel / 6 + 1 > 14) ? 14 : zoneLevel / 6 + 1;
		int tierBottom = 0;
		tierBottom = (tierTop - 6 >= 0) ? tierTop - 6 : 0;
		int tierRange = ((int) (Math.random() * (tierTop - tierBottom))) + 1;
		return tierBottom + tierRange;
	}
	
	/**
	 * Static helper method that generates a name for a weapon base.
	 * @param type Weapon Type enum: PISTOL, RIFLE, SUBMACHINE, SHOTGUN, SNIPER, BEAM, MELEE, MACHINE, ROCKET
	 * @param tier The tier of the weapon.
	 * @param archetype archetype Weapon Archetype enum: BALANCED, HEAVY, LIGHT, RAPID
	 * @return String representing the name of the base weapon.
	 */
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
