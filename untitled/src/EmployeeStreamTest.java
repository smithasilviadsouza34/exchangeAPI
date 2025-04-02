import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeStreamTest {

    public static void main(String[] args) {
        // Creating department
        Department hrDepartment = new Department("Human Resources", 101);

        // Creating employee associated with the department
        Employee employee1 = new Employee(1, 10000.0, hrDepartment, "Alice");
        Employee employee2 = new Employee(2, 20.0, hrDepartment,"Smitha");
        Department adminDepartment = new Department("Admin", 102);
        Employee employee3 = new Employee(2, 20000.0, adminDepartment,"Nishu");
        Employee employee4 = new Employee(2, 20001.0, adminDepartment,"Benny");
        List<Employee> employeeList=new ArrayList<>();

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

        Optional<Employee> result=employeeList.stream().filter(e->e.getSalary()>40).findFirst();

       result.ifPresent(value -> System.out.println(value.getEmployeeName()));

       //employeeList.stream().collect(Collectors.groupingBy(employee -> employee.getDepartment()))
    }
}
