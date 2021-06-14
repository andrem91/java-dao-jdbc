package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: departmentInsert insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted new Department. Id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: department update ===");
		dep = departmentDao.findById(1);
		dep.setName("Craft Beer");
		departmentDao.update(dep);
		System.out.println("Update Completed!");
		
		System.out.println("\n=== TEST 4: department delete ===");
		System.out.print("Enter id for delete a department: ");
		int id = scan.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		
		scan.close();
	}

}
