package com.atc.acq.demo;


import com.atc.acq.aircraft.AcSize;
import com.atc.acq.aircraft.AcType;
import com.atc.acq.aircraft.Aircraft;
import com.atc.acq.queue.AircraftQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AircraftTest {
    AircraftQueue aircraftQueue;

    @BeforeEach
    void setUp() {
        aircraftQueue = new AircraftQueue();
        aircraftQueue.boot();
    }

    @Test
    void testAircraftCtor() {
        Aircraft ac1 = new Aircraft(AcType.AC_TYPE_CARGO, AcSize.AC_SIZE_LARGE, LocalDateTime.now());
        Aircraft ac2 = new Aircraft(AcType.AC_TYPE_CARGO, AcSize.AC_SIZE_LARGE, LocalDateTime.now());
        Assertions.assertNotEquals(ac1.equals(ac2), false);

        LocalDateTime now = LocalDateTime.now();
        ac1 = new Aircraft(AcType.AC_TYPE_CARGO, AcSize.AC_SIZE_LARGE, now);
        ac2 = new Aircraft(AcType.AC_TYPE_CARGO, AcSize.AC_SIZE_LARGE, now);
        Assertions.assertEquals(ac1.equals(ac2), true);
    }

    @Test
    void testAircraftEnqueue() {
        LocalDateTime now = LocalDateTime.now();
        Aircraft ac1 = new Aircraft(AcType.AC_TYPE_CARGO, AcSize.AC_SIZE_LARGE, now);
        Aircraft ac2 = new Aircraft(AcType.AC_TYPE_CARGO, AcSize.AC_SIZE_LARGE, now);
        Assertions.assertEquals(aircraftQueue.enqueueAircraft(ac1), true);
        Assertions.assertEquals(aircraftQueue.enqueueAircraft(ac2), false);
    }

    @Test
    void testAircraftDequeue() {

        Aircraft ac1 = new Aircraft(AcType.AC_TYPE_CARGO, AcSize.AC_SIZE_SMALL, LocalDateTime.now());
        Aircraft ac2 = new Aircraft(AcType.AC_TYPE_PASSENGER, AcSize.AC_SIZE_SMALL, LocalDateTime.now());
        Aircraft ac3 = new Aircraft(AcType.AC_TYPE_CARGO, AcSize.AC_SIZE_LARGE, LocalDateTime.now());
        Aircraft ac4 = new Aircraft(AcType.AC_TYPE_PASSENGER, AcSize.AC_SIZE_LARGE, LocalDateTime.now());
        Aircraft ac5 = new Aircraft(AcType.AC_TYPE_CARGO, AcSize.AC_SIZE_LARGE, LocalDateTime.now());
        Aircraft ac6 = new Aircraft(AcType.AC_TYPE_PASSENGER, AcSize.AC_SIZE_SMALL, LocalDateTime.now());

        aircraftQueue.enqueueAircraft(ac1);
        aircraftQueue.enqueueAircraft(ac2);
        aircraftQueue.enqueueAircraft(ac3);
        aircraftQueue.enqueueAircraft(ac4);
        aircraftQueue.enqueueAircraft(ac5);
        aircraftQueue.enqueueAircraft(ac6);

        aircraftQueue.dequeueAircraft();
        aircraftQueue.dequeueAircraft();
        aircraftQueue.dequeueAircraft();

        Assertions.assertEquals(aircraftQueue.contains(ac1), true);
        Assertions.assertEquals(aircraftQueue.contains(ac2), false);
        Assertions.assertEquals(aircraftQueue.contains(ac3), true);
        Assertions.assertEquals(aircraftQueue.contains(ac4), false);
        Assertions.assertEquals(aircraftQueue.contains(ac5), true);
        Assertions.assertEquals(aircraftQueue.contains(ac6), false);

    }
}
