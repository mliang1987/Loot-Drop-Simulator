package items;

public class ExplicitAffix extends Affix{

	public enum Type{
		PREFIX,
		SUFFIX;
	}
	
	Type type;
	
	public ExplicitAffix(Type type, String name, double low, double high, double low2, double high2, int priority, ExplicitAffix linked) {
		super(Affix.Type.IMPLICIT, name, low, high, low2, high2, priority, linked);		
		this.type = type;
	}
	
}
