package com.edwardsolution.pokedex.Classes.Models;
import java.util.List;

public class Pokedex {
    protected long count;
    protected List<Region> result;

    public Pokedex() {
    }

    public Pokedex(long count, List<Region> result) {
        this.count = count;
        this.result = result;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<Region> getResult() {
        return result;
    }

    public void setResult(List<Region> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Pokedex{" +
                "count=" + count +
                ", result=" + result +
                '}';
    }
}
