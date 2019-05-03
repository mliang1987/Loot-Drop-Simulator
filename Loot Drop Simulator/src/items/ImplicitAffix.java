package items;

public class ImplicitAffix extends Affix{

	public ImplicitAffix(String name, double low, double high, double low2, double high2, int priority, ImplicitAffix linked) {
		super(Affix.Type.IMPLICIT, name, low, high,low2, high2, priority, linked);	
	}
	
}
