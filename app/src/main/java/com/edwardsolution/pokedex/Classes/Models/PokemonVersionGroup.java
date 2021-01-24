package com.edwardsolution.pokedex.Classes.Models;

public class PokemonVersionGroup {
    protected String name;
    protected String url;

    public PokemonVersionGroup() {
    }

    public PokemonVersionGroup(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PokemonVersionGroup{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
