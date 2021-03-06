package and.com.eyes.eyes_android.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import and.com.eyes.eyes_android.Model.PatientVO;

import static android.content.Context.MODE_PRIVATE;

public class PatientManager {
    private static PatientManager instance;
    private PatientVO patientVO;

    public PatientManager() {

    }

    public static PatientManager getInstance() {
        if (instance == null) {
            instance = new PatientManager();
        }
        return instance;
    }

    public void savePatient(Context context, PatientVO patientVO){
        // Gson 인스턴스 생성
        Gson gson = new GsonBuilder().create();
        // JSON 으로 변환
        String strPatient = gson.toJson(patientVO, PatientVO.class);

        SharedPreferences sp = context.getSharedPreferences("shared", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("patient", strPatient); // JSON으로 변환한 객체를 저장한다.
        editor.commit(); //완료한다.
    }

    public PatientVO loadPatient(Context context) {
        SharedPreferences sp = context.getSharedPreferences("shared", MODE_PRIVATE);
        Gson gson = new GsonBuilder().create();

        String strPatient = sp.getString("patient", "");
        patientVO = gson.fromJson(strPatient, PatientVO.class);
        return patientVO;
    }

    public PatientVO getPatientVO() {
        return patientVO;
    }

    public void setPatientVO(PatientVO patientVO) {
        this.patientVO = patientVO;
    }

}
