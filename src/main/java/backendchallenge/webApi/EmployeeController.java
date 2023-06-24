package backendchallenge.webApi;


import backendchallenge.bussiness.abstracts.EmployeeService;
import backendchallenge.bussiness.requests.employeeRequests.EmployeeSaveRequest;
import backendchallenge.bussiness.requests.employeeRequests.EmployeeUpdateRequest;
import backendchallenge.bussiness.response.employeeResponse.EmployeeGetAllResponse;
import backendchallenge.bussiness.response.employeeResponse.EmployeeSaveResponse;
import backendchallenge.bussiness.response.employeeResponse.EmployeeUpdateResponse;
import backendchallenge.core.utilities.exception.ResourceNotFoundException;
import backendchallenge.dataAccess.abstracts.EmployeeDao;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/getall")//http://localhost:8080/api/employee/getAll
    public ResponseEntity<HashMap<String, Object>> getAll() {
        HashMap<String, Object> map = new HashMap<>();
        List<EmployeeGetAllResponse> employees = this.employeeService.getAll();
        map.put("Çalışanlar listelendi", employees);
        return ResponseEntity.ok(map);
    }

    @PostMapping("/save")//http://localhost:8080/api/employee/save
    public ResponseEntity<?> save(@RequestBody EmployeeSaveRequest request) {
        return ResponseEntity.ok(this.employeeService.saveEmployee(request));
    }

    @PutMapping("/update/{id}")//http://localhost:8080/api/employee/update
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EmployeeUpdateRequest request) throws ResourceNotFoundException{

        EmployeeUpdateResponse response = this.employeeService.updateEmployee(id, request);

        if (!response.isSuccess()) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deleteById/{id}")//http://localhost:8080/api/employee/deleteById
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") int employeeId) throws ResourceNotFoundException {
        this.employeeService.delete(employeeId);
        return new ResponseEntity<>(employeeId + " numaralı çalışan başarıyla silindi", HttpStatus.OK);

    }
}
