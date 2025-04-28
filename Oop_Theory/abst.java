package beforeMid;

abstract class mainabst{
	public int num = 9;
	public static int age = 20; //not nessasary to assign value first. Value can be change in the middle
	public final int count = 2; //must assign a value first. Value cannot be change in the middle
	public static void meth1() {
		age = 10;
		//num = 2; this is incorrect. because we cannot use 'non-static valiable' inside a static function(even inside the main method)
		System.out.println("This is a static method (meth1). age is " + age);
	};
	public final void meth2() {// this final method cannot be overridden by any subclass.
		age = 30;
		num = 2;
		System.out.println("This is a final method (meth2). age is "+age+". Num is "+num);
	}//; dont add semicolons at the end of this line
	abstract public void meth3();
	public mainabst() {
		System.out.println("This is mainabst");
	}
}
class child1 extends mainabst{
	public void meth3() {
		System.out.println("This is the meth 1");
		super.meth2();//final method is called
	}//implementation of parent's abstract methods are mandatory for all child classes other than abstract child classes.
	child1(){
		System.out.println("This is child1");
		super.meth1();//static method is called
	}
	public void m6() {
		System.out.println("This method can be accesed by objects referenced by child1 clz. Not by mainabs");
	}
	/*public final void meth2() {
		System.out.println("We can't override this final method (meth2)");
	} we can't override final methods. But we can override static methods(meth1)*/

}
abstract class child2 extends mainabst{	
	//we can omit implementation of parent's abstract methods if we define child classes as abstract classes
}

public abstract class abst extends mainabst{//I make this as a child because I wanted to access meth1() inside the main method
		//after making this class as a chid, we must override meth3() method. otherwise make this class as a abstract class to omit errors.
public static void main(String[] args) {
	//mainabst obj1 = new mainabst(); cannot create objects from abstact classes
	mainabst obj1 = new child1();//obj1 is refered by "mainabst clz"
	new child1();
	//obj2 = new child1(); wrong
	child1 obj2 = new child1();//obj1 is refered by "child1 clz"
	obj2.meth3();
	meth1(); //static methods can be called directly even without an object
	age = 120;
	//obj1.m6(); wrong. because obj1 is refered by parent clz. but the m6() is in child clz.
	obj2.m6();//correct
	/*  *This is mainabst
		 This is child1
		 This is a static method (meth1). age is 10
		*This is mainabst
		 This is child1
		 This is a static method (meth1). age is 10
		*This is mainabst
		 This is child1
		 This is a static method (meth1). age is 10
		*This is the meth 1
		 This is a final method (meth2). age is 30. Num is 2
		*This is a static method (meth1). age is 10
		*This method can be accesed by objects referenced by child1 clz. Not by mainabs
	*/
	
}
}
