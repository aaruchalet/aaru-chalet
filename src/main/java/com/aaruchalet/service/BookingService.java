package com.aaruchalet.service;

import com.aaruchalet.dto.request.BookingRequest;
import com.aaruchalet.dto.response.BookingResponse;
import jakarta.validation.Valid;
import java.util.List;

public interface BookingService {

  BookingResponse createBooking(BookingRequest request);

  BookingResponse getBookingById(Long id);

  BookingResponse getBookingByRoomId(Long id);

  BookingResponse getBookingByCustomerIdAndCheckInDateGreaterThan(Long id);

  List<BookingResponse> findBookingsByCustomerId(Long customerId);

  List<BookingResponse> findBookingsByRoomId(@Valid Long customerId);
}
