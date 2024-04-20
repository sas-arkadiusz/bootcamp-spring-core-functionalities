package pl.arkadiusz.applicationtransporeon.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.arkadiusz.applicationtransporeon.model.entity.BaseLocation;
import pl.arkadiusz.applicationtransporeon.model.entity.customer.Customer;

@Getter
@Builder
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PackDto {

    private final Long id;
    private final Customer customer;
    private final BaseLocation baseLocation;
}
