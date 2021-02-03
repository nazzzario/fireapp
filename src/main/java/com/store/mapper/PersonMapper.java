package com.store.mapper;

import com.store.dto.request.PersonRequest;
import com.store.dto.response.PersonResponse;
import com.store.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    @Mapping(target = "role", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    Person requestToEntity(PersonRequest personRequest);

    @Mapping(target = "role", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    Person requestToEntity(PersonRequest personRequest, @MappingTarget Person person);

    PersonResponse toDtoEntity(Person person);
}
