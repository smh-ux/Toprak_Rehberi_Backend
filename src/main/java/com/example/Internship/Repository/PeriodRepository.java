package com.example.Internship.Repository;

import com.example.Internship.Entity.Period;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeriodRepository extends JpaRepository<Period, Long> {
}