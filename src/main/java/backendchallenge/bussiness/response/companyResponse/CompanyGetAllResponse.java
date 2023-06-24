package backendchallenge.bussiness.response.companyResponse;

import backendchallenge.entities.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyGetAllResponse {

    private String companyName;
    private String companyAddress;
    private String phoneNumber;
    private String webSite;
    private List<Employee> employees;



}
