package com.roen.app.model;

import java.io.Serializable;

public class MarvelCharacter implements Serializable {

    static final long serialVersionUID = -1119078530687530269L;

    private Integer id;
    private String name;
    private String description;
    private String resourceURI;

    public MarvelCharacter() {
    }

    public MarvelCharacter(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }
}
