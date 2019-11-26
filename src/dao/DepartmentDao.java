package dao;

import java.util.List;

import entities.Department;

//CONTRATO DO DEPARTAMENTO (DATA ACESS OBJECT)
public interface DepartmentDao {
	
	void insert(Department obj);
	void update(Department obj);
	void deleteById(Integer id);
	Department findById(Integer id);
	List<Department> findAll();
}
