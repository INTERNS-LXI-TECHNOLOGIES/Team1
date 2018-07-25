package com.lxisoft.campus.college;
import java.util.*;
public class Classroom
{
	private String location;
	private String depname;
	Faculty f;
	Student[] stud;
	public Classroom(String location,String depname)
	{
		this.location=location;
		createFac();
		createStudent(depname);
	}
	void createFac()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the faculty Name:");
		String name=System.console().readLine();
		System.out.println("Enter the salary per hour:");
		int sal=sc.nextInt();
		System.out.println("Enter the number of subjects faculty taking:");
		int sub=sc.nextInt();
		System.out.println("Enter the number of hours worked by faculty:");
		int hrs=sc.nextInt();
		f=new Faculty(name,sal,sub,hrs);
	}
	void createStudent(String depname)
	{
		Scanner p=new Scanner(System.in);
		System.out.println("Enter the number of students:");
		int n=p.nextInt();
		stud=new Student[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter the name of student:");
			String sname=System.console().readLine();
			System.out.println("Enter the Roll Number of student:");
			int rno=p.nextInt();
			if(depname.equals("cse"))
			{
				 stud[i]=new Csestudent(sname,rno);
			}
			else if(depname.equals("mech"))
			{
				 stud[i]=new Mechstudent(sname,rno);

			}
			
		}
		
	}
	void printDetails()
	{
		System.out.println("Location of Classroom:"+location);
		f.facDetails();
		for(int i=0;i<stud.length;i++)
		{
			stud[i].studDetails();
		}
	}
}