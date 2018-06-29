package and.com.eyes.eyes_android.Adaptor;

import android.graphics.drawable.Drawable;

public class HistoryItem {

    private Drawable icon;
    private String address;
    private String developTIme;
    private String endTIme;
    private String handover;

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

    public String getDevelopTIme() {
        return developTIme;
    }

    public void setDevelopTIme(String developTIme) {
        this.developTIme = developTIme;
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