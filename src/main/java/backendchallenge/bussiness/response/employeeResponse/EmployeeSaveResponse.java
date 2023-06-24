package backendchallenge.bussiness.response.employeeResponse;

import backendchallenge.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSaveResponse {
    private boolean success;
    private String message;
    private Employee employee;
}
