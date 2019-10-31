import java.io.*;

public abstract class House implements Serializable{
	protected boolean type; // false: flat, True: Bunglow
	protected String owner;
	protected boolean on_rent; 
	protected int members;
	protected int vehicles;
	protected Member m[];
	protected Vehicle v[];
	protected String block;
	protected int number;
	public House(boolean type, String owner, boolean ty, int m, int v, String address) {
		this.v = new Vehicle[v];
		this.m = new Member[m];
		this.owner = owner;
		on_rent = ty;
		this.block = address.substring(0,2);
		this.type = type;
		members = m;
		vehicles = v;
		this.number = Integer.parseInt(address.substring(3));
		for(int i = 0; i < m ; i++) {
			this.m[i] = new Member();
		}
		for(int i = 0; i < v; i++) {
			this.v[i] = new Vehicle();
		}
	}
	public String getOwner() {
		return owner;
	}
	public String getBlock() {
		return block;
	}
	public int getNumber() {
		return number;
	}
	public String getAddress() {
		return (block + '-' + number);
	}
	public void getfullDetails() {
		System.out.println("------------------------------------");
		System.out.println("House Type: " + ((type) ?"Tenament" :"Flat"));
		System.out.println("------------------------------------");
		System.out.println("Owner's name:" + owner);
		System.out.println("------------------------------------");
		for(int i = 0; i < members; i++) {
			System.out.println("Member:" + (i+1) +": " + m[i]);
			System.out.println("------------------------------------");
		} // as owner is the first member => already counted
		
		System.out.println("Veicles:");
		
		for(int i = 0; i < vehicles; i++) {
			System.out.println("Vehicle-" + (i+1) + ": " + v[i]);
			System.out.println("------------------------------------");
		}
		System.out.println("House Number: " + (block + '-' + number));
		System.out.println("------------------------------------");
		System.out.println("Is it on Rent:" + on_rent);
		System.out.println("------------------------------------");
	}
}
