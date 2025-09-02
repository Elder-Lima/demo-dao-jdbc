package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: department findById ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);

        System.out.println("=== TEST 2: department findAll ===");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);

        System.out.println("=== TEST 3: insert Department ===");
        Department newDepartment = new Department(null, "Devs");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("=== TEST 4: update Department ===");
        Department updateDepartment = departmentDao.findById(9);
        updateDepartment.setName("Cars");
        departmentDao.update(updateDepartment);
        System.out.println("Update Completed");

        System.out.println("=== TEST 5: delete Department ===");
        departmentDao.deleteById(10);
        System.out.println("Department deleted");

    }
}
