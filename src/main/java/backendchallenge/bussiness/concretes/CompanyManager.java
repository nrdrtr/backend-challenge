package backendchallenge.bussiness.concretes;

import backendchallenge.bussiness.abstracts.CompanyService;
import backendchallenge.bussiness.requests.companyRequests.CompanySaveRequest;
import backendchallenge.bussiness.requests.companyRequests.CompanyUpdateRequest;
import backendchallenge.bussiness.response.companyResponse.CompanyGetAllResponse;
import backendchallenge.bussiness.response.companyResponse.CompanySaveResponse;
import backendchallenge.bussiness.response.companyResponse.CompanyUpdateResponse;
import backendchallenge.bussiness.rules.CompanyBusinessRules;
import backendchallenge.core.utilities.exception.ResourceNotFoundException;
import backendchallenge.core.utilities.mapper.ModelMapperService;
import backendchallenge.dataAccess.abstracts.CompanyDao;
import backendchallenge.entities.Company;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyManager implements CompanyService {

    private ModelMapperService modelMapperService;
    private CompanyBusinessRules companyBusinessRules;
    private CompanyDao companyDao;

    @Override
    public List<CompanyGetAllResponse> getAll() {
        this.companyBusinessRules.checkIfCompanyExists();

        List<Company> models = this.companyDao.findAll();

        List<CompanyGetAllResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse().map(model, CompanyGetAllResponse.class))
                .collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public CompanySaveResponse saveCompany(CompanySaveRequest request) {
        Company company = this.modelMapperService.forRequest().map(request, Company.class);

        this.companyBusinessRules.checkIfCompanyNameExists(company.getCompanyName());
        this.companyDao.save(company);
        return new CompanySaveResponse(true, "Şirket başarıyla kaydedildi", company);

    }

    @Override
    public CompanyUpdateResponse updateCompany(int id, CompanyUpdateRequest request) throws ResourceNotFoundException{
        Company company = this.companyDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("bu id'ye ait şirket bulunamadı :" + id));

        company.setCompanyName(request.getCompanyName());
        company.setCompanyAddress(request.getCompanyAddress());
        company.setPhoneNumber(request.getPhoneNumber());
        company.setWebSite(request.getWebSite());

        this.companyDao.save(company);
        return new CompanyUpdateResponse(true, "Şirket başarıyla güncellendi");
    }


    @Override
    public void deleteCompanyId(int id) throws ResourceNotFoundException {
        this.companyDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("bu id'ye ait şirket bulunamadı :" + id));
        this.companyDao.deleteById(id);
    }


}
