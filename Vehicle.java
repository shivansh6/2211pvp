import java.util.Scanner;
import java.io.*;
public class Vehicle implements Serializable{
	protected String name;
	protected String number_plate;
	public Vehicle() {
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------------");
		System.out.print("Enter The name of Vehicle:");
		name = sc.nextLine();
		System.out.println("------------------------------------");
		System.out.print("Enter It's Number Plate: (e.g. GJ-01-AA-1111)");
		number_plate = sc.nextLine();
		System.out.println("------------------------------------");
	}
	public String toString() {
		return ("Name:" + name + "\nNumber:" + number_plate);
	}
}
