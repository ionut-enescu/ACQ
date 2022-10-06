package com.atc.acq.aircraft;

public enum AcSize {
    AC_SIZE_SMALL("AC_SIZE_SMALL"),
    AC_SIZE_LARGE("AC_TYPE_LARGE");

    AcSize(String size) {
        this.size = size;
    }

    private String size;

}
