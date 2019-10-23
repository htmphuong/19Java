package j19;

import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class StudentManagement {
	// khai bao vector de luu danh sach cac sinh vien
	Vector<Student> vStudent = new Vector<Student>();
	
	public StudentManagement() {
		Input();
		Display();
	}
	//nhap danh sach sv
	public void Input() {
		int num;//so luong sv muon nhap
		Scanner key = new Scanner(System.in);
		System.out.println("Nhap so sv num=");
		num = Integer.parseInt(key.nextLine());
		for(int i=0;i<num;i++) {
			System.out.println("Nhap ten=");
			String ten = key.nextLine();
			System.out.println("Nhap dia chi=");
			String diachi = key.nextLine();
			System.out.println("Nhap tuoi=");
			int tuoi = Integer.parseInt(key.nextLine());
			System.out.println("Nhap toan=");
			float toan = Float.parseFloat(key.nextLine());
			System.out.println("Nhap ly=");
			float ly = Float.parseFloat(key.nextLine());
			System.out.println("Nhap ly=");
			float hoa = Float.parseFloat(key.nextLine());
			Student s = new Student(ten, diachi, tuoi, toan, ly, hoa);
			vStudent.add(s);
		}		
	}
	//display
	public void Display() {
		Enumeration eStudent = vStudent.elements();
		while(eStudent.hasMoreElements()) {
			Student s =(Student)eStudent.nextElement();
			System.out.println("Name="+s.getName());
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StudentManagement();
	}

}
