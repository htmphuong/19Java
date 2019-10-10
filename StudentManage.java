package Inheritance;

public class StudentManage {

	Vector<Inheritance.Student> vStudent = new Vector<Inheritance.Student>();
		public StudentManage() {
			this.input();
			this.display();
			this.MinStudent();
		}
	//nhap sv
		public void input() {
			int num;
			Scanner key = new Scanner(System.in);
			System.out.println("nhap so sv=");
			num = Integer.parseInt(key.nextLine());
			for(int i=0;i<num;i++) {
				Inheritance.Student s = new Inheritance.Student();
				s.Input();			
				vStudent.add(s);
			}
		}
		//in ra 
		public void display() {
			Enumeration<Inheritance.Student> eStudent=vStudent.elements();
			int i=1;
			while(eStudent.hasMoreElements()){
				Inheritance.Student s =(Inheritance.Student)eStudent.nextElement();
				s.Display();
			}	
			
		}
		//tim sv co diem trung binh nho nhat
		public void MinStudent(){
			float min =vStudent.elementAt(0).CalAver();
			for(int i=1;i<vStudent.size();i++) {
				if(vStudent.elementAt(i).CalAver()<min) min =vStudent.elementAt(i).CalAver();
			}
			System.out.println("Min is"+min);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentManage();
	}

}
