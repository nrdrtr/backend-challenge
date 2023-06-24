package backendchallenge.bussiness.requests.companyRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyUpdateRequest {

        private String companyName;
        private String companyAddress;
        private String phoneNumber;
        private String webSite;
}
