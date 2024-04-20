package pl.arkadiusz.applicationtransporeon.model.dto.customer;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressDto {

    private final Long id;
    private final String streetAddress;
    private final String postalCode;
    private final String cityName;
    private final String countryName;
}
