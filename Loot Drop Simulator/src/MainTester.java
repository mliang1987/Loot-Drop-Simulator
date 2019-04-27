import items.*;
import items.weapons.*;

public class MainTester {
	public static void main(String[] args) {
		weaponGenerationTesting();
	}
	
	public static void weaponGenerationTesting() {
		WeaponAttributes.initialize();
		ItemNames.initialize();
		for(int i = 5; i<=100; i+=5) {
			WeaponGenerator.generateWeapon(Weapon.Slot.PRIMARY, Weapon.Type.PISTOL,i);
			WeaponGenerator.generateWeapon(Weapon.Slot.PRIMARY, Weapon.Type.RIFLE,i);
			WeaponGenerator.generateWeapon(Weapon.Slot.PRIMARY, Weapon.Type.SUBMACHINE,i);
			WeaponGenerator.generateWeapon(Weapon.Slot.SECONDARY, Weapon.Type.SHOTGUN,i);
			WeaponGenerator.generateWeapon(Weapon.Slot.SECONDARY, Weapon.Type.SNIPER,i);
			WeaponGenerator.generateWeapon(Weapon.Slot.SECONDARY, Weapon.Type.BEAM,i);
			WeaponGenerator.generateWeapon(Weapon.Slot.TERTIARY, Weapon.Type.ROCKET,i);
			WeaponGenerator.generateWeapon(Weapon.Slot.TERTIARY, Weapon.Type.MACHINE,i);
			WeaponGenerator.generateWeapon(Weapon.Slot.TERTIARY, Weapon.Type.MELEE,i);
			
			System.out.println("------------End of Level: "+i+"------------\n");
		}
	}
}
