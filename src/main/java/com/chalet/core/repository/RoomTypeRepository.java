package com.chalet.core.repository;

import com.chalet.core.entity.DbRoomType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<DbRoomType, Long> {
  Optional<DbRoomType> findByTypeName(String typeName);
}
