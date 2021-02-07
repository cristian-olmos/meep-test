package com.meep.test.infrastructure.task;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.meep.test.application.VehiclesService;
import com.meep.test.domain.LocationFilter;
import com.meep.test.domain.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	private VehiclesService vehiclesService;

	private LocationRepository locationRepository;

	public ScheduledTask(VehiclesService vehiclesService, LocationRepository locationRepository){
		this.vehiclesService = vehiclesService;
		this.locationRepository = locationRepository;
	}

	@Scheduled(fixedRate = 30 * 100)
	public void reportCurrentTime() {
		log.info("Executing scheduled service...");

		List<LocationFilter> queries = locationRepository.getLocations();

		ExecutorService executor = Executors.newFixedThreadPool(queries.size());
		for (LocationFilter locationFilter : queries) {
			executor.execute(() -> vehiclesService.updateVehicles(locationFilter));
		}

	}
}