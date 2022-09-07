package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviceDetailsModel {

    private String platformName;
    private String platformVersion;
    private String deviceName;
    private String udid;
}
