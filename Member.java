import java.util.Scanner;
import java.io.*;
public class Member implements Serializable{
	protected int age;
	protected String name;
	protected String surname;
	protected String mobile;
	public Member(){
		Scanner sc = new Scanner(System.in);
		System.out.println("------------------------------------");
		System.out.print("Enter Name of Member:");
		name = sc.nextLine();
		System.out.println("------------------------------------");
		System.out.print("Surname:");
		surname = sc.nextLine();
		System.out.println("------------------------------------");
		System.out.print("Age:");
		age = Integer.parseInt(sc.nextLine());
		System.out.println("------------------------------------");
		System.out.println("Mobile Number:");
		mobile = sc.nextLine();
		System.out.println("------------------------------------");
		//sc.close();
	}
	public String toString() {
		return (name + " " + surname + "\nAge: " + age + "\nMobile: " + mobile);
	}
}