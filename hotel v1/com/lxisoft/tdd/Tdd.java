package com.lxisoft.tdd;
import com.lxisoft.hotel.Hotel;
import java.util.Scanner;
public class Tdd
{
public static void main (String args[])
{
Scanner scan=new Scanner(System.in);
int d=0;
    do
	{	
	Hotel hotel=new Hotel();
	hotel.selecting();
	System.out.println("do you want to continue\nyes=1 \n no=0");
    d=scan.nextInt();
    }
	while (d==1);
}
}