package com.aaruchalet.service.impl;

import com.aaruchalet.dto.request.BookingRequest;
import com.aaruchalet.dto.response.BookingResponse;
import com.aaruchalet.entity.DbBooking;
import com.aaruchalet.entity.DbCustomer;
import com.aaruchalet.entity.DbRoom;
import com.aaruchalet.enums.BookingStatus;
import com.aaruchalet.exception.ResourceNotFoundException;
import com.aaruchalet.exception.RoomAlreadyBookedException;
import com.aaruchalet.mapper.BookingMapper;
import com.aaruchalet.repository.BookingRepository;
import com.aaruchalet.repository.CustomerRepository;
import com.aaruchalet.repository.RoomRepository;
import com.aaruchalet.service.BookingService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.aaruchalet.util.Constants.CUSTOMER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

  private final BookingRepository bookingRepository;
  private final BookingMapper bookingMapper;
  private final RoomRepository roomRepository;
  private final CustomerRepository customerRepository;

  @Override
  public List<BookingResponse> findBookingsByCustomerId(Long customerId) {
    return bookingMapper.toDto(bookingRepository.findByCustomerId(customerId));
  }

  @Override
  public List<BookingResponse> findBookingsByRoomId(Long roomId) {
    return bookingMapper.toDto(bookingRepository.findByRoomId(roomId));
  }

  @Override
  @Transactional
  public BookingResponse createBooking(BookingRequest request) {
    DbCustomer customer = customerRepository.findById(request.getCustomerId())
            .orElseThrow(() -> new ResourceNotFoundException(CUSTOMER_NOT_FOUND.formatted(request.getCustomerId())));

    DbRoom room = roomRepository.findAvailableRoomForBooking(
                    request.getRoomTypeId(),
                    request.getCheckInDate(),
                    request.getCheckOutDate())
            .orElseThrow(() ->
                    new RoomAlreadyBookedException("No room available"));

    DbBooking booking = bookingMapper.toEntity(request);

    booking.setCustomer(customer);
    booking.setRoom(room);
    booking.setBookingStatus(BookingStatus.HELD);
    booking.setHoldExpiry(LocalDateTime.now().plusMinutes(10));
    booking = bookingRepository.save(booking);
    return bookingMapper.toDto(booking);
  }

  @Transactional
  public BookingResponse confirmBooking(Long bookingId) {
    DbBooking booking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

    if (booking.getBookingStatus() != BookingStatus.HELD) {
      throw new IllegalStateException("Booking is not on hold.");
    }

    if (booking.getHoldExpiry().isBefore(LocalDateTime.now())) {
      throw new RoomAlreadyBookedException("Booking hold expired.");
    }

    booking.setBookingStatus(BookingStatus.CONFIRMED);
    booking.setHoldExpiry(null);

    return bookingMapper.toDto(booking);
  }

  public void cancelBooking(Long bookingId) {
    DbBooking dbBooking = bookingRepository.findById(bookingId)
            .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

    dbBooking.setBookingStatus(BookingStatus.CANCELLED);
    dbBooking.setHoldExpiry(null);

  }

  @Override
  public BookingResponse getBookingById(Long id) {
    return null;
  }

  @Override
  public BookingResponse getBookingByRoomId(Long id) {
    return null;
  }

  @Override
  public BookingResponse getBookingByCustomerIdAndCheckInDateGreaterThan(Long id) {
    return null;
  }
}
