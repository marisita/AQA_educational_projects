package com.epam.mariia_lavrova.java.task8.part2.hash;

public class HashBuilderAsSum {

    private String vendorCode;

    public HashBuilderAsSum(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    private int getFirstTreeElementsSum() {

        int elementsSum = 0;

        for (int i = 0; i < 3; i++) {
            elementsSum += Integer.parseInt(vendorCode.substring(i, i + 1));
        }

        return elementsSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashBuilderAsSum that = (HashBuilderAsSum) o;

        return vendorCode != null ? that.hashCode() == this.hashCode() : that.vendorCode == null;
    }

    @Override
    public int hashCode() {

        int prime = 31;
        int random = 100000 + (int) (Math.random() * ((999999 - 100000) + 1));

        int hashCode = getFirstTreeElementsSum() * prime + random;

        return vendorCode != null ? hashCode : 0;
    }
}
