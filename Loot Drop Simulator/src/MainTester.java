import items.*;
import items.armor.*;
import items.weapons.*;

public class MainTester {
	public static void main(String[] args) {
		Affix a = new Affix(Affix.Type.PREFIX);
		System.out.println(a.getAffixType());
		
		Weapon b = new Weapon(Weapon.Type.RIFLE);
		System.out.println(b.getWeaponType());
		System.out.println(b.getItemType());
		
		Armor c = new Armor(Armor.Type.CLASS);
		System.out.println(c.getArmorType());
		System.out.println(c.getItemType());
	}
}
