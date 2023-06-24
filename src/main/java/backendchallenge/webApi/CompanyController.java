package backendchallenge.webApi;

import backendchallenge.bussiness.abstracts.CompanyService;
import backendchallenge.bussiness.requests.companyRequests.CompanySaveRequest;
import backendchallenge.bussiness.requests.companyRequests.CompanyUpdateRequest;
import backendchallenge.bussiness.response.companyResponse.CompanyGetAllResponse;
import backendchallenge.bussiness.response.companyResponse.CompanySaveResponse;
import backendchallenge.bussiness.response.companyResponse.CompanyUpdateResponse;
import backendchallenge.core.utilities.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {

    private CompanyService companyService;

    @GetMapping("/getall")//http://localhost:8080/api/company/getall
    public ResponseEntity<HashMap<String, Object>> getAll() {
        HashMap<String, Object> map = new HashMap<>();
        List<CompanyGetAllResponse> companies = this.companyService.getAll();
        map.put("Şirketler listelendi", companies);

        return ResponseEntity.ok(map);
    }


    @PostMapping("/save")//http://localhost:8080/api/company/save
    public ResponseEntity<?> save(@RequestBody CompanySaveRequest request) {
        CompanySaveResponse response = this.companyService.saveCompany(request);

        if (!response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")//http://localhost:8080/api/company/update
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody CompanyUpdateRequest request) throws ResourceNotFoundException {

        CompanyUpdateResponse response = this.companyService.updateCompany(id, request);

        if (!response.isSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("/deleteById/{id}")//http://localhost:8080/api/company/deleteById
    public ResponseEntity<String> deleteCompanyById(@PathVariable(value = "id") int employeeId) throws ResourceNotFoundException {
        this.companyService.deleteCompanyId(employeeId);
        return new ResponseEntity<>(employeeId + " numaralı şirket başarıyla silindi", HttpStatus.OK);

    }
}
