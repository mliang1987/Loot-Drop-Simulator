package items;

public class Attribute {
	
	public enum Category{
		WEAPON, ARMOR, CHARACTER;
	}
	
	Category category;
	
	public Attribute(Category attributeCategory) {
		this.category = attributeCategory;
	}
	
	public Category getAttributeCategory() {
		return category;
	}
	
}
