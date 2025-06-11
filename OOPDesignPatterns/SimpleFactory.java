package beforefinal;
/*
SimpleFactory/
├── Animal.java
├── Dog.java
├── Cat.java
├── AnimalFactory.java //a normal class
└── Main.java
*/

//Animal.java
interface Animal {
    void speak();
}
//Dog.java
class Dog implements Animal {
    public void speak() {
        System.out.println("Woof!");
    }
}
//Cat.java
class Cat implements Animal {
    public void speak() {
        System.out.println("Meow!");
    }
}
//AnimalFactory.java
class AnimalFactory {
    public static Animal getAnimal(String type) {
        if (type == null) {
            return null;
        }

        if (type.equalsIgnoreCase("dog")) {
            return new Dog();
        } else if (type.equalsIgnoreCase("cat")) {
            return new Cat();
        }

        return null;
    }
}
//Main.java
class Main {
    public static void main(String[] args) {
        Animal animal1 = AnimalFactory.getAnimal("dog");
        animal1.speak();  // Output: Woof!

        Animal animal2 = AnimalFactory.getAnimal("cat");
        animal2.speak();  // Output: Meow!
    }
}



