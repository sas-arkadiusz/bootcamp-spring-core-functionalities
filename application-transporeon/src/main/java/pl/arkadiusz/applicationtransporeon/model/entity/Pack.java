package pl.arkadiusz.applicationtransporeon.model.entity;

import lombok.*;
import pl.arkadiusz.applicationtransporeon.model.entity.customer.Customer;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Pack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "base_location_id", nullable=false)
    private BaseLocation baseLocation;
}
