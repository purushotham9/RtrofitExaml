package nnk.com.rtrofitexamle.Interface;

import nnk.com.rtrofitexamle.Helpers.ListEnterprise;
import nnk.com.rtrofitexamle.Model.UserAtenticationModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IService {
    @POST("users/auth/sign_in")
    Call<UserAtenticationModel> authenticate(@Body UserAtenticationModel userAutenticationModel);

    @GET("enterprises")
    Call<ListEnterprise> listEnterprises(@Header("access-token") String access_token, @Header("client") String client, @Header("uid") String uid, @Query("name") String enterprise);
}

