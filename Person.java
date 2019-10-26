package SV;

public abstract class Person {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	// constructors
	public Person() {
		
	}
	public Person(String name) {
		this.name=name;
	}
	public abstract void ArrangeGPA(); //virtual
	public void Display() {
		System.out.println("Name ="+this.name);
	}

}
