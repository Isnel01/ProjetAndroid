package sn.esmt.emploi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.emploi.httpconfig.Api;
import sn.esmt.emploi.httpconfig.CvResponse;
import sn.esmt.emploi.tools.CvListAdapter;

public class CvListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList <CvResponse> cvlist = new ArrayList<CvResponse>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_list);
        listView = findViewById(R.id.listview_cv);
        afficherListeDesCvs();
    }
    public void afficherListeDesCvs(){

        //Création de l'objet Retrofit pour accéder à l'API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.17:8084") //URL de base de l'API
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Crée une instance de l'interface Api,
        //qui définit les méthodes pour les appels HTTP.
        Api api = retrofit.create(Api.class);

        //creation d'un objet Call pour l'appel à la méthode login() de l'interface Api.
        Call<ArrayList<CvResponse>> call = api.all();

        call.enqueue(new Callback<ArrayList<CvResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<CvResponse>> call, Response<ArrayList<CvResponse>> response) {
                if (response.isSuccessful()) {
                    Log.d("Response :", response.body().get(0).getEmail());
                    response.body().stream().forEach(usersResponse -> cvlist.add(usersResponse));
                    CvListAdapter adpt = new CvListAdapter(CvListActivity.this,cvlist);
                    Log.d("Debbugage : " , cvlist.get(0).getPrenom());
                    listView.setAdapter(adpt);
                } else {
                    Log.d("error message exception", response.toString());

                }
            }

            @Override
            public void onFailure(Call<ArrayList<CvResponse>> call, Throwable t) {
                Log.d("Error : ", t.getMessage());
                //D/Error :: CLEARTEXT communication to 192.168.90.167 not permitted by network security policy
            }

        });


    }

}
