package com.aaruchalet.mapper;

import com.aaruchalet.dto.request.CustomerRequest;
import com.aaruchalet.dto.response.CustomerResponse;
import com.aaruchalet.entity.DbCustomer;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerMapper {
  CustomerResponse toDto(DbCustomer dbCustomer);

  List<CustomerResponse> toDto(List<DbCustomer> dbCustomers);

  DbCustomer toEntity(CustomerRequest customerRequest);

  List<DbCustomer> toEntity(List<CustomerRequest> customerRequests);
}
