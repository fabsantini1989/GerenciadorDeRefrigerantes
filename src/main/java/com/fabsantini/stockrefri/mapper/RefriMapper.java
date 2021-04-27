package com.fabsantini.stockrefri.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.fabsantini.stockrefri.dto.RefriDTO;
import com.fabsantini.stockrefri.entity.Refri;

@Mapper
public abstract class RefriMapper {

    RefriMapper INSTANCE = Mappers.getMapper(RefriMapper.class);

    abstract Refri toModel(RefriDTO refriDTO);

    abstract RefriDTO toDTO(Refri refri);

}

