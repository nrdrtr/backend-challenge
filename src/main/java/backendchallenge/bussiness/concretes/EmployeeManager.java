package backendchallenge.bussiness.concretes;

import backendchallenge.bussiness.abstracts.EmployeeService;
import backendchallenge.bussiness.requests.employeeRequests.EmployeeSaveRequest;
import backendchallenge.bussiness.requests.employeeRequests.EmployeeUpdateRequest;
import backendchallenge.bussiness.response.employeeResponse.EmployeeGetAllResponse;
import backendchallenge.bussiness.response.employeeResponse.EmployeeSaveResponse;
import backendchallenge.bussiness.response.employeeResponse.EmployeeUpdateResponse;
import backendchallenge.bussiness.rules.EmployeeBusinessRules;
import backendchallenge.core.utilities.exception.ResourceNotFoundException;
import backendchallenge.core.utilities.mapper.ModelMapperService;
import backendchallenge.dataAccess.abstracts.EmployeeDao;
import backendchallenge.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private ModelMapperService modelMapperService;
    private EmployeeDao employeeDao;
    private EmployeeBusinessRules employeeBusinessRules;

    @Override
    public EmployeeSaveResponse saveEmployee(EmployeeSaveRequest request) {
        Employee employee = this.modelMapperService.forRequest().map(request, Employee.class);
        this.employeeBusinessRules.checkIfEmployeeEmailExists(employee.getEmail());
        this.employeeDao.save(employee);
        return new EmployeeSaveResponse(true, "Employee başarıyla kaydedildi", employee);


    }

    @Override
    public EmployeeUpdateResponse updateEmployee(int id, EmployeeUpdateRequest request) throws ResourceNotFoundException {

        Employee employee = this.employeeDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("bu id'ye ait çalışan bulunamadı :" + id));

        employee.setEmail(request.getEmail());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());

        this.employeeDao.save(employee);
        return new EmployeeUpdateResponse(true, "Çalışan başarıyla güncellendi", employee);
    }

    @Override
    public void delete(int id) throws ResourceNotFoundException {

        this.employeeDao.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("bu id'ye ait çalışan bulunamadı :" + id));

        this.employeeDao.deleteById(id);

    }


    @Override
    public List<EmployeeGetAllResponse> getAll() {
        this.employeeBusinessRules.checkIfEmployeeExists();

        List<Employee> employees = this.employeeDao.findAll();

        List<EmployeeGetAllResponse> modelsResponse = employees.stream().map(employee -> this.modelMapperService.forResponse().map(employee, EmployeeGetAllResponse.class)).collect(Collectors.toList());

        return modelsResponse;
    }

}
