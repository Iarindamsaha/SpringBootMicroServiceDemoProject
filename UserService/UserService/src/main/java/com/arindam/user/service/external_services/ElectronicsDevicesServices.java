package com.arindam.user.service.external_services;

import com.arindam.user.service.entity.ElectronicsDevices;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEVICE-DETAILS")
public interface ElectronicsDevicesServices {

    @GetMapping("/devices/{device_id}")
    ElectronicsDevices getDevice(@PathVariable String device_id);

}
