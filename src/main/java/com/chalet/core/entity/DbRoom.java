package com.chalet.core.entity;

import com.chalet.core.enums.RoomStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        name = "room",
        indexes = {
                @Index(name = "idx_room_type", columnList = "room_type_id"),
                @Index(name = "idx_room_status", columnList = "room_status"),
                @Index(name = "idx_room_type_status", columnList = "room_type_id, room_status")
        }
)
public class DbRoom {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String roomNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "room_type_id", nullable = false)
  private DbRoomType roomType;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private RoomStatus roomStatus;
}
