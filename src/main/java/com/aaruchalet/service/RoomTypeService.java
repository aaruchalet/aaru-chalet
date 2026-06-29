package com.aaruchalet.service;

import com.aaruchalet.dto.request.RoomTypeRequest;
import com.aaruchalet.dto.response.RoomTypeResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;

public interface RoomTypeService {
  List<RoomTypeResponse> getAllRoomTypes();

  RoomTypeResponse updateRoomType(Long id, @Valid @RequestBody RoomTypeRequest roomTypeRequest);

  RoomTypeResponse createRoomType(@Valid @RequestBody RoomTypeRequest roomTypeRequest);

  void deleteRoomType(Long id);

  RoomTypeResponse getSingleRoomType(Long id);
}
