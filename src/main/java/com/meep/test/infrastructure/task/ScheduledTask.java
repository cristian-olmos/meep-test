package com.meep.test.infrastructure.task;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.meep.test.application.VehiclesService;
import com.meep.test.domain.Filter;
import com.meep.test.domain.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.management.openmbean.CompositeData;

@Component
public class ScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    private VehiclesService vehiclesService;
    private FilterRepository filterRepository;

    public ScheduledTask(VehiclesService vehiclesService, FilterRepository filterRepository) {
        this.vehiclesService = vehiclesService;
        this.filterRepository = filterRepository;
    }

    @Scheduled(fixedRate = 30 * 1000)
    public void detectVehiclesChange() {
        log.info("Executing scheduled vehicles changes service...");

        List<Filter> filters = filterRepository.getAll();
        ExecutorService executor = Executors.newFixedThreadPool(filters.size());
        for (Filter filter : filters) {
            executor.execute(() -> vehiclesService.updateVehicles(filter));
        }
    }
}