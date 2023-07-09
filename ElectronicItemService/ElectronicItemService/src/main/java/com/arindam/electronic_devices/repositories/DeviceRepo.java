package com.arindam.electronic_devices.repositories;

import com.arindam.electronic_devices.entities.ElectronicsDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepo extends JpaRepository<ElectronicsDevices,String> {
}
