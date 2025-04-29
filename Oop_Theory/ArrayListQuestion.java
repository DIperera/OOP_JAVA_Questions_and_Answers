package labtestquestions;
import java.util.ArrayList;

public class Student {
	private int id;
	private String name;
	private int mark;
	
	public Student() {}
	
	public Student(int id, String name, int mark) {
		this.id = id;
		this.name = name;
		this.mark = mark;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mark=" + mark + "]";
	}
}

//we can do all the things we did to all collection frameworks otherthan priority queue

public class StudentSortingApp {

	public static void main(String[] args) {
		ArrayList<Student> std = new ArrayList<>();//you can change Arralist to other collection framework classes
		
		std.add(new Student(1,"saman",20));
		std.add(new Student(2,"paman",80));
		std.add(new Student(3,"oaman",70));
		std.add(new Student(4,"yaman",90));
		std.add(new Student(5,"haman",40));
		
		for(Student s : std) {
			System.out.println(s);
		}
		
		System.out.println();
		
		ArrayList<Student> std2 = new ArrayList<>();
		
		for(Student s : std) {
			int mark = s.getMark();
			if(mark > 50) {
			System.out.println(s);
			}
		}
	}

}
