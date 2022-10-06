package com.atc.acq.queue;

import com.atc.acq.aircraft.AcSize;
import com.atc.acq.aircraft.AcType;
import com.atc.acq.aircraft.Aircraft;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class AircraftQueue {
    private LinkedList<Aircraft> aircraftPriorityQueue;

    public void boot() {
        this.aircraftPriorityQueue = new LinkedList<>();
    }

    public boolean enqueueAircraft(Aircraft ac) {
        if (aircraftPriorityQueue.stream().anyMatch(x -> x.getEnquedAt() == ac.enquedAt)) {
            System.out.println("Duplicate Aircraft enqueueing TimeStamp, rejecting...");
            return false;
        }
        return aircraftPriorityQueue.add(ac);
    }

    public void dequeueAircraft() {
        Comparator<Aircraft> tsComparator = Comparator.comparing(Aircraft::getEnquedAt);
        Collections.sort(aircraftPriorityQueue,
                new TypeComparator().thenComparing(new SizeComparator()).thenComparing(tsComparator));

        aircraftPriorityQueue.removeLast();
    }

    public boolean contains(Aircraft ac) {
        return aircraftPriorityQueue.contains(ac);
    }

    private class TypeComparator implements Comparator<Aircraft> {

        @Override
        public int compare(Aircraft o1, Aircraft o2) {
            if (o1.acType == AcType.AC_TYPE_PASSENGER && o2.acType == AcType.AC_TYPE_CARGO) {
                return 1;
            } else if (o1.acType == AcType.AC_TYPE_CARGO && o2.acType == AcType.AC_TYPE_PASSENGER) {
                return -1;
            }
            return 0;
        }
    }

    private class SizeComparator implements Comparator<Aircraft> {

        @Override
        public int compare(Aircraft o1, Aircraft o2) {
            if (o1.acSize == AcSize.AC_SIZE_LARGE && o2.acSize == AcSize.AC_SIZE_SMALL) {
                return 1;
            } else if (o1.acSize == AcSize.AC_SIZE_SMALL && o2.acSize == AcSize.AC_SIZE_LARGE) {
                return -1;
            }
            return 0;
        }
    }

}
