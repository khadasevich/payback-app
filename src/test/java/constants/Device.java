package constants;

import lombok.Getter;

public enum Device {

    ANDROID("Android"),
    IOS("iOS");

    @Getter
    private String title;

    Device(String title) {
        this.title = title;
    }
}
