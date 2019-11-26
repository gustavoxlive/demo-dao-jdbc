package dao;

import dao.impl.SellerDaoJDBC;
import db.DB;

public class FactoryDao {
	
	//cria um data acess object de seller retornando uma nova instancia da classe ja implementada
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
}
