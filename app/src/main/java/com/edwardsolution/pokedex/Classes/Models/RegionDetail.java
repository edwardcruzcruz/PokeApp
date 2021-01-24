package com.edwardsolution.pokedex.Classes.Models;

import android.os.Parcel;

import java.util.List;

public class RegionDetail {
    protected List<Descripcion> descriptions;
    protected long id;
    protected boolean is_main_series;
    protected String name;
    protected List<RegionLenguaje> names;
    protected List<PokemonEntry> pokemon_entries;
    protected Region region;
    protected List<PokemonVersionGroup> version_groups;


    public RegionDetail() {
    }

    public RegionDetail(long id, String name, boolean is_main_series, List<PokemonEntry> pokemon_entries, List<Descripcion> descriptions, List<PokemonVersionGroup> version_groups, List<RegionLenguaje> names, Region region) {
        this.id = id;
        this.name = name;
        this.is_main_series = is_main_series;
        this.pokemon_entries = pokemon_entries;
        this.descriptions = descriptions;
        this.version_groups = version_groups;
        this.names = names;
        this.region = region;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_main_series() {
        return is_main_series;
    }

    public void setIs_main_series(boolean is_main_series) {
        this.is_main_series = is_main_series;
    }

    public List<PokemonEntry> getPokemon_entries() {
        return pokemon_entries;
    }

    public void setPokemon_entries(List<PokemonEntry> pokemon_entries) {
        this.pokemon_entries = pokemon_entries;
    }

    public List<Descripcion> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Descripcion> descriptions) {
        this.descriptions = descriptions;
    }

    public List<PokemonVersionGroup> getVersion_groups() {
        return version_groups;
    }

    public void setVersion_groups(List<PokemonVersionGroup> version_groups) {
        this.version_groups = version_groups;
    }

    public List<RegionLenguaje> getNames() {
        return names;
    }

    public void setNames(List<RegionLenguaje> names) {
        this.names = names;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "RegionDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", is_main_series=" + is_main_series +
                ", pokemon_entries=" + pokemon_entries +
                ", descriptions=" + descriptions +
                ", version_groups=" + version_groups +
                ", names=" + names +
                ", region=" + region +
                '}';
    }
}
