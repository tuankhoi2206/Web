package com.websystique.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springboot.model.Song;
import com.websystique.springboot.repositories.SongRepository;

@Service("songService")
@Transactional
public class SongServiceImpl implements SongService {

	@Autowired
	private SongRepository userRepository;

	@Override
	public Song findById(String id) {
		return userRepository.findOne(id);
	}

	@Override
	public Song findByTitle(String title) {
//		return null;
		 return userRepository.findByTitle(title);
	}

	@Override
	public void saveSong(Song user) {
		userRepository.save(user);
	}

	@Override
	public void updateSong(Song user) {
		saveSong(user);
	}

	@Override
	public void deleteSongById(String id) {
		userRepository.delete(id);
	}

	@Override
	public void deleteAllSong() {
		userRepository.deleteAll();
	}

	@Override
	public List<Song> findAllSong() {
		return userRepository.findAll();
	}

	@Override
	public boolean isSongExist(Song user) {
		return findByTitle(user.getTitle()) != null;
	}

}
