package com.mobileapp.itech.floordata;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/**
 * Created by Pavithra on 07-10-2017.
 */

public class Position extends GenericJson {

    @Key("x")
    private Float x;
    @Key("y")
    private Float y;
    @Key("width")
    private Float width;
    @Key("height")
    private Float height;

    public Position() {
    }

    public Position(Float x, Float y, Float width, Float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }
}
