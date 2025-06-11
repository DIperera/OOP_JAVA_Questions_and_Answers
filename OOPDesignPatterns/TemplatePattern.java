package beforefinal;

//Abstract Class (Template)
abstract class Beverage {
 // Template method
 public final void prepareRecipe() {
     boilWater();
     brew(); 
     pourInCup(); 
     addCondiments(); 
 }

 // Common steps
 void boilWater() {
     System.out.println("Boiling water");
 }

 void pourInCup() {
     System.out.println("Pouring into cup");
 }

 // Abstract steps to be implemented by subclasses
 abstract void brew();
 abstract void addCondiments();
}

//Concrete Class: Tea
class Tea extends Beverage {
 void brew() {
     System.out.println("Steeping the tea");
 }

 void addCondiments() {
     System.out.println("Adding lemon");
 }
}

//Concrete Class: Coffee
class Coffee extends Beverage {
 void brew() {
     System.out.println("Dripping coffee through filter");
 }

 void addCondiments() {
     System.out.println("Adding sugar and milk");
 }
}

//Client
class TemplatePatternExample {
 public static void main(String[] args) {
     Beverage tea = new Tea();
     System.out.println("Making tea...");
     tea.prepareRecipe();

     System.out.println();

     Beverage coffee = new Coffee();
     System.out.println("Making coffee...");
     coffee.prepareRecipe();
 }
}
/*Making tea...
Boiling water
Steeping the tea
Pouring into cup
Adding lemon

Making coffee...
Boiling water
Dripping coffee through filter
Pouring into cup
Adding sugar and milk
*/
