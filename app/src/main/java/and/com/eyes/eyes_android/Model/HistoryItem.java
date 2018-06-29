package and.com.eyes.eyes_android.Model;

import android.graphics.drawable.Drawable;

public class HistoryItem {

    private Drawable icon;
    private String startTime;
    private String endTIme;
    private String address;
    private String handover;

    public HistoryItem(String address, String startTime, String endTime, String handover){
        this.address = address;
        this.startTime = startTime;
        this.endTIme = endTime;
        this.handover = handover;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
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

    public String getEndTIme() {
        return endTIme;
    }

    public void setEndTIme(String endTIme) {
        this.endTIme = endTIme;
    }

    public String getHandover() {
        return handover;
    }

    public void setHandover(String handover) {
        this.handover = handover;
    }
}