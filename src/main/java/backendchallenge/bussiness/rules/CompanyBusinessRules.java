package backendchallenge.bussiness.rules;

import backendchallenge.core.utilities.exception.BusinessException;
import backendchallenge.dataAccess.abstracts.CompanyDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CompanyBusinessRules {

    private CompanyDao companyDao;


    public void checkIfCompanyExists( ) {
        if (this.companyDao.findAll().isEmpty()) {
            throw new BusinessException("sistemde kayıtlı bir şirket bulunamadı");
        }
    }
   public void checkIfCompanyNameExists(String  companyName) {

        if(this.companyDao. existsByCompanyName(companyName)) {
            throw new BusinessException(" Bu şirket ismi zaten kayıtlı");
        }
    }
    public void  checkIfEmployeePhoneNumber(String phoneNumber){
        if(phoneNumber.length()!=11){
            throw new BusinessException("Telefon numarası 11 haneli olmalıdır");
        }
    }
}
