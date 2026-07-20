package com.chalet.core.mapper;

import com.chalet.core.dto.request.CustomerRequest;
import com.chalet.core.dto.response.CustomerResponse;
import com.chalet.core.entity.DbCustomer;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerMapper {
  CustomerResponse toDto(DbCustomer dbCustomer);

  List<CustomerResponse> toDto(List<DbCustomer> dbCustomers);

  @Mapping(target = "id", ignore = true)
  DbCustomer toEntity(CustomerRequest customerRequest);

  List<DbCustomer> toEntity(List<CustomerRequest> customerRequests);
}
