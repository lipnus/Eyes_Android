package and.com.eyes.eyes_android.Model;

import com.google.gson.annotations.SerializedName;

public class PatientVO {
    @SerializedName("patientId")
    String patientId;
    @SerializedName("patientName")
    String patientName;
    @SerializedName("patientInfo")
    String patientInfo;
    @SerializedName("patientImage")
    String patientImage;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(String patientInfo) {
        this.patientInfo = patientInfo;
    }

    public String getPatientImage() {
        return patientImage;
    }

    public void setPatientImage(String patientImage) {
        this.patientImage = patientImage;
    }
}
