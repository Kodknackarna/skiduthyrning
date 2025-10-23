package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		System.out.println("Hello Sweden!");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ange ditt namn: ");
		String input = scanner.nextLine();
		System.out.println("Hej " + input + "!");
		scanner.close();
	}

}
