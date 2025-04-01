package pk1;

/*Create a class called "Product" with attributes (int) productId, (String) name, and (double) price. 
Include an overloaded constructor to initialize these attributes. Create a getter and a setter for productId. 
Implement a method called "displayDetails" to print the values of the above attributes.
Create a class called "Electronics" that extends the Product class. 
Add additional attributes: (String) brand and (String) model.
Create a class called "Clothing" that extends the Product class. Add (String) size and (String) color 
as specific attributes to the Clothing class.
Implement an overloaded constructor for each class (Clothing and Electronics). 
Implement a method called "display" in both classes to display all the details of each object.
(Hint: The display() method in the Clothing class should display productId, name, price, size, and color. 
The display() method in the Electronics class should display productId, name, price, brand, and model.)
Create another class called "ShoppingCart" with a main method. Create two objects (one from Clothing and 
one from Electronics) and display their details by calling the appropriate methods. */

class Product{
	private int productID;
	private String name;
	private double price;
	public Product(int productID, String name, double price) {
		this.productID = productID;
		this.name = name;
		this.price = price;
	}
	public int getProductID() {
		return productID;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void displayDetails() {
		System.out.println("ID is "+productID+". Name is "+name+". It's price is Rs. "+price);
	}
	
}
class Electronics extends Product {
	private String brand;
	private String model;
	public Electronics(int productID, String name, double price, String brand, String model) {
		super(productID, name, price);//call the superclass overload constructor
		this.brand = brand;
		this.model = model;
	}
	public void display() {
		displayDetails(); //display superclass attributes
		System.out.println("Electronic Brand is "+brand+". model is "+model+"\n");
	}
	
	
}
class Clothing extends Product {
	private String size;
	private String color;
	public Clothing(int productID, String name, double price, String size, String color) {
		super(productID, name, price);
		this.size = size;
		this.color = color;
	}
	public void display() {
		displayDetails();
		System.out.println("Clothing size is "+size+". color is "+color+"\n");
	}
	
	
}

public class ShoppingCart { //all classes must be default(not public) other than ShoppingCart class
 public static void main(String[] args) {
	Clothing cl = new Clothing(123 , "levis", 2300.00, "M", "Red");
	Electronics el = new Electronics(444, "Laptop", 5400.00, "Dell", "Inspiron 15");

	cl.display();
	el.display();
}
}

/*Output :
ID is 123. Name is levis. It's price is Rs. 2300.0
Clothing size is M. color is Red

ID is 444. Name is Laptop. It's price is Rs. 5400.0
Electronic Brand is Dell. model is Inspiron 15 */
