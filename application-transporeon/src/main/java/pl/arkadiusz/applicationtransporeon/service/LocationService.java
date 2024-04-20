package pl.arkadiusz.applicationtransporeon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.arkadiusz.applicationtransporeon.exception.LocationNotFoundException;
import pl.arkadiusz.applicationtransporeon.mapper.model.BaseLocationMapper;
import pl.arkadiusz.applicationtransporeon.model.dto.BaseLocationDto;
import pl.arkadiusz.applicationtransporeon.model.entity.BaseLocation;
import pl.arkadiusz.applicationtransporeon.repository.LocationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public List<BaseLocationDto> getLocations() {
        final List<BaseLocation> locations = locationRepository.findAll();
        return locations.stream()
                .map(BaseLocationMapper::map)
                .collect(Collectors.toList());
    }

    public List<BaseLocationDto> getLocationsByCountryName(final String countryName) {
        final List<BaseLocation> locations = locationRepository.findByCountryName(countryName);
        return locations.stream()
                .map(BaseLocationMapper::map)
                .collect(Collectors.toList());
    }

    public BaseLocationDto getLocationByCityName(final String cityName) {
        final BaseLocation baseLocation = getBaseLocationWithCityName(cityName);
        return BaseLocationMapper.map(baseLocation);
    }

    public BaseLocationDto saveBaseLocation(final BaseLocationDto baseLocationDto) {
        final BaseLocation baseLocation = BaseLocationMapper.map(baseLocationDto);
        return BaseLocationMapper.map(locationRepository.save(baseLocation));
    }

    public BaseLocationDto updateBaseLocation(final BaseLocationDto baseLocationDto) {
        final BaseLocation baseLocation = locationRepository.findById(baseLocationDto.getId()).get();
        return BaseLocationMapper.map(locationRepository.save(baseLocation));
    }

    public void deleteBaseLocation(final String cityName) {
        final BaseLocation baseLocation = getBaseLocationWithCityName(cityName);
        locationRepository.delete(baseLocation);
    }

    private BaseLocation getBaseLocationWithCityName(final String cityName) {
        return locationRepository.findByCityName(cityName).orElseThrow(() -> new LocationNotFoundException("Location not found!"));
    }
}
