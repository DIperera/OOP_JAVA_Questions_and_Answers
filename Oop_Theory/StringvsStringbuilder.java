package beforeMid;

public class Strmethods {
	public static void main(String args[]) {
		StringBuilder strb = new StringBuilder("Hello,_World!"); //spaces will be included 
		String str = new String("Ishira Perera");
		
		String result = strb.substring(0, 5);
		System.out.println(result); // Output: "Hello"

		String result2 = str.substring(6); //substring doesn't modify the original str. Only assigning to variable
		System.out.println(result2); // Output: " Perera" 
		
		result2 = str.concat("xyz");
		System.out.println(result2);// Output: "Ishira Pereraxyz" so "String" class always creates new string inside heap for each changes unlike StringBuffer & StringBuilder(they override the original string) 
		
		//result = strb.delete(0, 5); we can't type like this. but we can type like strb = strb.delete(0, 5);
		//str.delete(0, 5); this is wrong because String class does not have delete function(because string objects cannot be modified after defining)
		strb.delete(0,6); // deletes characters from index 0 to 5 (6 is exclusive)
		System.out.println(strb); //Output: "_World!"
		strb.reverse();//will reverse the original string after deleting first 6 characters (0 to 5)
		System.out.println(strb);// Output: "!dlroW_"
		
		strb.substring(0, 3);//see? this will not do anything to original str 
		System.out.println(strb);// Output: "!dlroW_"
		
		strb.insert(5, "###");// inserts "###" at index 5
		System.out.println(strb);// Output: "!dlro###W_"
		
		strb.append(" abc");// appends " abc" at the end
		System.out.println(strb);// Output: "!dlro###W_ abc"
		
	}

}
/*Memory Diagram for this Code:
 
  [Stack]       |                       [Heap]
                |
main()          |
|               |
|--> strb ------> StringBuilder Object
|               |        Content initially: "Hello,_World!"
|               |        After [all] operations: "!dlro###W_ abc" <--modified the previous string
|
|--> str ------> String Object
|               |        Content: "Ishira Perera"
|
|--> result ----> String Object
|               |        Content: "Hello"
|
|--> result2 ---> String Object
                |        After `substring(6)`: " Perera"
                |        After `concat("xyz")`: "Ishira Pereraxyz" <--created new string
              
(Old " Perera" String object exists in heap but has no reference(because "Ishira Pereraxyz" took the reference "result2" from " Perera" string object ) 
currectly all strings are inside heap. don't think about string pool. because if we use methods(concat,substring,..) they should be manualy stored if we want to. 
                                   
Key Concept:

String:
 -> Immutable → new object(string) for every change.

 -> Example: result2 = str.substring(6); → creates a new String " Perera" in Heap.

StringBuilder:
 -> Mutable → changes happen on same object(string).

 -> Example: strb.delete(0,6) → directly changes the original strb object*/
