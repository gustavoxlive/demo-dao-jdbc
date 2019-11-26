package dao;

import java.util.List;

import entities.Department;
import entities.Seller;

//CONTRATO SELLER (DATA ACESS OBJECT)
public interface SellerDao {

	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller findById(Integer id);
	List<Seller> findAll();
	List<Seller> findByDepartment(Department department);
	
}
