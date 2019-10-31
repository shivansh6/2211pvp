public class Flat extends House{
	protected String App_name;
	protected int floor;
	public Flat(boolean type, String owner, boolean ty, int m, int v, String address, String appartment) {
		super(type, owner, ty, m, v, address);
		App_name = appartment;
		floor = Integer.parseInt(address.substring(3))/100;
	}
	public void getfullDetails() {
		System.out.println("-----------------------------");
		super.getfullDetails();
		System.out.println("------------------------------------");
		System.out.println("Appartment Name: " + App_name);
		System.out.println("------------------------------------");
		System.out.println("Floor Number: " + floor);
	}
}
