import java.io.*;
import java.util.Scanner;

public class logicClass {
	File f;
	FileInputStream fis;
	FileOutputStream fos;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	int n;
	Scanner sc;
	public static void SOP(Object o) {
		System.out.println(o);
	}
	
	public logicClass(){
		sc = new Scanner(System.in);
		try {
			f = new File("UserData.data");
			//System.out.println("ok");
			File x = new File("objs.num");
			//System.out.println("ok");
			fis = new FileInputStream(x);
			n = fis.read();
			fis.close();
		}
		catch(FileNotFoundException fnfe) {
			/*try {
				fos = new FileOutputStream(new File("objs.num"));
				fos.write(0);
				fos.close();
				fis = new FileInputStream(new File("objs.num"));
				n = fis.read();
				fis.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}*/
			
		}
		catch(IOException ioe) {
			
		}
		System.out.println(n);
	}
	House isExists(String search) throws IOException {
		House obj = null;
		if(n == 0){
			return null;
		}
			fis = new FileInputStream(new File("UserData.data"));
			ois = new ObjectInputStream(fis);
		
		for(int i = 0; i < n; i++) {
			try {
			obj = (House)ois.readObject();
			}
			catch(ClassNotFoundException cnfe) {
				
			}
			catch(IOException ioe) {
				
			}
			if(search.equals(obj.getOwner())) {
				fis.close();
				ois.close();
				return obj;
			}
			else if(search.equals(obj.getAddress())) {
				fis.close();
				ois.close();
				return obj;
			}
		}
		fis.close();
		ois.close();
		return null;
	}
	House getNewOne(String search) {
		House obj = null;
		SOP("-----------------------------");
		System.out.print("Enter Owner's name:");
		String name = sc.nextLine();
		System.out.println("----------------------------------");
		boolean type,on_rent;
		if(search.charAt(1) == 'F')
			type = false;
		else
			type = true;
		System.out.print("Is It On Rent?: (1...True,2...False):");
		int x = Integer.parseInt(sc.nextLine());
		System.out.println("------------------------------------");
		if(x == 1)
			on_rent = true;
		else
			on_rent = false;
		System.out.print("Number of Members:");
		int m = Integer.parseInt(sc.nextLine());
		System.out.println("------------------------------------");
		System.out.print("Number of vehicles:");
		int v = Integer.parseInt(sc.nextLine());
		SOP("----------------------------------");
		if(type) {
			System.out.print("Enter Name of Your Bunglow:");
			String p = sc.nextLine();
			System.out.println("------------------------------------");
			System.out.print("Is it Multi-Storey??: (1...True 2...False):");
			boolean ms;
			int q = Integer.parseInt(sc.nextLine());
			System.out.println("------------------------------------");
			if(q == 1)
				ms = true;
			else
				ms = false;
			
			obj = new Bunglow(type,name,on_rent,m,v,search,ms,p);
		}
		else {
			System.out.print("Enter Name of Your Appartment:");
			String p = sc.nextLine();
			System.out.println("------------------------------------");
			obj = new Flat(type,name,on_rent,m,v,search,p);
		}
		
		return obj;
	}
	void showInfo() throws IOException {
		SOP("-------------------------------");
		SOP("Enter House Number or Owner's Name");
		SOP("Format Should be like (e.g AB-100), For House Number:");
		String ss;
		ss = sc.nextLine();
		House obj = isExists(ss);
		if(obj == null) {
			SOP("----------------------------");
			SOP("This Owner or Number Does not exists");
			SOP("----------------------------");
		}
		else {
			if(obj instanceof Flat) {
				Flat ob = (Flat)obj;
				ob.getfullDetails();
			}
			else {
				Bunglow ob = (Bunglow)obj;
				ob.getfullDetails();
			}
		}
	}
	void AddUser() throws IOException, ClassNotFoundException {
		SOP("-------------------------------");
		SOP("Enter House Number");
		SOP("Format Should be like (e.g AB-100), For House Number:");
		String number = sc.nextLine();
		House obj = isExists(number);
		if(obj != null) {
			SOP("------------------------");
			SOP("House Number already Exists");
			SOP("Try to Update User");
			SOP("------------------------");
			return;
		}
		File ftemp = new File("UserData.temp");
		fos = new FileOutputStream(ftemp);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(getNewOne(number));
		if(n != 0){
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
		
			for(int i = 0; i < n; i++) {
				oos.writeObject((House)ois.readObject());
			}
		fis.close();
		ois.close();
		}

		oos.flush();
		oos.close();
		fos.close();
		
		n++;
		f = null;
		(new File("UserData.data")).delete();
		ftemp.renameTo(new File("UserData.data"));
		ftemp = null;
		f = new File("UserData.data");
	}
	
	void updateUser() throws IOException, ClassNotFoundException {
		SOP("-------------------------------");
		SOP("Enter House Number");
		SOP("Format Should be like (e.g AB-100), For House Number:");
		String search = sc.nextLine();
		House obj = isExists(search);
		if(obj == null) {
			SOP("----------------------------");
			SOP("This House Number Does not exists");
			SOP("Try to Add");
			SOP("----------------------------");
			return;
		}
		House updated = getNewOne(search);
		fis = new FileInputStream(f);
		ois = new ObjectInputStream(fis);
		File ftemp = new File("UserData.temp");
		fos = new FileOutputStream(ftemp);
		oos = new ObjectOutputStream(fos);
		for(int i = 0; i < n; i++) {
			obj = (House)ois.readObject();
			if(search.equals(obj.getAddress()))
				oos.writeObject(updated);
			else
				oos.writeObject(obj);
		}
		oos.flush();
		oos.close();
		fos.close();
		fis.close();
		ois.close();
		f = null;
		(new File("UserData.data")).delete();
		ftemp.renameTo(new File("UserData.data"));
		ftemp = null;
		f = new File("UserData.data");
	}
	void AtLast() throws IOException {
		File x = new File("objs.num");
		fos = new FileOutputStream(x);
		fos.write(n);
		fos.close();
	}
}
