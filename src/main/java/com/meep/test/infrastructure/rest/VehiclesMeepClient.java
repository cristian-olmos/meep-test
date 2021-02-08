package com.meep.test.infrastructure.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "resources", url = "https://apidev.meep.me")
public interface VehiclesMeepClient {

    @RequestMapping(method = RequestMethod.GET, value = "/tripplan/api/v1/routers/{zone}/resources?lowerLeftLatLon={lowerLat},{leftLon}&upperRightLatLon={upperLat},{rightLon}&companyZoneIds={companyZoneIds}")
    List<VehicleDto> getVehicles(
            @RequestParam(value = "zone") String zone,
            @RequestParam(value = "lowerLat") Double lowerLat,
            @RequestParam(value = "leftLon") Double leftLon,
            @RequestParam(value = "upperLat") Double upperLat,
            @RequestParam(value = "rightLon") Double rightLon,
            @RequestParam(value = "companyZoneIds") List<Integer> companyZoneIds);

}