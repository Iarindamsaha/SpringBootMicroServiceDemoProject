package com.arindam.electronic_devices.services;

import com.arindam.electronic_devices.Response;
import com.arindam.electronic_devices.entities.ElectronicsDevices;
import com.arindam.electronic_devices.exceptions.UserException;
import com.arindam.electronic_devices.repositories.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeviceServicesIMPL implements DeviceService{

    @Autowired
    private DeviceRepo deviceRepo;
    @Autowired
    private Response response;

    @Override
    public Response addDeviceDetails(ElectronicsDevices electronicsDevices) {

        String deviceId = UUID.randomUUID().toString();
        electronicsDevices.setDeviceId(deviceId);
        response.setMessage("Device Details Added Successfully");
        response.setObject(deviceRepo.save(electronicsDevices));
        return response;

    }

    @Override
    public Response getAllDeviceDetails() {

        response.setMessage("All Device Details Are : -");
        response.setObject(deviceRepo.findAll());
        return response;

    }

    @Override
    public ElectronicsDevices getSingleDeviceDetails(String id) {


        return deviceRepo.findById(id).orElseThrow(
                ()-> new UserException("Device Not Found", HttpStatus.INTERNAL_SERVER_ERROR));

    }
}
