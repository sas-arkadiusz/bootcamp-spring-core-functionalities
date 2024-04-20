package pl.arkadiusz.applicationtransporeon.mapper.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.arkadiusz.applicationtransporeon.model.dto.PackDto;
import pl.arkadiusz.applicationtransporeon.model.entity.Pack;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PackMapper {

    public static Pack map(final PackDto packDto) {
        return Pack.builder()
                .id(packDto.getId())
                .customer(packDto.getCustomer())
                .baseLocation(packDto.getBaseLocation())
                .build();
    }

    public static PackDto map(final Pack pack) {
        return PackDto.builder()
                .id(pack.getId())
                .customer(pack.getCustomer())
                .baseLocation(pack.getBaseLocation())
                .build();
    }
}
