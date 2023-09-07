package skypro.employeeBook.service;

import org.springframework.stereotype.Service;
import skypro.employeeBook.dto.Employee;
import skypro.employeeBook.dto.exception.EmployeeAlreadyAddedException;
import skypro.employeeBook.dto.exception.EmployeeNotFoundException;
import skypro.employeeBook.dto.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees;

    private static final int EMPLOYEE_SIZE = 3;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {

        if (employees.size() == EMPLOYEE_SIZE)
            throw new EmployeeStorageIsFullException();

        Employee employee = new Employee(firstName, lastName, department, salary);

        if(employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.add(employee);

        return employee;
    }

    @Override
    public Employee remoteEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee getEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee remoteEmployee(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee getEmployee(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public List<Employee> findAll(){
        return employees;
    }
}
