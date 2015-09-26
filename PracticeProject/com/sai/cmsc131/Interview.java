package com.sai.cmsc131;

import java.util.Scanner;

public class Interview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		System.out.println("What is your name?");
		String name = s.nextLine();
		System.out.println("What is your age?");
		int age = s.nextInt();
		System.out.println("How many months has it been since you birthday?");
		int months = s.nextInt();
		int totalMonths = (age*12)+months;
		//System.out.println(currAge);
		
		System.out.println("What is your favorite class?");
		s.nextLine();
		String favClass = s.nextLine();
		
		
		if(totalMonths > 900){
			System.out.println("Hello "+name+", you are old. Your age is "+totalMonths+" months.");
		}else if(totalMonths < 120){
			System.out.println("Hello "+name+", you are young. Your age is "+totalMonths+" months.");
		}else {
			System.out.println("Hello "+name+". Your age is "+totalMonths+" months.");
		}
		
		System.out.println("Yes, "+favClass+" is a great class!");
		
	}

}
