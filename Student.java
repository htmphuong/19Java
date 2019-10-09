package Inheritance;

public class Student extends Person {
	String StudentID;
	float Math;
	float Phy;
	float Chem;
	public Student() {
		super();
		this.StudentID="19";
		this.Math=(float)8.0;
		this.Chem=(float)7.5;
		this.Phy=(float)6.0;
	}
	public Student(String ID,String Name,String StudentID,float Math,float Phy,float Chem) {
		super(ID, Name);
		this.StudentID=StudentID;
		this.Math=Math;
		this.Phy=Phy;
		this.Chem=Chem;
	}
	public void Display() {
		super.Display();
		System.out.println("Math="+this.Math);
	}
}
