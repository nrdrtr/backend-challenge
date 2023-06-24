package backendchallenge.bussiness.abstracts;

import backendchallenge.bussiness.requests.companyRequests.CompanySaveRequest;
import backendchallenge.bussiness.requests.companyRequests.CompanyUpdateRequest;
import backendchallenge.bussiness.response.companyResponse.CompanyGetAllResponse;
import backendchallenge.bussiness.response.companyResponse.CompanySaveResponse;
import backendchallenge.bussiness.response.companyResponse.CompanyUpdateResponse;
import backendchallenge.core.utilities.exception.ResourceNotFoundException;


import java.util.List;

public interface CompanyService {
    List<CompanyGetAllResponse> getAll();

    CompanySaveResponse saveCompany(CompanySaveRequest request) ;

    CompanyUpdateResponse updateCompany(int id, CompanyUpdateRequest request)  throws ResourceNotFoundException;

    void deleteCompanyId(int id) throws ResourceNotFoundException;





}
