package entities;

public class Person {
	private String name;
	private double grossSalary;
	private static double tax = 1000;
	
	public double netSalary() {
		return grossSalary-tax;
	}
	
	public void increaseSalary(double percentage) {
		this.grossSalary += this.grossSalary*percentage/100;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGrossSalary(double salary) {
		this.grossSalary = salary;
	}	
	
	public String getName() {
		return name;
	}
}
