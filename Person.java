package Inheritance;

import java.util.Scanner;

public class Person {
	private String ID;
	private String Name;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Person() {
		this.Name="ABC";
		this.ID="123";
	}
	public Person(String ID,String Name) {
		this.ID=ID;
		this.Name=Name;		
	}
	public void Input() {
		Scanner key = new Scanner(System.in);
		System.out.println("ID=");
		ID =key.nextLine();
		System.out.println("Name=");
		Name=key.nextLine();
	}
	public void Display() {
		System.out.println("ID="+this.ID+" name="+this.Name);
	}
	
}
