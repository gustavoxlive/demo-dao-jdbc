package application;

import java.util.List;
import java.util.Scanner;

import dao.FactoryDao;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = FactoryDao.createSellerDao();
		
		
		System.out.println("======== test 1: seller findById ========");
		Seller seller = sellerDao.findById(1);
		System.out.println(seller);
		
		System.out.println("\n======== test 2: seller findByDepartment ========");
		Department dep1 = new Department(4, null);
		List<Seller> list = sellerDao.findByDepartment(dep1);
		for(Seller x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n======== test 3: seller findAll ========");
		List<Seller> list2 = sellerDao.findAll();
		list2.forEach(System.out::println);
		
//		System.out.println("\n======== test 4: seller insert ========");
//		Seller newSeller = new Seller(null, "Luiz Gustavo", "gustavo_x@live.com", new Date(), 1500.0, dep1);
//		sellerDao.insert(newSeller);
//		System.out.println("Inserted! Seller id: " +newSeller.getId());

		System.out.println("\n======== test 5: seller update ========");
		seller = sellerDao.findById(1);
		seller.setName("Maeve Shadowsong");
		sellerDao.update(seller);
		System.out.println("Update complete!");
		
		System.out.println("\n======== test 6: seller delete ========");
		System.out.print("Enter ID for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		
		sc.close();
	}

}
