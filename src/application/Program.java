package application;

import java.util.Date;

import dao.FactoryDao;
import dao.SellerDao;
import dao.impl.SellerDaoJDBC;
import entities.Department;
import entities.Seller;

public class Program {

	public static void main(String[] args) {
				
		SellerDao sellerDao = FactoryDao.createSellerDao();
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		
		
		
		
	}

}
