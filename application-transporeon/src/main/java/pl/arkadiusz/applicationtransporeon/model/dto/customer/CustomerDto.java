package pl.arkadiusz.applicationtransporeon.model.dto.customer;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.arkadiusz.applicationtransporeon.model.entity.customer.Address;

@Getter
@Builder
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerDto {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final Address address;
}
