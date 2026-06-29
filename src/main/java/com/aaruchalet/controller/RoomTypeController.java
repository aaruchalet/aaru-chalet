package com.aaruchalet.controller;

import com.aaruchalet.dto.common.ApiResponse;
import com.aaruchalet.dto.request.RoomTypeRequest;
import com.aaruchalet.dto.response.RoomTypeResponse;
import com.aaruchalet.service.RoomTypeService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.aaruchalet.util.Constants.ROOM_TYPE_DELETED_SUCCESSFULLY;
import static com.aaruchalet.util.Constants.ROOM_TYPE_UPDATED_SUCCESSFULLY;

@RestController
@RequestMapping("/api/v1/room-types")
@AllArgsConstructor
public class RoomTypeController {

  private final RoomTypeService roomTypeService;

  @GetMapping
  public ResponseEntity<ApiResponse<List<RoomTypeResponse>>> getAllRoomTypes() {
    return ResponseEntity.ok(ApiResponse.success(roomTypeService.getAllRoomTypes()));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<RoomTypeResponse>> getSingleRoomType(@PathVariable Long id) {
    return ResponseEntity.ok(ApiResponse.success(roomTypeService.getSingleRoomType(id)));
  }

  @PostMapping
  public ResponseEntity<ApiResponse<RoomTypeResponse>> createRoomType(@Valid @RequestBody RoomTypeRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(ApiResponse.success(roomTypeService.createRoomType(request)));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ApiResponse<RoomTypeResponse>> updateRoomType(@PathVariable Long id, @Valid @RequestBody RoomTypeRequest request) {
    return ResponseEntity.ok(
            ApiResponse.success(
                    ROOM_TYPE_UPDATED_SUCCESSFULLY,
                    roomTypeService.updateRoomType(id, request)
            )
    );
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse<Void>> deleteRoomType(@PathVariable Long id) {
    roomTypeService.deleteRoomType(id);
    return ResponseEntity.ok(ApiResponse.success(ROOM_TYPE_DELETED_SUCCESSFULLY)
    );
  }
}
