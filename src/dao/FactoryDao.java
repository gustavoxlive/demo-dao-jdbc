package dao;

import dao.impl.SellerDaoJDBC;
import db.DB;

public class FactoryDao {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
}
