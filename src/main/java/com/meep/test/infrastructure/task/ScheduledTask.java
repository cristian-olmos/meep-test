package com.meep.test.infrastructure.task;

import java.text.SimpleDateFormat;

import com.meep.test.application.VehiclesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	private VehiclesService vehiclesService;

	public ScheduledTask(VehiclesService vehiclesService){
		this.vehiclesService = vehiclesService;
	}

	@Scheduled(fixedRate = 30 * 1000)
	public void reportCurrentTime() {
		log.info("Executing scheduled service...");
		vehiclesService.updateVehicles();
	}
}