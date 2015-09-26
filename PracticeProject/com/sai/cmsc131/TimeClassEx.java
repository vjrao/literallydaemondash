package com.sai.cmsc131;

import java.util.Scanner;

public class TimeClassEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Pattern pattern = Pattern.compile("\\D");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter '1' to convert from Military to Regular time or enter '2' to convert from Regular to Military time.");
		int opt = s.nextInt();
		
		if(opt == 1){
			System.out.println("Enter an integer value representing the Military time: ");
			int milTime = s.nextInt();
			
			while( milTime < 0 || milTime > 2359){
				System.out.println("Enter an integer value representing the Military time: ");
				milTime = s.nextInt();
			}
			
			if(milTime > 1259){
				int regTime = milTime - 1200;
				System.out.println("The regular time is: " + (regTime/100) + ":" + (regTime%100) + " PM");
			}else{
				System.out.println("The regular time is: " + (milTime/100) + ":" + (milTime%100) + " AM.");
			}
			
		}else{
			System.out.println("Enter the hour of regular time: ");
			int userRegTimeHour = s.nextInt();
			while(userRegTimeHour > 12 || userRegTimeHour < 0){
				System.out.println("Enter the hour of regular time: ");
				userRegTimeHour = s.nextInt();
			}
			System.out.println("Enter the minutes of regular time: ");
			int userRegTimeMins = s.nextInt();
			while(userRegTimeMins > 59 || userRegTimeMins < 0){
				System.out.println("Enter the minutes of regular time: ");
				userRegTimeMins = s.nextInt();
			}
			System.out.println("Is it AM or PM: ");
			s.nextLine();
			String userRegTimeDay = s.nextLine();
			while(!(userRegTimeDay instanceof String)){
				System.out.println("Is it AM or PM: ");
				userRegTimeDay = s.nextLine();
			}
			
			if(userRegTimeDay.equals("AM")){
				System.out.println("The military time is: " + userRegTimeHour + "" + userRegTimeMins);
			}else{
				System.out.println("The military time is: " + (userRegTimeHour+12) + "" + userRegTimeMins);
			}
			
		}
		
		

		
	}

}
