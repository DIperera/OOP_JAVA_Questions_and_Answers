package labtestquestions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class StringObjectives {
public static void main(String[] args) {
Stack<Character> st = new Stack<>();
String a = "abcde";
for(char x: a.toCharArray()) {
	st.push(x);
}
//while(!st.isEmpty()) {
//	System.out.print(st.pop());
//}
System.out.print(st.pop());//print first removed character
System.out.print(st.pop());//print second removed character
System.out.print(st.pop());//print 3rd removed character
System.out.println(st);//to print remaining characters
	
//list interface
List<Character> lst = new ArrayList<>();
String b = "zcxcvb";
for(char y : b.toCharArray()) {
	lst.add(y);
}
System.out.println("List : "+lst);//we can see elements are sorted into the order it defined
	
//set interface
Set<Character> hset = new HashSet<>();//Hashset remove dupplicates
for(char y : b.toCharArray()) {
	hset.add(y);
}
System.out.println("HashSet : "+hset);//we can see elements are sorted into A-Z order
	
Set<Character> tset = new TreeSet<>();//Treeset remove dupplicates
for(char y : b.toCharArray()) {
	tset.add(y);
}
System.out.println("TreeSet : "+tset);//we can see elements are sorted into A-Z order
	
//queue interface
PriorityQueue<Character> pq = new PriorityQueue<>();
for(char y : b.toCharArray()) {
	pq.add(y);
}
System.out.println("PriQueue : "+pq);//we can see there is no oreder (elements are displayed according to the heap's order)
System.out.println(pq.peek());//to display first element
System.out.println(pq.poll());//to delete first element
System.out.println(pq);//to display remaining elements

ArrayList<Object> arr = new ArrayList(); 
arr.add(2);
arr.add("aaa");
arr.add(9);
System.out.println(arr);
arr.add(0, 5);
System.out.println(arr);
arr.set(1, 9);
System.out.println(arr);
if(arr.contains(9)) {
	System.out.println(arr.get(0));
	System.out.println(arr.indexOf("aaa"));
	System.out.println(arr.lastIndexOf(9));
	System.out.println(arr.size()); 
}
for(Object x : arr) {
	System.out.print(x +" ");
}
System.out.println();
for(int i=0; i<arr.size(); i++) {
	System.out.print(arr.get(i) +" ");
}
System.out.println();
arr.forEach(y -> System.out.print(y+" "));
//conver in to array
Object arr2[] = new Object[arr.size()];
arr2 = arr.toArray(arr2);//if you add [] like arr2[] = arr.toArray(arr2); it is incorrect
//arr2.forEach(a -> System.out.print(a)); this is incorrect. use for loop instead
System.out.println();
for(Object a : arr2) { //to print all elements of arr2
System.out.print(a+" ");
}	
}
}
