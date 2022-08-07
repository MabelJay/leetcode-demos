package com.leetcode.demo.easy.may.may_17;

import java.util.Objects;

public class Bond {

    int bondId;
    double pv;

    public Bond(int id, double pv) {
        this.bondId = id;
        this.pv = pv;
    }

    public double getPv() {
        return pv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bond bond = (Bond) o;
        return bondId == bond.bondId && Double.compare(bond.pv, pv) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bondId, pv);
    }

    @Override
    public String toString() {
        return "Bond{" +
                "bondId=" + bondId +
                ", pv=" + pv +
                '}';
    }
}
