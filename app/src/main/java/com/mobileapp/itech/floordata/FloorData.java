package com.mobileapp.itech.floordata;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;


/**
 * Created by Pavithra on 07-10-2017.
 */

public class FloorData extends GenericJson {

    @Key("_id")
    private String id;
    @Key("name")
    private String name;
    @Key("position")
    private Position position;
    @Key("_acl")
    private Acl acl;
    @Key("_kmd")
    private Kmd kmd;

    public FloorData() {
    }

    public FloorData(String id, String name, Position position, Acl acl, Kmd kmd) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.acl = acl;
        this.kmd = kmd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Acl getAcl() {
        return acl;
    }

    public void setAcl(Acl acl) {
        this.acl = acl;
    }

    public Kmd getKmd() {
        return kmd;
    }

    public void setKmd(Kmd kmd) {
        this.kmd = kmd;
    }
}
