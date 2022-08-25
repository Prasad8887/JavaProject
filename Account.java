package MiniProject;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {

	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;

	Scanner input = new Scanner(System.in);
	public Account() {
	}

	public Account(int customerNumber, int pinNumber) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
	}

	public Account(int customerNumber, int pinNumber, double savingBalance) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
		this.savingBalance = savingBalance;
	}  
	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}
	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}

	public double calcSavingDeposit(double amount) {
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}


	public void getsavingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + savingBalance);
				System.out.print("\nAmount you want to withdraw from Savings Account: ");
				double amount = input.nextDouble();
				if ((savingBalance - amount) >= 0 && amount >= 0) {
					calcSavingWithdraw(amount);
					System.out.println("\nCurrent Savings Account Balance: " + savingBalance);
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getSavingDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + savingBalance);
				System.out.print("\nAmount you want to deposit into your Savings Account: ");
				double amount = input.nextDouble();

				if ((savingBalance + amount) >= 0 && amount >= 0) {
					calcSavingDeposit(amount);
					System.out.println("\nCurrent Savings Account Balance: " + savingBalance);
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			
			}
		}
	}
}

