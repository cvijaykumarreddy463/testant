package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class ThrowException {
	public static void main(String args[]) throws FileNotFoundException {
		BufferedReader reader2 = new BufferedReader(
				new FileReader("C:\\Program Files (x86)\\Jenkins\\jobs\\Test1\\lastSuccessful\\log"));
		@SuppressWarnings("resource")
		Scanner in = new Scanner(reader2);
		while (in.hasNextLine()) {
			String currentLine = in.nextLine().replaceAll("[^\\w\\d\\s]", " ");
			String[] words = currentLine.split(" ");
			for (String a : words) {
				if (a.equals("warning")) {
					try {
						throw new RuntimeException();
					} catch (RuntimeException e) {
						System.out.println("warning occurs while building....");
						System.exit(0);
					}
				}
			}
		}
	}
}