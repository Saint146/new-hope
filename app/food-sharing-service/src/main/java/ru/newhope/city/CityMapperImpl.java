package ru.newhope.city;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityMapperImpl implements CityMapper {

    @Override
    public List<CityDto> entityListToDtoList(List<CityEntity> source) {
        if ( source == null ) {
            return null;
        }

        List<CityDto> list = new ArrayList<CityDto>( source.size() );
        for ( CityEntity CityEntity : source ) {
            list.add( CityEntityToCityDto( CityEntity ) );
        }

        return list;
    }

    @Override
    public List<CityDto> entityPageToDtoList(Page<CityEntity> source) {
        if ( source == null ) {
            return null;
        }

        List<CityDto> list = new ArrayList<CityDto>();
        for ( CityEntity CityEntity : source ) {
            list.add( CityEntityToCityDto( CityEntity ) );
        }

        return list;
    }

    protected CityDto CityEntityToCityDto(CityEntity CityEntity) {
        if ( CityEntity == null ) {
            return null;
        }

        CityDto CityDto = new CityDto();

        if ( CityEntity.getId() != null ) {
            CityDto.setId ( CityEntity.getId() );
        }
        if ( CityEntity.getName() != null ) {
            CityDto.setName( CityEntity.getName() );
        }

        return CityDto;
    }
}
