import java.util.ArrayList;

import items.*;
import items.weapons.*;

public class MainTester {
	public static void main(String[] args) {
		WeaponAttributes.initialize();
		ItemNames.initialize();
		WeaponPrefix.initialize();
		WeaponSuffix.initialize();
//		weaponGenerationTesting();
//		weaponPrefixTesting();
		weaponRerollTesting();
	}
	
	public static void weaponGenerationTesting() {
		ArrayList<Weapon> theWeapons = new ArrayList<Weapon>();
		for(int i = 5; i<=100; i+=5) {
			theWeapons.add(Weapon.generateRandomArchetypeWeapon(Weapon.Slot.PRIMARY, Weapon.Type.PISTOL,i,Weapon.generateRandomTier(i)));
			theWeapons.add(Weapon.generateRandomArchetypeWeapon(Weapon.Slot.PRIMARY, Weapon.Type.RIFLE,i,Weapon.generateRandomTier(i)));
			theWeapons.add(Weapon.generateRandomArchetypeWeapon(Weapon.Slot.PRIMARY, Weapon.Type.SUBMACHINE,i,Weapon.generateRandomTier(i)));
			theWeapons.add(Weapon.generateRandomArchetypeWeapon(Weapon.Slot.SECONDARY, Weapon.Type.SHOTGUN,i,Weapon.generateRandomTier(i)));
			theWeapons.add(Weapon.generateRandomArchetypeWeapon(Weapon.Slot.SECONDARY, Weapon.Type.SNIPER,i,Weapon.generateRandomTier(i)));
			theWeapons.add(Weapon.generateRandomArchetypeWeapon(Weapon.Slot.SECONDARY, Weapon.Type.BEAM,i,Weapon.generateRandomTier(i)));
			theWeapons.add(Weapon.generateRandomArchetypeWeapon(Weapon.Slot.TERTIARY, Weapon.Type.ROCKET,i,Weapon.generateRandomTier(i)));
			theWeapons.add(Weapon.generateRandomArchetypeWeapon(Weapon.Slot.TERTIARY, Weapon.Type.MACHINE,i,Weapon.generateRandomTier(i)));
			theWeapons.add(Weapon.generateRandomArchetypeWeapon(Weapon.Slot.TERTIARY, Weapon.Type.MELEE,i,Weapon.generateRandomTier(i)));
		}
		for(Weapon w: theWeapons) {
			System.out.println(w);
		}
	}
	public static void weaponPrefixTesting() {
		for(int i = 1; i<=100; i++) {
			System.out.println(i+": "+WeaponPrefix.getWeaponPrefixRange(i).size());			
		}
	}
	public static void weaponRerollTesting() {
		for(int zoneLevel = 1; zoneLevel<=100; zoneLevel++) {
			Weapon.Slot slot;
			Weapon.Type type = Weapon.Type.getRandomWeaponType();
			if(type == Weapon.Type.PISTOL ||type == Weapon.Type.RIFLE || type == Weapon.Type.SUBMACHINE ) {
				slot = Weapon.Slot.PRIMARY;
			}
			else if(type == Weapon.Type.SHOTGUN ||type == Weapon.Type.SNIPER || type == Weapon.Type.BEAM) {
				slot = Weapon.Slot.SECONDARY;
			}
			else {
				slot = Weapon.Slot.TERTIARY;
			}
			Weapon w = Weapon.generateRandomArchetypeWeapon(slot, type, zoneLevel, Weapon.generateRandomTier(zoneLevel));
			System.out.println(w);
			w = Weapon.rerollWeaponToRare(w);
			System.out.println(w);
		}
	}
	
}
