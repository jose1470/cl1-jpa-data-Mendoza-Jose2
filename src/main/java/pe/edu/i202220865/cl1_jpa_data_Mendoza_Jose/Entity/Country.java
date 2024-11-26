package pe.edu.i202220865.cl1_jpa_data_Mendoza_Jose.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name = "country")

public class Country {
    @Id
    private String Code;
    private String Name;
    private String Region;
    private String continent;
    private Double SurfaceArea;
    private Integer IndepYear;
    private int Population;
    private Double LifeExpectancy;
    private Double GNP;
    private Double GNPOld;
    private String LocalName;
    private String GovernmentForm;
    private String HeadOfState;
    private Integer Capital;
    private String Code2;


    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true,fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<City> city;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true,fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<CountryLanguage> countrylanguage;


}
