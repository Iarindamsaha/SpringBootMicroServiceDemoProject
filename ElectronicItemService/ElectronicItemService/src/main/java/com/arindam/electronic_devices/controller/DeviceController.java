package com.arindam.electronic_devices.controller;

import com.arindam.electronic_devices.Response;
import com.arindam.electronic_devices.entities.ElectronicsDevices;
import com.arindam.electronic_devices.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public ResponseEntity<Response> addDeviceData(@RequestBody ElectronicsDevices electronicsDevices){

        return new ResponseEntity<>(deviceService.addDeviceDetails(electronicsDevices), HttpStatus.ACCEPTED);

    }

    @GetMapping
    public ResponseEntity<Response> getAllDeviceDetails (){

        return new ResponseEntity<>(deviceService.getAllDeviceDetails(),HttpStatus.OK);

    }

    @GetMapping("/{device_id}")
    public ResponseEntity<ElectronicsDevices> getSingleDeviceDetail(@PathVariable String device_id){

        return ResponseEntity.ok(deviceService.getSingleDeviceDetails(device_id));

    }
}
