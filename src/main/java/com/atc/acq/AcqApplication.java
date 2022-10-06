package com.atc.acq;

import com.atc.acq.aircraft.AcSize;
import com.atc.acq.aircraft.AcType;
import com.atc.acq.aircraft.Aircraft;
import com.atc.acq.queue.AircraftQueue;
import com.atc.acq.request.Request;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AcqApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		AircraftQueue acq = new AircraftQueue();


		while (true) {
			System.out.print("Option (BOOT/ENQUEUE/DEQUEUE): ");
			String option = scanner.nextLine();

			switch (Request.RequestType.valueOf(option)) {
				case BOOT:
					acq.boot();
					break;
				case ENQUEUE:
					System.out.print("Aircraft type: ");
					String type = scanner.nextLine();
					System.out.print("Aircraft size: ");
					String size = scanner.nextLine();
					acq.enqueueAircraft(new Aircraft(AcType.valueOf(type), AcSize.valueOf(size), LocalDateTime.now()));
					break;
				case DEQUEUE:
					acq.dequeueAircraft();
					break;
				default:
					System.out.println("Option not found, exiting....");
					System.exit(0);
			}
		}

	}

}
