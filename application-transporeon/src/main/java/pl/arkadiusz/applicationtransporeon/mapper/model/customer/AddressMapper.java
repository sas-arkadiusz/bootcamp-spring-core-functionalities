package pl.arkadiusz.applicationtransporeon.mapper.model.customer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.arkadiusz.applicationtransporeon.model.dto.customer.AddressDto;
import pl.arkadiusz.applicationtransporeon.model.entity.customer.Address;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressMapper {

    public static Address map(final AddressDto addressDto) {
        return Address.builder()
                .id(addressDto.getId())
                .streetAddress(addressDto.getStreetAddress())
                .postalCode(addressDto.getPostalCode())
                .cityName(addressDto.getCityName())
                .countryName(addressDto.getCountryName())
                .build();
    }

    public static AddressDto map(final Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .streetAddress(address.getStreetAddress())
                .postalCode(address.getPostalCode())
                .cityName(address.getCityName())
                .countryName(address.getCountryName())
                .build();
    }
}
