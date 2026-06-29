package com.aaruchalet.repository;

import com.aaruchalet.entity.DbBooking;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<DbBooking, Long> {
  List<DbBooking> findByCustomerId(Long customerId);

  List<DbBooking> findByRoomId(Long roomId);
}
