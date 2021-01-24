package com.edwardsolution.pokedex.Classes.Models;

public class Descripcion {
    protected String description;
    protected Lenguaje language;

    public Descripcion() {
    }

    public Descripcion(String description, Lenguaje language) {
        this.description = description;
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Lenguaje getLanguage() {
        return language;
    }

    public void setLanguage(Lenguaje language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Descripcion{" +
                "description='" + description + '\'' +
                ", language=" + language +
                '}';
    }
}
