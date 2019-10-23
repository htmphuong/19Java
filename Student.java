package j19;

public class Student {
	private String name;
	private String address;
	private int age;
	private float math;
	private float phy;
	private float chem;
	
	public Student() {
		
	}
	public Student(String name,String address, int age,float math,float PHY,float CHEM) {
		this.name=name;
		this.address= address;
		this.age=age;
		this.math=math;
		this.phy=phy;
		this.chem=chem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getMath() {
		return math;
	}
	public void setMath(float math) {
		this.math = math;
	}
	public float getPhy() {
		return phy;
	}
	public void setPhy(float phy) {
		this.phy = phy;
	}
	public float getChem() {
		return chem;
	}
	public void setChem(float chem) {
		this.chem = chem;
	}
	
	
}
