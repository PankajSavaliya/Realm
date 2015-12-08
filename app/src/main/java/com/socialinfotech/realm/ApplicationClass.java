package com.socialinfotech.realm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by darshit on 12/8/15.
 */
public class ApplicationClass extends Application {
    private static RealmConfiguration realmConfig;
    public static synchronized RealmConfiguration GetRealm(){
        return realmConfig;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        realmConfig = new RealmConfiguration.Builder(this).build();
        Realm.deleteRealm(realmConfig);
    }
}
