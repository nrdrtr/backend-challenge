package backendchallenge.dataAccess.abstracts;

import backendchallenge.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company,Integer> {

    boolean existsByCompanyName(String companyName);
}
