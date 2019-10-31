import java.io.*;
import java.util.Scanner;

public class Main{
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		logicClass LogicClass = new logicClass();
		System.out.println("#############################################");
		System.out.println("Welcome to \" Heaven On Earth \" Society");
		System.out.println("#############################################");
		int choice;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("1.... See information Of Any Individual");
			System.out.println("2.... See information Blockwise");
			System.out.println("3.... See information Flatwise/Bunglowwise");
			System.out.println("4.... Add Individual");
			System.out.println("5.... Update Individual");
			System.out.println("Any Number to Exit");
			System.out.print("Enter Your choice:");
			choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1: LogicClass.showInfo();
					break;
			case 2: break; // pending
			case 3: break;  // pending
			case 4: LogicClass.AddUser();
					break;
			case 5: LogicClass.updateUser();
					break;
			default: choice = 0;
			}
		}while(choice != 0);
		LogicClass.AtLast();
		System.out.println("#############################################");
		System.out.println("Thank You!! Have A Nice Day");
		System.out.println("#############################################");
	}
}
