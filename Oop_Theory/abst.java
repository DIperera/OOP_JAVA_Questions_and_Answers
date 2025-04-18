package beforeMid;

abstract class mainabst{
	public static int age = 20;
	public final int count = 2;
	public static void meth1() {
		System.out.println("This is a static method (meth1)");
	};
	public final void meth2() {
		System.out.println("This is a final method (meth2)");
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
	}//implementation of parent's abstract methods are mandatory for all child classes.
	child1(){
		System.out.println("This is child1");
		super.meth1();//static method is called
	}
}
public class abst {
public static void main(String[] args) {
	//mainabst obj1 = new mainabst(); cannot create objects from abstact classes
	mainabst obj1 = new child1();//The most correct method
	new child1();
	//obj2 = new child1(); wrong
	child1 obj2 = new child1();//correct and run as usual
	obj2.meth3();
	/* *This is mainabst
		This is child1
		This is a static method (meth1)
	   *This is mainabst
		This is child1
		This is a static method (meth1)
	   *This is mainabst
		This is child1
		This is a static method (meth1)
	   *This is the meth 1
		This is a final method (meth2)
	*/
	
}
}
