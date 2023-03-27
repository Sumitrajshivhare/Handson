package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface
 interface l1{
	
	public static void display() {
		System.out.println("i am display");
	}
	
	public default void print() {
		
		System.out.println("i am print");
	}
	
//	public void ab();
	public String show(String one);
}

class Employee{
	String name;
	int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}
	
}

public class LambdaExpe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		l1 l = (m)-> "sumit " + m;
		System.out.println(l.show("message"));
		l.print();
	    l1.display();
	    
	    List<Employee> list = Arrays.asList(new Employee("Sumit", 1),
	    		new Employee("Arjun", 2),
	    		new Employee("Gouri", 3));
	    
	    System.out.println(list);

	    Collections.sort(list, Comparator.comparing(Employee:: getName));
	   
	    System.out.println(list);
	}

}
