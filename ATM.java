package MiniProject;

import java.io.IOException;
import java.util.*;
public class ATM {

	public static void main(String[] args) throws IOException {
		Bank b = new Bank();
		introduction();
		b.mainMenu();
	}

	public static void introduction() {
		System.out.println("Welcome to the ATM Project!");
	}
}



