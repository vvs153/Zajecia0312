package Warsztat.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String job;
    private Double cost;

    @CreationTimestamp
    private LocalDateTime addTime;

    private LocalDateTime leadTime;

    @ManyToOne
    @ToString.Exclude
    private Mechanic mechanic;

    @ManyToOne
    @ToString.Exclude
    private Vehicle vehicle;
}
