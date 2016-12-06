package com.epam.mariia_lavrova.java.task8.part2.hash;

public class HashBuilderAsLength {

    private String vendorCode;

    public HashBuilderAsLength(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashBuilderAsLength that = (HashBuilderAsLength) o;

        return vendorCode != null ? vendorCode.equals(that.vendorCode) : that.vendorCode == null;
    }

    @Override
    public int hashCode() {
        return vendorCode != null ? vendorCode.length() : 0;
    }
}
