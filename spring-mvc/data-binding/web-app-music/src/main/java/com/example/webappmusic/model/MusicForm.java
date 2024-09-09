package com.example.webappmusic.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class MusicForm {
    private int id;
    private String name;
    private String artist;
    private String types;
    private MultipartFile file;

    public MusicForm() {}

    public MusicForm(int id, String name, String artist, String types, MultipartFile file) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.types = types;
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
