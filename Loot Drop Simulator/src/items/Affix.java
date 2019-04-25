package items;

public class Affix {
	
	public enum Type {
		IMPLICIT, PREFIX, SUFFIX;
	}

	Type type;
	double low;
	double high;
	double value;
	String name;
	
	public Affix(Type t, String name, double low, double high) {
		this.type = t;
		this.low = low;
		this.high = high;
		this.name = name;
		this.value = low+(Math.random()*(high-low));
	}
	
	public Type getAffixType() {
		return this.type;
	}
	
	public String getAffixValueRange() {
		return "Affix: "+name+" | "+ "low: "+low + " | value: " + value + " | high: "+high;
	}
	
}
