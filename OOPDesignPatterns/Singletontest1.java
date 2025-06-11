package beforefinal;

class Class1 {
    private static Class1 instance; //static obj "variable" name with reference, the is no object in this just a object variable so initially this is null

    private Class1() { //private constructor
        System.out.println("Class1 Singleton created");
    }

    public static Class1 getInstance() {//if we use single lock method we use synchronized keyword here 'public static synchronized Class1 getInstance()'
    	//using double lock method
        if (instance == null) {// 🔍 First check - no lock yet
            synchronized (Class1.class) {// 🔒 Lock only when needed //synchronized is used to make this thread-safe 
                if (instance == null) { // 🔍 Second check - double verify
                    instance = new Class1();//actual creation of the object
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Class1 Singleton!");
    }
}
public class Singletontest1 {
    public static void main(String[] args) {
        Class1 c = Class1.getInstance();//here object creating function is called instead of calling the constructor
        c.showMessage();
    }
}
