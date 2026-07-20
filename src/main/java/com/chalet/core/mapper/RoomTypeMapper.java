package com.chalet.core.mapper;

import com.chalet.core.dto.request.RoomTypeRequest;
import com.chalet.core.dto.response.RoomTypeResponse;
import com.chalet.core.entity.DbRoomType;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomTypeMapper {

  RoomTypeResponse toDto(DbRoomType RoomType);

  List<RoomTypeResponse> toDto(List<DbRoomType> RoomType);

  DbRoomType toEntity(RoomTypeRequest RoomType);

  List<DbRoomType> toEntity(List<RoomTypeRequest> RoomType);
}
