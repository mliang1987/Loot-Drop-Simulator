package items;

public class ImplicitAffix extends Affix{

	public ImplicitAffix(String name, double low, double high,ImplicitAffix linked) {
		super(Affix.Type.IMPLICIT, name, low, high,linked);	
	}
	
}
