package application;

import java.util.List;

import dao.FactoryDao;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = FactoryDao.createSellerDao();
		
		
		System.out.println("======== test 1: seller findById ========");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n======== test 2: seller findByDepartment ========");
		Department dep1 = new Department(3, null);
		List<Seller> list = sellerDao.findByDepartment(dep1);
		for(Seller x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n======== test 3: seller findAll ========");
		List<Seller> list2 = sellerDao.findAll();
		for(Seller x : list2) {
			System.out.println(x);
		}
		
	}

}
