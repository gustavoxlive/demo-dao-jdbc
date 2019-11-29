package application;

import java.util.List;

import dao.DepartmentDao;
import dao.FactoryDao;
import entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao dep = FactoryDao.createDepartmentDao();
		
		//INSERT
//		Department insertingDepartment = new Department(null, "Music");
//		dep.insert(insertingDepartment);
		
		//DELETE
//		dep.deleteById(12);
//		dep.deleteById(13);
//		dep.deleteById(14);
		
		//UPDATE
//		insertingDepartment.setName("Instruments");
//		dep.update(insertingDepartment);
		
		//FIND BY ID
//		Department deps = dep.findById(5);
//		System.out.println(deps);

		//FIND ALL
		List<Department> list = dep.findAll();
		
		list.forEach(System.out::println);
		
	}

}
