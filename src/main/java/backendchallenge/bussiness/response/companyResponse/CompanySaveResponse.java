package backendchallenge.bussiness.response.companyResponse;

import backendchallenge.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanySaveResponse {
    private boolean success;
    private String message;
    private Company company;

}
