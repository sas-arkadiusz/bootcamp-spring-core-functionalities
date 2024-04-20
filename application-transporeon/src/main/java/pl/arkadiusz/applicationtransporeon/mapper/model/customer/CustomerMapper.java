package pl.arkadiusz.applicationtransporeon.mapper.model.customer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.arkadiusz.applicationtransporeon.model.dto.customer.CustomerDto;
import pl.arkadiusz.applicationtransporeon.model.entity.customer.Customer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerMapper {

    public static Customer map(final CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .address(customerDto.getAddress())
                .build();
    }

    public static CustomerDto map(final Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .address(customer.getAddress())
                .build();
    }
}
