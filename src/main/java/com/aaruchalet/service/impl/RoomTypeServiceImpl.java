package com.aaruchalet.service.impl;

import com.aaruchalet.dto.request.RoomTypeRequest;
import com.aaruchalet.dto.response.RoomTypeResponse;
import com.aaruchalet.entity.DbRoomType;
import com.aaruchalet.exception.DuplicateResourceException;
import com.aaruchalet.exception.ResourceNotFoundException;
import com.aaruchalet.mapper.RoomTypeMapper;
import com.aaruchalet.repository.RoomTypeRepository;
import com.aaruchalet.service.RoomTypeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.aaruchalet.util.Constants.ROOM_TYPE_ALREADY_EXISTS;
import static com.aaruchalet.util.Constants.ROOM_TYPE_NOT_FOUND;

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
