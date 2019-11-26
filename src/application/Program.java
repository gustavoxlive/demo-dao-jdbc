package application;

import java.util.Date;

import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Seller s = new Seller(1, "Luiz", "gustavo_x@live.com", new Date(), 3000.0, new Department(1, "Books"));
		
		System.out.println(s);	
		
		
		
		
		
		
		
		
	}

}
