package dao;

import dao.impl.SellerDaoJDBC;

public class FactoryDao {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
}
