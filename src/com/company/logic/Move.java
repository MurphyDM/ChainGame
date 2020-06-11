package com.company.logic;

import java.util.Arrays;
import java.util.Objects;

public class Move implements Comparable<Move>{
    private String name;
    private String[] beats;

    public Move() {
    }

    public Move(String name, String[] beats) {
        this.name = name;
        this.beats = beats;
    }

    public Move(Move move) {
        this.name = move.name;
        this.beats = move.beats;
    }

    public String getName() {
        return this.name;
    }

    public String[] getBeats() {
        return this.beats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBeats(String[] beats) {
        this.beats = beats;
    }

    public String toString() {
        return "Move{, name='" + this.name + '\'' + ", beats=" + Arrays.toString(this.beats) + '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Move move = (Move)o;
            return Objects.equals(this.name, move.name) && Arrays.equals(this.beats, move.beats);
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = Objects.hash(new Object[]{this.name});
        result = 31 * result + Arrays.hashCode(this.beats);
        return result;
    }

    public int compareTo(Move o) {
        String[] var2 = this.beats;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String beat = var2[var4];
            if (beat.equals(o.getName())) {
                return 1;
            }
        }

        return 0;
    }
}
