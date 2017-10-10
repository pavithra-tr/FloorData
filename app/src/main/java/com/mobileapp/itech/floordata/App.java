package com.mobileapp.itech.floordata;

import android.app.Application;
import android.util.Log;

import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyPingCallback;

import static com.kinvey.android.Client.TAG;

/**
 * Created by Pavithra on 07-10-2017.
 */

public class App extends Application {

    private Client mKinveyClient;
    @Override
    public void onCreate() {
        super.onCreate();
        mKinveyClient = new Client.Builder(this).build();
         mKinveyClient.ping(new KinveyPingCallback() {
            public void onFailure(Throwable t) {
                Log.e(TAG, "Kinvey Ping Failed", t);
            }
            public void onSuccess(Boolean b) {
                Log.d(TAG, "Kinvey Ping Success");
            }
        });


    }
    public Client getKinveyClient(){
        return mKinveyClient;
    }
}
