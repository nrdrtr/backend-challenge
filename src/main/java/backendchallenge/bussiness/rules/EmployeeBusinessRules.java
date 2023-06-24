package backendchallenge.bussiness.rules;

import backendchallenge.core.utilities.exception.BusinessException;
import backendchallenge.dataAccess.abstracts.EmployeeDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeBusinessRules {

    private EmployeeDao employeeDao;


   public void checkIfEmployeeExists( ) {
        if (this.employeeDao.findAll().isEmpty()) {
            throw new BusinessException("sistemde kayıtlı bir kullanıcı bulunamadı");
         }
    }

    public void checkIfEmployeeEmailExists(String email) {

        if (this.employeeDao.existsEmployeeByEmail(email)) {
            throw new BusinessException(" Bu email zaten kayıtlı");
        }
    }

}
