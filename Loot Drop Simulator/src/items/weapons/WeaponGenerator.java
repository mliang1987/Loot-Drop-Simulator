package items.weapons;

import items.Item;
import items.weapons.Weapon.*;

public class WeaponGenerator {

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
