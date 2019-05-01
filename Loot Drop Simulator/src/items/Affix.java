package items;

public class Affix {
	
	public enum Type {
		IMPLICIT, EXPLICIT;
	}

	Type type;
	double low;
	double high;
	String name;
	Affix linkedAffix;
	
	public Affix(Type t, String name, double low, double high, Affix link) {
		this.type = t;
		this.low = low;
		this.high = high;
		this.name = name;
		this.linkedAffix=link;
	}
	
	public Type getAffixType() {
		return this.type;
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
	
}
