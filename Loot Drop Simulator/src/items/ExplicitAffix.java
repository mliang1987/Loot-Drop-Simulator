package items;

public class ExplicitAffix extends Affix{

	public enum Type{
		PREFIX,
		SUFFIX;
	}
	
	Type type;
	
	public ExplicitAffix(Type type, String name, double low, double high, ExplicitAffix linked) {
		super(Affix.Type.IMPLICIT, name, low, high, linked);		
		this.type = type;
	}
	
}
