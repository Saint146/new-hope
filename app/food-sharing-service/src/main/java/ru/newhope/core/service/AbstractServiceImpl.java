package ru.newhope.core.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import ru.newhope.core.Mapper;

import java.util.List;


@AllArgsConstructor
public abstract class AbstractServiceImpl<TYPEID, DTO, ENTITY,
        REPOSITORY extends ru.newhope.core.Repository<ENTITY, TYPEID>,
        MAPPER extends Mapper<ENTITY, DTO>>
        implements AbstractService<DTO> {
    private final REPOSITORY repository;
    private final MAPPER mapper;

    @Transactional(readOnly = true)
    public List<DTO> find() {
        Sort sort = getSort();
        PageRequest pageRequest = getPageRequest(sort);

        return mapper.entityPageToDtoList(repository.findAll(pageRequest));
    }

    private Sort getSort() {
        return Sort.by(Sort.Direction.fromString("name"), "name");
    }

    private PageRequest getPageRequest(Sort sort) {
        return  PageRequest.of(1, 10, sort);
    }
}
