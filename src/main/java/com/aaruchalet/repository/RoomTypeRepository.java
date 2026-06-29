package com.aaruchalet.repository;

import com.aaruchalet.entity.DbRoomType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<DbRoomType, Long> {
  Optional<DbRoomType> findByTypeName(String typeName);
}
