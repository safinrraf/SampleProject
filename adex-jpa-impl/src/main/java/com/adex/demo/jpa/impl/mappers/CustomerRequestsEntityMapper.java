package com.adex.demo.jpa.impl.mappers;

import com.adex.demo.domain.models.DomainCustomerRequest;
import com.adex.demo.domain.utils.IpConverter;
import com.adex.demo.jpa.impl.entities.CustomerInvalidRequestEntity;
import com.adex.demo.jpa.impl.entities.CustomerValidRequestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerRequestsEntityMapper {

  @Named("stringIpToLong")
  static Long stringIpToLong(String ip) {
    return IpConverter.ipToLong(ip);
  }

  @Mapping(target = "requestId", ignore = true)
  @Mapping(target = "customerId", source = "customerId")
  @Mapping(target = "tagId", source = "tagId")
  @Mapping(target = "userId", source = "userId")
  @Mapping(target = "remoteIp", source = "remoteIp", qualifiedByName = "stringIpToLong")
  @Mapping(target = "timestamp", source = "timestamp")
  CustomerValidRequestEntity mapValidRequestToEntity(DomainCustomerRequest request);

  @Mapping(target = "requestId", ignore = true)
  @Mapping(target = "customerId", source = "customerId")
  @Mapping(target = "request", source = "requestAsString")
  @Mapping(target = "errorMessage", source = "errorMessage")
  CustomerInvalidRequestEntity mapInvalidRequestToEntity(DomainCustomerRequest request);
}
