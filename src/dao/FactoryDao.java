package dao;

import dao.impl.SellerDaoJDBC;
import db.DB;

public class FactoryDao {
	
	//CRIA UM sellerDaoJDBC 
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
}
