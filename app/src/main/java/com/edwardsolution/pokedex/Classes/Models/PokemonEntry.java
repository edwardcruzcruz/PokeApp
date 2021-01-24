package com.edwardsolution.pokedex.Classes.Models;

import java.util.List;

public class PokemonEntry {
    protected long entry_number;
    protected PokemonSpecies pokemon_species;

    public PokemonEntry() {
    }

    public PokemonEntry(long entry_number, PokemonSpecies pokemon_species) {
        this.entry_number = entry_number;
        this.pokemon_species = pokemon_species;
    }

    public long getEntry_number() {
        return entry_number;
    }

    public void setEntry_number(long entry_number) {
        this.entry_number = entry_number;
    }

    public PokemonSpecies getPokemon_species() {
        return pokemon_species;
    }

    public void setPokemon_species(PokemonSpecies pokemon_species) {
        this.pokemon_species = pokemon_species;
    }

    @Override
    public String toString() {
        return "PokemonEntry{" +
                "entry_number=" + entry_number +
                ", pokemon_species=" + pokemon_species +
                '}';
    }
}
