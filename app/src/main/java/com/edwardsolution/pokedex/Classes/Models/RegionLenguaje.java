package com.edwardsolution.pokedex.Classes.Models;

public class RegionLenguaje {
    protected Lenguaje language;
    protected String name;


    public RegionLenguaje() {
    }

    public RegionLenguaje(String name, Lenguaje language) {
        this.name = name;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lenguaje getLanguage() {
        return language;
    }

    public void setLanguage(Lenguaje language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "RegionLenguaje{" +
                "name='" + name + '\'' +
                ", language=" + language +
                '}';
    }
}
