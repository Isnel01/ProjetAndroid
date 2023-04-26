package sn.esmt.emploi.httpconfig;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/cvs/all")
    public Call<ArrayList<CvResponse>> all();
}
