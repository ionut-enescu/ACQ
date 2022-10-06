package com.atc.acq.aircraft;

public enum AcType {
    AC_TYPE_PASSENGER("AC_TYPE_PASSENGER"),
    AC_TYPE_CARGO("AC_TYPE_CARGO");

    AcType(String type) {
        this.type = type;
    }

    private String type;

}
