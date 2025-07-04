package com.example.demo.repository;

import com.example.demo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByPlayerNameContainingIgnoreCase(String keyword);
    List<Player> findTop10ByOrderByHighScoreDesc();



}
