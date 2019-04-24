package items;

public class Affix {
	
	public enum Type {
		IMPLICIT, PREFIX, SUFFIX;
	}

	Type type;
	
	public Affix(Type t) {
		this.type = t;
	}
	
	public Type getAffixType() {
		return this.type;
	}
	
}
