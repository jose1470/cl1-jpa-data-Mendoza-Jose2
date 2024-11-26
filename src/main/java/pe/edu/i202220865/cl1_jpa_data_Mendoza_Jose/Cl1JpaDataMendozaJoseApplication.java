package pe.edu.i202220865.cl1_jpa_data_Mendoza_Jose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202220865.cl1_jpa_data_Mendoza_Jose.Entity.City;
import pe.edu.i202220865.cl1_jpa_data_Mendoza_Jose.Entity.Country;
import pe.edu.i202220865.cl1_jpa_data_Mendoza_Jose.repository.CountryRepository;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataMendozaJoseApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataMendozaJoseApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


		//	ifPresentOrElse()

		Optional<Country> optional = countryRepository.findById("ARG");

		optional.ifPresentOrElse(
				country -> {
					System.out.println("Lenguajes hablados en (ARG):");
					country.getCountrylanguage().forEach(lang ->
							System.out.println("- " + lang.getCountryLenguagePk().getLanguage())
					);
				}, () -> {
					System.out.println("No existe el país (ARG). Buscando lenguajes para (PER):");
					countryRepository.findById("PER").ifPresentOrElse(
							peru -> {
								peru.getCountrylanguage().forEach(lang ->
										System.out.println("- " + lang.getCountryLenguagePk().getLanguage())
								);
							},
							() -> System.out.println("No existe el país Perú (PER).")
					);
				}
		);


		// Eliminar el país "ARG"
		System.out.println("Eliminando país 'ARG':");
		countryRepository.findById("ARG")
				.ifPresentOrElse(
						country -> {
							countryRepository.deleteById("ARG");
							System.out.println("El país Argentina (ARG) ha sido eliminado.");
						},
						() -> System.out.println("El país Argentina (ARG) no existe.")
				);

// Consultar nuevamente después de eliminar
		System.out.println("Ejecutando consulta para 'ARG' (segunda vez):");
		countryRepository.findById("ARG")
				.ifPresentOrElse(
						country -> {
							System.out.println("País encontrado: Argentina (ARG).");
						},
						() -> System.out.println("No se encontró el país Argentina (ARG). Ejecutando flujo alterno...")
				);


	}
}
