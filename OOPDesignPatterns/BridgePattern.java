package beforefinal;

//Implementor
interface Color { 
 void applyColor();
}

//Concrete Implementors
class RedColor implements Color {
 public void applyColor() {
     System.out.println("Applying red color.");
 }
}

class BlueColor implements Color {
 public void applyColor() {
     System.out.println("Applying blue color."); 
 }
}

//Abstraction
abstract class Shape {
 protected Color color;  // Bridge reference

 public Shape(Color color) {
     this.color = color;
 }

 abstract void draw();
}

//Refined Abstractions
class Circle extends Shape {  
 public Circle(Color color) {
     super(color);
 }

 public void draw() {
     System.out.print("Drawing Circle: ");
     color.applyColor();
 }
}

class Square extends Shape {
 public Square(Color color) {
     super(color);
 }

 public void draw() {
     System.out.print("Drawing Square: ");
     color.applyColor();
 }
}

//Client
class BridgePatternExample {
 public static void main(String[] args) {
     Shape redCircle = new Circle(new RedColor());  
     //Shape blueSquare = new Square(new BlueColor());

     redCircle.draw();
     //blueSquare.draw();
 }
}
