package com.websystique.springboot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.websystique.springboot.model.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, String> {
    Song findByTitle(String title);
}