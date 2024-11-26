package pe.edu.i202220865.cl1_jpa_data_Mendoza_Jose.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable

public class CountryLenguagePk {

    @Column(name = "CountryCode")
    private String countryCode;
    @Column(name = "Language")
    private String language;

}
