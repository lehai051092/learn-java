package com.example.webappmusic.service;

import com.example.webappmusic.model.Music;

import java.util.List;

public interface IMusicService {
    void save(Music music);

    List<Music> getMusics();
}
