package entities;

public class Student {
	private String name;
	private double n1, n2, n3;
	
	public boolean isApproved() {
		if(this.getFinalGrade() > 60.0)
			return true;
		else
			return false;
	}
	
	public double getFinalGrade() {
		return (n1*30 + n2*35 + n3*35)/100;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setN1(double n1) {
		this.n1 = n1;
	}
	
	public void setN2(double n2) {
		this.n2 = n2;
	}
	
	public void setN3(double n3) {
		this.n3 = n3;
	}
	
	public String getName() {
		return name;
	}
	
}
