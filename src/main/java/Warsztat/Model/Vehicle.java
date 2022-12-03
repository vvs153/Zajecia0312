package Warsztat.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String vin;
    private String regNr;

    @OneToMany(mappedBy = "vehicle")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Service> serviceSet;
}
