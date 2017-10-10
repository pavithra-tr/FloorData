package com.mobileapp.itech.floordata;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/**
 * Created by Pavithra on 07-10-2017.
 */

public class Kmd extends GenericJson{

    @Key("lmt")
    private String lmt;
    @Key("ect")
    private String ect;

    public Kmd() {
    }

    public Kmd(String lmt, String ect) {
        this.lmt = lmt;
        this.ect = ect;
    }

    public String getLmt() {
        return lmt;
    }

    public void setLmt(String lmt) {
        this.lmt = lmt;
    }

    public String getEct() {
        return ect;
    }

    public void setEct(String ect) {
        this.ect = ect;
    }
}
