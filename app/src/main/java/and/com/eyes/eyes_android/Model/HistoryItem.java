package and.com.eyes.eyes_android.Model;

import android.graphics.drawable.Drawable;

public class HistoryItem {

    private String startTime;
    private String endTime;
    private String address;
    private String handover;
    private float longitude;
    private float latitude;

    public HistoryItem(String address, String startTime, String endTime, String handover, float longitude, float latitude){
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
        this.handover = handover;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTIme(String endTime) {
        this.endTime = endTime;
    }

    public String getHandover() {
        return handover;
    }

    public void setHandover(String handover) {
        this.handover = handover;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}