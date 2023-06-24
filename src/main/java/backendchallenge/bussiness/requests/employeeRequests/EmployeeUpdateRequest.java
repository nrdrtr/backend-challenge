package backendchallenge.bussiness.requests.employeeRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeUpdateRequest {


    private String firstName;
    private String lastName;
    private String email;
}

