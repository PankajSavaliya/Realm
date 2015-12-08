package com.socialinfotech.realm.list;

import io.realm.RealmObject;

/**
 * Created by darshit on 12/8/15.
 */
public class ListData extends RealmObject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
