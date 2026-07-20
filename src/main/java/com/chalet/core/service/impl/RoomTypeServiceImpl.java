package com.chalet.core.service.impl;

import com.chalet.core.dto.request.RoomTypeRequest;
import com.chalet.core.dto.response.RoomTypeResponse;
import com.chalet.core.entity.DbRoomType;
import com.chalet.core.exception.DuplicateResourceException;
import com.chalet.core.exception.ResourceNotFoundException;
import com.chalet.core.mapper.RoomTypeMapper;
import com.chalet.core.repository.RoomTypeRepository;
import com.chalet.core.service.RoomTypeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.chalet.core.util.Constants.ROOM_TYPE_ALREADY_EXISTS;
import static com.chalet.core.util.Constants.ROOM_TYPE_NOT_FOUND;

@Service
@AllArgsConstructor
public class RoomTypeServiceImpl implements RoomTypeService {

  private final RoomTypeRepository roomTypeRepository;
  private final RoomTypeMapper roomTypeMapper;

  @Override
  public List<RoomTypeResponse> getAllRoomTypes() {
    return roomTypeMapper.toDto(roomTypeRepository.findAll());
  }

  @Override
  public RoomTypeResponse updateRoomType(Long id, RoomTypeRequest roomTypeRequest) {
    DbRoomType existingRoomType = roomTypeRepository.findById(id)
            .orElseThrow(() -> (new ResourceNotFoundException(ROOM_TYPE_NOT_FOUND.formatted(id))));

    existingRoomType.setTypeName(roomTypeRequest.getTypeName());
    existingRoomType.setPricePerNight(roomTypeRequest.getPricePerNight());
    return roomTypeMapper.toDto(roomTypeRepository.save(existingRoomType));
  }

  @Override
  public RoomTypeResponse getSingleRoomType(Long id) {
    return roomTypeMapper.toDto(roomTypeRepository.findById(id)
            .orElseThrow(() -> (new ResourceNotFoundException(ROOM_TYPE_NOT_FOUND.formatted(id)))));
  }

  @Override
  @Transactional
  public RoomTypeResponse createRoomType(RoomTypeRequest roomTypeRequest) {
    if (roomTypeRepository.findByTypeName(roomTypeRequest.getTypeName()).isPresent()) {
      throw new DuplicateResourceException(ROOM_TYPE_ALREADY_EXISTS);
    }
    return roomTypeMapper.toDto(roomTypeRepository.save(roomTypeMapper.toEntity(roomTypeRequest)));
  }

  @Override
  public void deleteRoomType(Long id) {
    roomTypeRepository.findById(id)
            .orElseThrow(() -> (new ResourceNotFoundException(ROOM_TYPE_NOT_FOUND.formatted(id))));
    roomTypeRepository.deleteById(id);
  }
}
