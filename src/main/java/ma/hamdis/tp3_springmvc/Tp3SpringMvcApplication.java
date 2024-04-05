package ma.hamdis.tp3_springmvc;

import ma.hamdis.tp3_springmvc.entities.Medecin;
import ma.hamdis.tp3_springmvc.entities.Patient;
import ma.hamdis.tp3_springmvc.repository.MedecinRepository;
import ma.hamdis.tp3_springmvc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp3SpringMvcApplication {
    @Autowired
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    public static void main(String[] args) {
        SpringApplication.run(Tp3SpringMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository, MedecinRepository medecinRepository){
        return args -> {
            Stream.of("Mohammed","Aya","Nour").forEach(name->{
                Patient patient=new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(true);
                patientRepository.save(patient);
            });
            Stream.of("Aya","Yahya","Nour").forEach(name->{
                Medecin medecin=new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                medecinRepository.save(medecin);
            });

        };
    }
}
