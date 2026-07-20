package com.chalet.core.controller;

import com.chalet.core.dto.request.BookingRequest;
import com.chalet.core.dto.response.BookingResponse;
import com.chalet.core.service.BookingService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bookings")
@AllArgsConstructor
public class BookingController {

  private final BookingService bookingService;

  @GetMapping("/getBooking")
  public ResponseEntity<List<BookingResponse>> getBookings(@Valid @RequestBody Long customerId) {
    return ResponseEntity.ok(bookingService.findBookingsByCustomerId(customerId));
  }

  @PostMapping("/bookings")
  public ResponseEntity<BookingResponse> createBooking(@Valid @RequestBody BookingRequest bookingRequest) {
    return ResponseEntity.ok(bookingService.createBooking(bookingRequest));
  }
}
