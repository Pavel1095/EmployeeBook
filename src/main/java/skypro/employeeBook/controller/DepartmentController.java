package skypro.employeeBook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.employeeBook.dto.Employee;
import skypro.employeeBook.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(value = "min-salary", params = "department")
    public Employee minSalaryEmployee(){
        return departmentService.minSalaryEmployee(1);
    }

    @GetMapping(value = "max-salary", params = "department")
    public Employee maxSalaryEmployee(){
        return departmentService.maxSalaryEmployee(1);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAll(){
        return departmentService.getAll();
    }

    @GetMapping(value = "/all", params = "department")
    public Collection<Employee> getAllByDepartment(@RequestParam int department) {
        return departmentService.getEmployeesInDepartment(department);
    }
}
