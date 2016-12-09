package com.epam.mariia_lavrova.java.task8.part2.hash;

public class HashBuilderAsLength {

    private String vendorCode;

    public HashBuilderAsLength(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public int getVendorCodeLength() {
        return vendorCode.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashBuilderAsLength that = (HashBuilderAsLength) o;

        return vendorCode != null ? that.hashCode() == this.hashCode() : that.vendorCode == null;
    }

    @Override
    public int hashCode() {

        int prime = 31;
        int random = 100000 + (int) (Math.random() * ((999999 - 100000) + 1));

        int hashCode = getVendorCodeLength() * prime + random;

        return vendorCode != null ? hashCode : 0;
    }
}
