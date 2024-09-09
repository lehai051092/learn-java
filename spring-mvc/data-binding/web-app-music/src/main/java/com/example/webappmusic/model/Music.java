package com.example.webappmusic.model;

public class Music {
    private int id;
    private String name;
    private String artist;
    private String types;
    private String path;

    public Music() {}

    public Music(int id, String name, String artist, String types, String path) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.types = types;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
