package pe.edu.i202220865.cl1_jpa_data_Mendoza_Jose.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name = "city")

public class City {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

    private String name;

    private Long population;

    private String District;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code")
    private Country country;


}



