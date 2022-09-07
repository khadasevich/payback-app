package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppInfoModel {

    private String appPackage;
    private String appActivity;
}
