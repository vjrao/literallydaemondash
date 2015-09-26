package com.sai.cmsc131;

import java.util.Scanner;

public class HourglassEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter size: ");
		int sizeInput = scan.nextInt();
		System.out.println("Enter character: ");
		char symbol = scan.next().charAt(0);

		int size = sizeInput;

		// int glassSize = size * 2;
		for (int r = size; r >= 1; r--) {
			for (int s = 1; s <= size - r; s++) {
				System.out.print(" ");
			}
			for (int c = r * 4; c > 0; c -= 2) {
				System.out.print(symbol);
			}
			System.out.println("");
		}

//		for (int r = size; r >= 1; r++) {
//			for (int s = 1; s <= size - r; s++) {
//				System.out.print(" ");
//			}
//			for (int c = 0; c < r * 4; c += 2) {
//				System.out.print(symbol);
//			}
//			System.out.println("");
//		}
	}

}
