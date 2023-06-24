package backendchallenge.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;


    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_address")
    private String companyAddress;


    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "website")
    private String webSite;


}
