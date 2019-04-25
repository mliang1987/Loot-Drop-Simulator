package items.weapons;

import items.weapons.Weapon.*;

public class WeaponGenerator {

	public static Weapon generateWeapon(Weapon.Slot slot, Weapon.Type type, int zoneLevel) {
		double[] attributes = new double[WeaponAttributes.NUMBER_OF_WEAPON_ATTRIBUTES];
		attributes[WeaponAttributes.PROJECTILES] = 1;
		attributes[WeaponAttributes.VELOCITY] = 2000;
		attributes[WeaponAttributes.CRITICAL_MULTIPLIER] = 1.25;
		if(type == Weapon.Type.SHOTGUN) {
			attributes[WeaponAttributes.PROJECTILES] = 8;
		}
		if(type == Weapon.Type.LAUNCHER) {
			attributes[WeaponAttributes.VELOCITY] = 40 + ((36)*Math.random());
			attributes[WeaponAttributes.CRITICAL_MULTIPLIER] = 0;			
		}
		int tier = generateRandomTier(zoneLevel);
		String name = generateBaseName(type, tier);
		attributes[WeaponAttributes.KINETIC_DAMAGE] = generateKineticRoll(type,tier);
		attributes[WeaponAttributes.RANGE] = generateRangeRoll(type,tier);
		attributes[WeaponAttributes.HANDLING] = generateHandlingRoll(type,tier);
		attributes[WeaponAttributes.RELOAD_SPEED] = generateReloadRoll(type,tier);
		attributes[WeaponAttributes.RATE_OF_FIRE] = generateROFRoll(type,tier);
		attributes[WeaponAttributes.MAGAZINE] = generateMagazineRoll(type,tier);
		attributes[WeaponAttributes.RESERVES] = generateReservesRoll(type,tier);
		attributes[WeaponAttributes.CRITICAL_CHANCE] = generateCritChanceRoll(type,tier);
		attributes[WeaponAttributes.AIM_ASSIST] = generateAimAssistRoll(type,tier);
		attributes[WeaponAttributes.PRECISION_MULTIPLIER] = generatePrecisionMultiRoll(type,tier);
		attributes[WeaponAttributes.SPREAD] = generateSpreadRoll(type,tier);
		attributes[WeaponAttributes.BLAST_RADIUS] = generateBlastRoll(type,tier);
		attributes[WeaponAttributes.STABILITY] = generateStabilityRoll(type,tier);
				
		Weapon toReturn = new Weapon(slot, type, attributes, zoneLevel, name);
		System.out.println(toReturn);
		return toReturn;
	}

	private static double generateStabilityRoll(Type type, int tier) {
		int bottomRoll = 25;
		int topRoll = 50;
		return bottomRoll + ((topRoll-bottomRoll)*Math.random());
	}

	private static double generateBlastRoll(Type type, int tier) {
		if(type == Weapon.Type.LAUNCHER) {
			return 15 + ((10)*Math.random());
		}
		return 0;
	}
	private static double generateSpreadRoll(Type type, int tier) {
		if(type == Weapon.Type.SHOTGUN) {
			return 1 + ((2)*Math.random());
		}
		return 0;
	}

	private static double generatePrecisionMultiRoll(Type type, int tier) {
		switch(type){
		case PISTOL:
			return 1.8;
		case RIFLE:
			return 2.0;
		case SUBMACHINE:
			return 1.8;
		case MACHINE:
			return 1.8;
		case SHOTGUN:
			return 10;
		case SNIPER:
			return 3;
		default:
			return 1;
		}
	}

	private static double generateAimAssistRoll(Type type, int tier) {
		switch(type){
		case PISTOL:
			return 60;
		case RIFLE:
			return 30;
		case SUBMACHINE:
			return 50;
		case MACHINE:
			return 70;
		case SHOTGUN:
			return 25;
		case SNIPER:
			return 40;
		default:
			return 10;
		}
	}

	private static double generateCritChanceRoll(Type type, int tier) {
		int bottomRoll;
		int topRoll;
		switch(type){
		case PISTOL:
			bottomRoll = 4;
			topRoll = 6;
			break;
		case RIFLE:
			bottomRoll = 4;
			topRoll = 6;
			break;
		case SUBMACHINE:
			bottomRoll = 6;
			topRoll = 8;
			break;
		case MACHINE:
			bottomRoll = 4;
			topRoll = 6;
			break;
		case SHOTGUN:
			bottomRoll = 2;
			topRoll = 5;
			break;
		case SNIPER:
			bottomRoll = 6;
			topRoll = 8;
			break;
		default:
			bottomRoll = 0;
			topRoll = 0;
			break;
		}
		return bottomRoll + ((topRoll-bottomRoll)*Math.random());
	}

	private static double generateReservesRoll(Type type, int tier) {
		int bottomRoll;
		int topRoll;
		switch(type){
		case PISTOL:
			bottomRoll = 64;
			topRoll = 80;
			break;
		case RIFLE:
			bottomRoll = 112;
			topRoll = 128;
			break;
		case SUBMACHINE:
			bottomRoll = 304;
			topRoll = 360;
			break;
		case MACHINE:
			bottomRoll = 336;
			topRoll = 384;
			break;
		case SHOTGUN:
			bottomRoll = 22;
			topRoll = 32;
			break;
		case SNIPER:
			bottomRoll = 22;
			topRoll = 32;
			break;
		default:
			bottomRoll = 6;
			topRoll = 10;
			break;
		}
		return bottomRoll + ((topRoll-bottomRoll)*Math.random());
	}
	private static double generateMagazineRoll(Type type, int tier) {
		int bottomRoll;
		int topRoll;
		switch(type){
		case PISTOL:
			bottomRoll = 8;
			topRoll = 12;
			break;
		case RIFLE:
			bottomRoll = 14;
			topRoll = 18;
			break;
		case SUBMACHINE:
			bottomRoll = 38;
			topRoll = 42;
			break;
		case MACHINE:
			bottomRoll = 42;
			topRoll = 54;
			break;
		case SHOTGUN:
			bottomRoll = 4;
			topRoll = 8;
			break;
		case SNIPER:
			bottomRoll = 3;
			topRoll = 6;
			break;
		default:
			bottomRoll = 1;
			topRoll = 2;
			break;
		}
		return bottomRoll + ((topRoll-bottomRoll)*Math.random());
	}
	private static double generateReloadRoll(Type type, int tier) {
		int bottomRoll;
		int topRoll;
		switch(type){
		case PISTOL:
			bottomRoll = 21;
			topRoll = 38;
			break;
		case RIFLE:
			bottomRoll = 25;
			topRoll = 45;
			break;
		case SUBMACHINE:
			bottomRoll = 24;
			topRoll = 32;
			break;
		case MACHINE:
			bottomRoll = 59;
			topRoll = 68;
			break;
		case SHOTGUN:
			bottomRoll = 35;
			topRoll = 44;
			break;
		case SNIPER:
			bottomRoll = 32;
			topRoll = 42;
			break;
		default:
			bottomRoll = 28;
			topRoll = 45;
			break;
		}
		return bottomRoll + ((topRoll-bottomRoll)*Math.random());
	}
	private static double generateHandlingRoll(Type type, int tier) {
		int bottomRoll;
		int topRoll;
		switch(type){
		case PISTOL:
			bottomRoll = 22;
			topRoll = 37;
			break;
		case RIFLE:
			bottomRoll = 30;
			topRoll = 39;
			break;
		case SUBMACHINE:
			bottomRoll = 25;
			topRoll = 35;
			break;
		case MACHINE:
			bottomRoll = 34;
			topRoll = 40;
			break;
		case SHOTGUN:
			bottomRoll = 30;
			topRoll = 35;
			break;
		case SNIPER:
			bottomRoll = 25;
			topRoll = 45;
			break;
		default:
			bottomRoll = 45;
			topRoll = 55;
			break;
		}
		return bottomRoll + ((topRoll-bottomRoll)*Math.random());
	}
	private static double generateROFRoll(Type type, int tier) {
		switch(type){
		case PISTOL:
			return 110;
		case RIFLE:
			return 150;
		case SUBMACHINE:
			return 600;
		case MACHINE:
			return 450;
		case SHOTGUN:
			return 55;
		case SNIPER:
			return 72;
		default:
			return 15;
		}
	}
	private static double generateRangeRoll(Type type, int tier) {
		int bottomRoll;
		int topRoll;
		switch(type){
		case PISTOL:
			bottomRoll = 55;
			topRoll = 70;
			break;
		case RIFLE:
			bottomRoll = 70;
			topRoll = 85;
			break;
		case SUBMACHINE:
			bottomRoll = 45;
			topRoll = 60;
			break;
		case MACHINE:
			bottomRoll = 60;
			topRoll = 75;
			break;
		case SHOTGUN:
			bottomRoll = 35;
			topRoll = 50;
			break;
		case SNIPER:
			bottomRoll = 90;
			topRoll = 120;
			break;
		default:
			bottomRoll = 2000;
			topRoll = 2000;
			break;
		}
		return bottomRoll + ((topRoll-bottomRoll)*Math.random());
	}
	private static double generateKineticRoll(Type type, int tier) {
		double baseBottomRoll = 0;
		double baseTopRoll = 0;
		switch(type){
		case PISTOL:
			baseBottomRoll = 10;
			baseTopRoll = 15;
			break;
		case RIFLE:
			baseBottomRoll = 8;
			baseTopRoll = 12;
			break;
		case SUBMACHINE:
			baseBottomRoll = 2;
			baseTopRoll = 3;
			break;
		case MACHINE:
			baseBottomRoll = 6;
			baseTopRoll = 9;
			break;
		case SHOTGUN:
			baseBottomRoll = 8;
			baseTopRoll = 12;
			break;
		case SNIPER:
			baseBottomRoll = 35;
			baseTopRoll = 52;
			break;
		default:
			baseBottomRoll = 240;
			baseTopRoll = 280;
			break;
		}
		for(int i = 1; i<tier; i++) {
			baseBottomRoll*=WeaponAttributes.KINETIC_SCALING_RATIO;
			baseTopRoll*=WeaponAttributes.KINETIC_SCALING_RATIO; 
		}
		return baseBottomRoll + ((baseTopRoll-baseBottomRoll)*Math.random());
	}
	public static int generateRandomTier(int zoneLevel) {
		int tierTop = (zoneLevel / 6 + 1 > 14) ? 14 : zoneLevel / 6 + 1;
		int tierBottom = (tierTop - 6 >= 0) ? tierTop - 6 : 0;
		int tierRange = ((int) (Math.random() * (tierTop - tierBottom))) + 1;
		return tierBottom + tierRange;
	}
	public static String generateBaseName(Weapon.Type type, int tier) {
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
			case SNIPER:
				toReturn += " " + "Sniper Rifle";
				break;
			default:
				toReturn += " " + "Rocket Launcher";
				break;
		}
		return toReturn;
	}

	public static void main(String[] args) {
		for(int i = 5; i<=100; i+=5) {
			generateWeapon(Weapon.Slot.PRIMARY, Weapon.Type.PISTOL,i);
			generateWeapon(Weapon.Slot.PRIMARY, Weapon.Type.RIFLE,i);
			generateWeapon(Weapon.Slot.PRIMARY, Weapon.Type.SUBMACHINE,i);
			generateWeapon(Weapon.Slot.SECONDARY, Weapon.Type.SHOTGUN,i);
			generateWeapon(Weapon.Slot.SECONDARY, Weapon.Type.SNIPER,i);
			generateWeapon(Weapon.Slot.TERTIARY, Weapon.Type.LAUNCHER,i);
			generateWeapon(Weapon.Slot.TERTIARY, Weapon.Type.MACHINE,i);
			System.out.println("----------End of Level: "+i+"----------");
		}
	}

}
