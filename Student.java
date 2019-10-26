package SV;

public class Student extends Person implements Comparable<Student> {
	String id;
	float gpa;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public Student() {
		super();
	}
	public Student(String name,String id,float gpa) {
		super(name);
		this.id=id;
		this.gpa=gpa;
	}
	public void ArrangeGPA() {
		if(this.gpa>2) System.out.println("Qualify");
		else System.out.println("Fail");
	}
	public void Display() {
		super.Display();
		System.out.println("ID="+this.id+" GPA="+this.gpa);
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return (int) (this.getName().compareTo(o.getName()));
	}
}
