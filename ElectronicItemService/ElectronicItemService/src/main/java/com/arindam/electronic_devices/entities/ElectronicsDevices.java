package com.arindam.electronic_devices.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DeviceDetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElectronicsDevices {

    @Id
    private String deviceId;
    private String deviceName;
    private String description;
}
