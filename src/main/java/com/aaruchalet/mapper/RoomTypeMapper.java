package com.aaruchalet.mapper;

import com.aaruchalet.dto.request.RoomTypeRequest;
import com.aaruchalet.dto.response.RoomTypeResponse;
import com.aaruchalet.entity.DbRoomType;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomTypeMapper {

  RoomTypeResponse toDto(DbRoomType RoomType);

  List<RoomTypeResponse> toDto(List<DbRoomType> RoomType);

  DbRoomType toEntity(RoomTypeRequest RoomType);

  List<DbRoomType> toEntity(List<RoomTypeRequest> RoomType);
}
