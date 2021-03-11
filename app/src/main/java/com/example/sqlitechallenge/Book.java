package com.example.sqlitechallenge;

public class Book {
    private int id;
    private String name;
    private String author;
    private String imageURL;
    private String description;

    public Book(int id, String name, String author, String imageURL, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.imageURL = imageURL;
        this.description = description;
    }

    public Book() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
