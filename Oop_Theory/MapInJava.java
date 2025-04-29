package labtestquestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapInJava {
public static void main(String[] args) {
	Map<String,Integer> mp = new HashMap();
	mp.put("Emma", 75);
	mp.put("Ann", 55);
	mp.put("Emma", 90);//value of Emma will be overrided
	System.out.println(mp);
	System.out.println(mp.entrySet());
	System.out.println(mp.get("Emma"));
	var set2 = mp.entrySet();// instead of Set<Map.Entry<String, Integer>> set = mp.entrySet(); 
	for(var x : set2) {
		System.out.println(x.getKey()+" --> "+x.getValue());
	}
	int mark = mp.get("Ann");
	mp.put("Ann", mark + 5);
	System.out.println(mp.get("Ann"));

}
}
