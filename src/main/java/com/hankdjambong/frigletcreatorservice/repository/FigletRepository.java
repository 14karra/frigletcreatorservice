package com.hankdjambong.frigletcreatorservice.repository;

import com.hankdjambong.frigletcreatorservice.entity.Figlet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FigletRepository extends JpaRepository<Figlet, Long> {
}
