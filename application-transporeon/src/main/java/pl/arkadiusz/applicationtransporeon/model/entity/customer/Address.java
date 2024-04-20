package pl.arkadiusz.applicationtransporeon.model.entity.customer;

import lombok.*;
import org.springframework.validation.annotation.Validated;
import pl.arkadiusz.applicationtransporeon.constraints.PostalCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Validated
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String streetAddress;

    @PostalCode(message = "AAAAA")
    private String postalCode;

    private String cityName;

    private String countryName;
}
