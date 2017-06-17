package com.websystique.springboot.service;

import java.util.List;

import com.websystique.springboot.model.Song;


public interface SongService {

	Song findById(String id);

	Song findByTitle(String title);

	void saveSong(Song song);

	void updateSong(Song song);

	void deleteSongById(String id);

	void deleteAllSong();

	List<Song> findAllSong();

	boolean isSongExist(Song song);
}