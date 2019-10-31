public class Bunglow extends House{
	protected String Bung_name;
	protected boolean multiFloor;
	public Bunglow(boolean type, String owner, boolean ty, int m, int v, String address, boolean t, String name) {
		super(type,owner,ty,m,v,address);
		Bung_name = name;
		multiFloor = t;
	}
	public void getfullDetails() {
		System.out.println("------------------------------------");
		super.getfullDetails();
		System.out.println("------------------------------------");
		System.out.println("Bunglow Name: " + Bung_name);
		System.out.println("------------------------------------");
		System.out.println("Multi-Storey:" + multiFloor);
	}
}