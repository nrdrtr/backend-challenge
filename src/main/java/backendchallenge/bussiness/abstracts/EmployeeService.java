package backendchallenge.bussiness.abstracts;

import backendchallenge.bussiness.requests.employeeRequests.EmployeeSaveRequest;
import backendchallenge.bussiness.requests.employeeRequests.EmployeeUpdateRequest;
import backendchallenge.bussiness.response.employeeResponse.EmployeeGetAllResponse;
import backendchallenge.bussiness.response.employeeResponse.EmployeeSaveResponse;
import backendchallenge.bussiness.response.employeeResponse.EmployeeUpdateResponse;
import backendchallenge.core.utilities.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {

    EmployeeSaveResponse saveEmployee(EmployeeSaveRequest request);
    EmployeeUpdateResponse updateEmployee(int id, EmployeeUpdateRequest request) throws ResourceNotFoundException;
    void delete(int id) throws ResourceNotFoundException;
    List<EmployeeGetAllResponse> getAll();
}
