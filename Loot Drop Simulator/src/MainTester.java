import items.*;
import items.weapons.*;

public class MainTester {
	public static void main(String[] args) {
		WeaponAttributes.initialize();
		ItemNames.initialize();
		WeaponPrefix.initialize();
//		weaponGenerationTesting();
//		weaponPrefixTesting();
		weaponRerollTesting();
	}
	
	public static void weaponGenerationTesting() {

		for(int i = 5; i<=100; i+=5) {
			Weapon.generateWeapon(Weapon.Slot.PRIMARY, Weapon.Type.PISTOL,i,Weapon.generateRandomTier(i));
			Weapon.generateWeapon(Weapon.Slot.PRIMARY, Weapon.Type.RIFLE,i,Weapon.generateRandomTier(i));
			Weapon.generateWeapon(Weapon.Slot.PRIMARY, Weapon.Type.SUBMACHINE,i,Weapon.generateRandomTier(i));
			Weapon.generateWeapon(Weapon.Slot.SECONDARY, Weapon.Type.SHOTGUN,i,Weapon.generateRandomTier(i));
			Weapon.generateWeapon(Weapon.Slot.SECONDARY, Weapon.Type.SNIPER,i,Weapon.generateRandomTier(i));
			Weapon.generateWeapon(Weapon.Slot.SECONDARY, Weapon.Type.BEAM,i,Weapon.generateRandomTier(i));
			Weapon.generateWeapon(Weapon.Slot.TERTIARY, Weapon.Type.ROCKET,i,Weapon.generateRandomTier(i));
			Weapon.generateWeapon(Weapon.Slot.TERTIARY, Weapon.Type.MACHINE,i,Weapon.generateRandomTier(i));
			Weapon.generateWeapon(Weapon.Slot.TERTIARY, Weapon.Type.MELEE,i,Weapon.generateRandomTier(i));
			
			System.out.println("------------End of Level: "+i+"------------\n");
		}
	}
	public static void weaponPrefixTesting() {
		for(int i = 1; i<=100; i++) {
			System.out.println(i+": "+WeaponPrefix.getWeaponPrefixRange(i).size());			
		}
	}
	public static void weaponRerollTesting() {
		int i = (int) (Math.random()*100) +1;
		Weapon w = Weapon.generateWeapon(Weapon.Slot.PRIMARY, Weapon.Type.RIFLE,i,Weapon.generateRandomTier(i));
		Weapon.rerollRareWeapon(w, Item.Rarity.RARE);
	}
	
}
