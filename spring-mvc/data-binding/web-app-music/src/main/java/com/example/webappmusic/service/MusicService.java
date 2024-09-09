package com.example.webappmusic.service;

import com.example.webappmusic.model.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicService implements IMusicService {
    private final List<Music> musicList;

    public MusicService() {
        this.musicList = new ArrayList<>();
    }

    @Override
    public void save(Music music) {
        musicList.add(music);
    }

    @Override
    public List<Music> getMusics() {
        return musicList;
    }
}
