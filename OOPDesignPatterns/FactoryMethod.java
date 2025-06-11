package beforefinal;

/*
FactoryMethod/
├── Animal.java
├── Dog.java
├── Cat.java
├── AnimalFactory.java //a abstract class
├── DogFactory.java
├── CatFactory.java
└── Main.java
*/

//Animal.java
interface Animal2 {
  void speak();
}
//Dog.java
class Dog2 implements Animal2 {
  public void speak() {
      System.out.println("Woof!");
  }
}
//Cat.java
class Cat2 implements Animal2 {
  public void speak() {
      System.out.println("Meow!");
  }
}
//AnimalFactory.java
abstract class AnimalFactory2 {
    public abstract Animal2 createAnimal();
}
//DogFactory.java
class DogFactory2 extends AnimalFactory2 {
    public Animal2 createAnimal() { 
        return new Dog2();
    }
}
//CatFactory.java
class CatFactory2 extends AnimalFactory2 {
    public Animal2 createAnimal() {
        return new Cat2();
    }
}
//Main.java
class Main2 {
    public static void main(String[] args) {
        AnimalFactory2 dogFactory = new DogFactory2();
        Animal2 dog = dogFactory.createAnimal();
        dog.speak();  // Output: Woof!

        AnimalFactory2 catFactory = new CatFactory2();
        Animal2 cat = catFactory.createAnimal();
        cat.speak();  // Output: Meow!
    }
}

