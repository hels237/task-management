package com.k48.Gestion.des.taches.mapper;

import com.k48.Gestion.des.taches.dto.TacheDto;
import com.k48.Gestion.des.taches.models.Tache;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TacheMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lastUpdate", ignore = true)
    @Mapping(target = "dateCreation", ignore = true)
    Tache toEntity(TacheDto dto);
    
    TacheDto toDTO(Tache tache);
}
