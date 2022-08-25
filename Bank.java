package MiniProject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Bank {

	Scanner sc = new Scanner(System.in);
	HashMap<Integer, Account> data = new HashMap<Integer, Account>();

	public void getLogin() throws IOException {
		boolean end = false;
		int customerNumber = 0;
		int pinNumber = 0;
		while (!end) {
			try {
				System.out.print("Enter your customer number: ");
				customerNumber = sc.nextInt();
				System.out.print("Enter your PIN number: ");
				pinNumber = sc.nextInt();
				Iterator it = data.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					Account acc = (Account) pair.getValue();
					if (data.containsKey(customerNumber) && pinNumber == acc.getPinNumber()) {
						getAccountType(acc);
						end = true;
						break;
					}
				}
				if (!end) {
					System.out.println("Wrong Customer Number or Pin Number");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Character.( Only Numbers.)");
			}
		}
	}

	public void getAccountType(Account acc) {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("Select the account you want to access: ");
				System.out.println("1) Savings Account");
				System.out.println("2) Exit");
				System.out.print("Choice: ");

				int selection = sc.nextInt();

				switch (selection) {
				case 1:
					getSaving(acc);
					break;
				case 2:
					end = true;
					break;
				default:
					System.out.println("Invalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Choice.");
				sc.next();
			}
		}
	}
	public void getSaving(Account acc) {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("Savings Account: ");
				System.out.println("1)View Balance");
				System.out.println("2) Withdraw Funds");
				System.out.println("3)Deposit Funds");
				System.out.println("5) Exit");
				System.out.print("Choice: ");
				int selection = sc.nextInt();
				switch (selection) {
				case 1:
					System.out.println("Savings Account Balance: "+acc.getSavingBalance());
					break;
				case 2:
					acc.getsavingWithdrawInput();
					break;
				case 3:
					acc.getSavingDepositInput();
					break;
				case 4:
					end = true;
					break;
				default:
					System.out.println("Invalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Choice.");
				sc.next();
			}
		}
	}

	public void createAccount() throws IOException {
		int cst_no = 0;
		boolean end = false;
		while (!end) {
			try {
				System.out.println("Enter your customer number ");
				cst_no = sc.nextInt();
				Iterator it = data.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					if (!data.containsKey(cst_no)) {
						end = true;
					}
				}
				if (!end) {
					System.out.println("This customer number is already registered");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Choice.");
				sc.next();
			}
		}
		System.out.println("\nEnter PIN to be registered");
		int pin = sc.nextInt();
		data.put(cst_no, new Account(cst_no, pin));
		System.out.println("Your new account has been successfuly registered!");
		System.out.println("Redirecting to login.............");
		getLogin();
	}

	public void mainMenu() throws IOException {
		data.put(123, new Account(123, 123,  50000));
		boolean end = false;
		while (!end) {
			try {
				System.out.println(" 1) Login");
				System.out.println(" 2) Create Account");
				System.out.print("Choice: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					getLogin();
					end = true;
					break;
				case 2:
					createAccount();
					end = true;
					break;
				default:
					System.out.println("Invalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Choice.");
				sc.next();
			}
		}
		System.out.println("Thank You for using this ATM.");
		sc.close();
		System.exit(0);
	}
}