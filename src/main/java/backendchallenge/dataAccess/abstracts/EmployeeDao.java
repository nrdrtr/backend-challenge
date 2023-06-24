package backendchallenge.dataAccess.abstracts;

import backendchallenge.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
//email alanı için kontrol
       //boolean
       boolean existsEmployeeByEmail(String email);




}
