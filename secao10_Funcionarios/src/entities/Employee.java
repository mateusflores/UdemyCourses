package entities;

public class Employee {
	private int id;
	private double salary;
	private String name;
	
	public Employee(int id, double salary, String name) {
		this.id = id;
		this.salary = salary;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void increaseSalary(double percentage) {
		salary = salary * ((percentage+100)/100);
	}
	
	public String toString() {
		return  this.getId()
				+ ", "
				+ this.getName()
				+ ", $"
				+ String.format("%.2f", this.getSalary());
	}
	
}
