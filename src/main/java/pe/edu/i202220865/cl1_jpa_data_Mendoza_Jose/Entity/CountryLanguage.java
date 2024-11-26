package pe.edu.i202220865.cl1_jpa_data_Mendoza_Jose.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name = "countrylanguage")

public class CountryLanguage {

    @EmbeddedId
  private CountryLenguagePk countryLenguagePk;

    private String IsOfficial;

    private Double Percentage;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("CountryCode")
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    private Country country;


}
