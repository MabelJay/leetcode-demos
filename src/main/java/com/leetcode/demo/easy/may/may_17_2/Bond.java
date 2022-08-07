package com.leetcode.demo.easy.may.may_17_2;

import java.util.Objects;

public class Bond {

    private int id;
    private double pv;

    public Bond(int id, double pv) {
        this.id = id;
        this.pv = pv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bond bond = (Bond) o;
        return id == bond.id && Double.compare(bond.pv, pv) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pv);
    }

    @Override
    public String toString() {
        return "Bond{" +
                "id=" + id +
                ", pv=" + pv +
                '}';
    }
}
