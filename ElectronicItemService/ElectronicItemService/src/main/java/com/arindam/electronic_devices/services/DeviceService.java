package com.arindam.electronic_devices.services;

import com.arindam.electronic_devices.Response;
import com.arindam.electronic_devices.entities.ElectronicsDevices;

public interface DeviceService {

    Response addDeviceDetails(ElectronicsDevices electronicsDevices);
    Response getAllDeviceDetails();
    ElectronicsDevices getSingleDeviceDetails(String id);

}
