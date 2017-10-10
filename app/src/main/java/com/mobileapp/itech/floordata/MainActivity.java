package com.mobileapp.itech.floordata;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyListCallback;
import com.kinvey.android.model.User;
import com.kinvey.android.store.DataStore;
import com.kinvey.android.store.UserStore;
import com.kinvey.android.sync.KinveyPullCallback;
import com.kinvey.android.sync.KinveyPullResponse;
import com.kinvey.java.core.KinveyClientCallback;
import com.kinvey.java.store.StoreType;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "Testing";
    private Client client;
    DataStore<FloorData> dataStore;
    FloorActivity floorActivity;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(isNetworkAvailable()){
            setContentView(R.layout.activity_main);
            client = ((App) getApplication()).getKinveyClient();
            dataStore = DataStore.collection("floor", FloorData.class, StoreType.SYNC, client);
            logIn();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Loading...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.show();
            Runnable progressRunnable = new Runnable() {

                @Override
                public void run() {

                    fetchData();
                    progressDialog.cancel();
                }
            };

            Handler handler = new Handler();
            handler.postDelayed(progressRunnable, 2000);
            logOut();
        } else {
            Toast.makeText(MainActivity.this,"No Internet Connection",Toast.LENGTH_LONG).show();

        }

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void logOut() {
        UserStore.logout(client, new KinveyClientCallback<Void>() {
            @Override
            public void onFailure(Throwable throwable) {
                Log.d(TAG, "Logout error"+ throwable);
            }
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "Successfully logout!"+ aVoid);
            }
        });
    }

    private void logIn() {
        try {
            UserStore.login(client, new KinveyClientCallback<User>() {
                @Override
                public void onFailure(Throwable t) {
                    Log.d(TAG, "Failure login!"+ t);
                }

                @Override
                public void onSuccess(User u) {
                    Log.d(TAG, "Successfully login!"+u);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fetchData() {
        dataStore.pull(new KinveyPullCallback<FloorData>() {
            @Override
            public void onSuccess(KinveyPullResponse<FloorData> kinveyPullResponse) {

                Log.d(TAG, "Pull Callback: success"+kinveyPullResponse);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.d(TAG, "Pull Callback Error:"+throwable);
            }
        });

        dataStore.find(new KinveyListCallback<FloorData>() {

            @Override
            public void onSuccess(List<FloorData> list) {

                Log.d(TAG, "ListCallback:"+list);
                floorActivity = (FloorActivity) findViewById(R.id.textView);
                floorActivity = new FloorActivity(MainActivity.this,list);
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.d(TAG, "ListCallback: Error"+ throwable);
            }
        });
    }
}




