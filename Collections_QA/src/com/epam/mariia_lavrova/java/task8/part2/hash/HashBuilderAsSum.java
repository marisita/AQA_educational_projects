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

        return vendorCode != null ? vendorCode.equals(that.vendorCode) : that.vendorCode == null;
    }

    @Override
    public int hashCode() {
        return vendorCode != null ? getFirstTreeElementsSum() : 0;
    }
}
