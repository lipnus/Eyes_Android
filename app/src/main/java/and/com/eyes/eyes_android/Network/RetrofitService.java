package and.com.eyes.eyes_android.Network;

import java.util.List;

import and.com.eyes.eyes_android.Model.PatientVO;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @POST("/getPatient")
    @FormUrlEncoded
    Call<PatientVO> getPatient(
            @Field("userId") String userId
    );

    //File Should be sended Through MultiPart and POST
    @POST("/sendImage")
    @Multipart
    Call<ResponseBody> sendImage(
            @Part MultipartBody.Part image,
            @Part("uid") RequestBody uid,
            @Part("mirrorUid") RequestBody mirrorUid
    );

    //In Get Method Data was attached on HEAD, so use GET Method with Search Query(Topic) would be fit
    @GET("/sendCategory")
    Call<String> sendSwitchStatus(
            @Query("uid") String uid,
            @Query("category") String categoryName
    );

    //Path will allow to access {owner}
    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<PatientVO>> getUsers(
            @Path("owner") String owner,
            @Path("repo") String repo);

    //Body was used with POST to send Object
    @POST("/sendUser")
    Call<String> sendUser(
            @Body PatientVO patientVO
    );

    // Field Must be used with FormUrIEncoded which indicates that the request will have its MIME
    // type (a header field that identifies the format of the body of an HTTP request or response)
    // set to application/x-www-form-urlencoded and also that its field names and values will
    // be UTF-8 encoded before being URI-encoded.
    @POST("/sendPost")
    @FormUrlEncoded
    Call<String> sendPost(@Field("title") String title,
                          @Field("body") String body,
                          @Field("userId") String uid
    );
}
