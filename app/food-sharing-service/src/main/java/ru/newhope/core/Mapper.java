package ru.newhope.core;

import org.springframework.data.domain.Page;

import java.util.List;

public interface Mapper<ENTITY, DTO> {
    List<DTO> entityListToDtoList(List<ENTITY> source);

    List<DTO> entityPageToDtoList(Page<ENTITY> source);
}
