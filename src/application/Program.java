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
		Department d = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(d);
		for(Seller x : list) {
			System.out.println(x);
		}
		
	}

}
