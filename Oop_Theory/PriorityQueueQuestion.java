package labtestquestions;
import java.util.PriorityQueue;

public class SEmployee {
	int id;
	String name;
	int hours;
public SEmployee() {}
public SEmployee(int id, String name, int hours) {
	this.id = id;
	this.name = name;
	this.hours = hours;
}
public int getHours() {
	return hours;
}
public void setHours(int hours) {
	this.hours = hours;
}
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", Hours=" + hours + "]";
}
}

public class SecEmployeeApp {
//we can do other collection frameworks classes what we did in studentSortingApp but when we comes to priorityqueie we must use this structure
    public static void main(String[] args) {
        PriorityQueue<SEmployee> se = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.getHours(), b.getHours())
        );

        se.add(new SEmployee(2, "saman", 30));
        se.add(new SEmployee(3, "vaman", 50));
        se.add(new SEmployee(4, "jaman", 3));
        se.add(new SEmployee(5, "haman", 33));
        se.add(new SEmployee(6, "maman", 4));

        // Make a copy for filtering before the original is emptied
        PriorityQueue<SEmployee> seCopy = new PriorityQueue<>(se);

        System.out.println("All employee hours in priority order:");
        while (!se.isEmpty()) {
            System.out.println(se.poll().getHours());
        }

        PriorityQueue<SEmployee> se2 = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.getHours(), b.getHours())
        );

        for (SEmployee qq : seCopy) {
            if (qq.getHours() < 15) {
                se2.add(qq);
            }
        }

        System.out.println("\nEmployees with hours < 15:");
        while (!se2.isEmpty()) {
            System.out.println(se2.poll().getHours());
        }
    }
}
