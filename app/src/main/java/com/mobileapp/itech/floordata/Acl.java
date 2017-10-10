package com.mobileapp.itech.floordata;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/**
 * Created by Pavithra on 07-10-2017.
 */

public class Acl extends GenericJson {

    @Key("creator")
    private String creator;

    public Acl() {
    }

    public Acl(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
