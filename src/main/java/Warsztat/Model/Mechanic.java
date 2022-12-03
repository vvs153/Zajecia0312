package Warsztat.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String qualifications;
    private String specialisation;

    @OneToMany(mappedBy = "mechanic")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Service> services;
}
