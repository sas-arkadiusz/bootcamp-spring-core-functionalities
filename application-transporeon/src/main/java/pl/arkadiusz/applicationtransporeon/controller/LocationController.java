package pl.arkadiusz.applicationtransporeon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.arkadiusz.applicationtransporeon.exception.LocationNotFoundException;
import pl.arkadiusz.applicationtransporeon.model.request.UserCreateRequest;
import pl.arkadiusz.applicationtransporeon.model.entity.User;
import pl.arkadiusz.applicationtransporeon.mapper.response.AllBaseLocationsResponseMapper;
import pl.arkadiusz.applicationtransporeon.model.dto.BaseLocationDto;
import pl.arkadiusz.applicationtransporeon.model.entity.BaseLocation;
import pl.arkadiusz.applicationtransporeon.model.entity.Pack;
import pl.arkadiusz.applicationtransporeon.model.entity.customer.Address;
import pl.arkadiusz.applicationtransporeon.model.entity.customer.Customer;
import pl.arkadiusz.applicationtransporeon.model.response.BaseLocationsListResponse;
import pl.arkadiusz.applicationtransporeon.repository.AddressRepository;
import pl.arkadiusz.applicationtransporeon.repository.CustomerRepository;
import pl.arkadiusz.applicationtransporeon.repository.LocationRepository;
import pl.arkadiusz.applicationtransporeon.repository.UserRepository;
import pl.arkadiusz.applicationtransporeon.service.LocationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
@Validated
public class LocationController {

    private final LocationService locationService;

    private final LocationRepository locationRepository;
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    public ResponseEntity<BaseLocationsListResponse> getAllLocations() {
        final List<BaseLocationDto> allBaseLocations = locationService.getLocations();

        return ResponseEntity.ok(AllBaseLocationsResponseMapper.map(allBaseLocations));
    }

    @GetMapping("/all/{countryName}")
    //public ResponseEntity<BaseLocationsListResponse> getAllLocationsByCountryName(@PathVariable("countryName") @Length(max = 3) final String countryName) {
    public ResponseEntity<BaseLocationsListResponse> getAllLocationsByCountryName(@PathVariable("countryName") final String countryName) {
        final List<BaseLocationDto> baseLocationByCountryName = locationService.getLocationsByCountryName(countryName);

        return ResponseEntity.ok(AllBaseLocationsResponseMapper.map(baseLocationByCountryName));
    }

    @GetMapping("/byCityName")
    public ResponseEntity<BaseLocationDto> getLocationByCityName(@RequestParam final String cityName) {
        try {
            return ResponseEntity.ok(locationService.getLocationByCityName(cityName));
        } catch (LocationNotFoundException exception) {
            throw new LocationNotFoundException("Location not found!");
        }
    }

    @PostMapping("/customer")
    public void createUser(@RequestBody @Valid final UserCreateRequest request) {
        final User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_ADMIN");

        userRepository.save(user);
    }

    @PostMapping("/prepareDataForTestingPurposes")
    public ResponseEntity<BaseLocationDto> prepareDataForTestingPurposes() {
        final var address = Address.builder()
                .streetAddress("A")
                .cityName("B")
                .countryName("C")
                .postalCode("00-028")
                .build();
        final var savedAddress = addressRepository.save(address);

        final var customer = Customer.builder()
                .firstName("A")
                .lastName("B")
                .address(savedAddress)
                .build();
        customerRepository.save(customer);

        final var location = BaseLocation.builder()
                .cityName("Warsaw")
                .countryName("Poland")
                .build();
        locationRepository.save(location);

        final var pack = Pack.builder()
                .customer(customer)
                .baseLocation(location)
                .build();

        return ResponseEntity.ok(locationService.getLocationByCityName("Warsaw"));
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody @Valid final UserCreateRequest request) {
        final User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ROLE_ADMIN");

        userRepository.save(user);
    }

    @GetMapping("/addUser")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
