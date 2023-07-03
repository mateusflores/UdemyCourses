package util;

public class Client {
	private String name;
	private int accountNumber;
	private double totalCash;
	
	// Constructors
	
	public Client(String name, int accountNumber, double inicialDeposit) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.deposit(inicialDeposit);
	}
	
	public Client(String name, int accountNumber) {
		this.name = name;
		this.accountNumber = accountNumber;
	}

	// Getters and Setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getTotalCash() {
		return totalCash;
	}	
	
	// Methods
	
	public void deposit(double amount) {
		totalCash += amount;
	}
	
	public void withdraw(double amount) {
		totalCash -= amount+5;
	}
	
	public String toString() {
		return "Account: " 
				+ this.getAccountNumber() 
				+ ", Holder: " 
				+ this.getName() 
				+ ", Balance: $ " 
				+ String.format("%.2f", this.getTotalCash());
	}
}
