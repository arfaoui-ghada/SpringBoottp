package com.example.demo.Repository;

import com.example.demo.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<Reservation,Long> {
}
