import items.*;
import items.armor.*;
import items.weapons.*;

public class MainTester {
	public static void main(String[] args) {
		Affix a = new Affix(Affix.Type.PREFIX,"Vicious ", 10, 30);
		System.out.println(a.getAffixType());
		System.out.println(a.getAffixValueRange());
		
		double[] b_values = {10,10,10,10,10,10,10,10,10,10};
		Weapon b = new Weapon(Weapon.Type.RIFLE, b_values, 0, a, null, null);
		System.out.println(b.getWeaponType());
		System.out.println(b.getItemType());
		
		Armor c = new Armor(Armor.Type.CLASS);
		System.out.println(c.getArmorType());
		System.out.println(c.getItemType());
	}
}
