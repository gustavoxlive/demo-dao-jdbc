package application;

import dao.FactoryDao;
import dao.SellerDao;
import entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("======== test 1: seller findById ========");
		SellerDao sellerDao = FactoryDao.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		
		
		
		
	}

}
