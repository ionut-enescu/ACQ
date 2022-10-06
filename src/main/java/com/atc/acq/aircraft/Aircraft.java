package com.atc.acq.aircraft;

import java.time.LocalDateTime;

public class Aircraft {
    public AcType acType;
    public AcSize acSize;

    public LocalDateTime enquedAt;

    public Aircraft(AcType acType, AcSize acSize, LocalDateTime enquedAt) {
        this.acType = acType;
        this.acSize = acSize;
        this.enquedAt = enquedAt;
    }

    public AcSize getAcSize() {
        return acSize;
    }

    public AcType getAcType() {
        return acType;
    }

    public LocalDateTime getEnquedAt() {
        return enquedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return acType == aircraft.acType && acSize == aircraft.acSize;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((acSize == null) ? 0 : acSize.hashCode());
        result = prime * result + ((acType == null) ? 0 : acType.hashCode());
        return result;
    }
}
