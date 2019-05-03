package items;

import java.util.Comparator;
import java.util.Random;

import items.weapons.WeaponPrefix;

public class Affix {
	
	public enum Type {
		IMPLICIT, EXPLICIT;
	}

	Type type;
	protected double low;
	protected double high;
	protected double low2;
	protected double high2;
	private double value;
	private double value2;
	private int priority;
	String name;
	Affix linkedAffix;
	
	public Affix(Type t, String name, double low, double high, double low2, double high2, int priority, Affix link) {
		this.type = t;
		this.low = low;
		this.high = high;
		this.name = name;
		this.linkedAffix=link;
		this.low2 = low2;
		this.high2 = high2;
		this.setPriority(priority);
		Random r = new Random();
		setValue(low + (high - low) * r.nextDouble());
		setValue2(low2 + (high2 - low2) * r.nextDouble());
	}


	public Type getAffixType() {
		return this.type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getAffixLowValue() {
		return this.low;
	}
	public double getAffixHighValue() {
		return this.high;
	}
	public void setAffixLowValue(double v) {
		this.low = v;
	}
	public void setAffixHighValue(double v) {
		this.high = v;
	}
	
	public String getAffixValueRange() {
		return "Affix: "+name+" | "+ "low: "+low + " | high: "+high;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getValue2() {
		return value2;
	}

	public void setValue2(double value2) {
		this.value2 = value2;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}

}


