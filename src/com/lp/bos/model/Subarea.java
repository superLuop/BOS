package com.lp.bos.model;

/**
 * 分区
 */
public class Subarea {
    private String id;
    private String addresskey;
    private String startnum;
    private String endnum;
    private String single;
    private String position;

    private Region region;//多对一

    public void setRegion(Region region) {
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddresskey() {
        return addresskey;
    }

    public void setAddresskey(String addresskey) {
        this.addresskey = addresskey;
    }

    public String getStartnum() {
        return startnum;
    }

    public void setStartnum(String startnum) {
        this.startnum = startnum;
    }

    public String getEndnum() {
        return endnum;
    }

    public void setEndnum(String endnum) {
        this.endnum = endnum;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Subarea{" +
                "id='" + id + '\'' +
                ", addresskey='" + addresskey + '\'' +
                ", startnum='" + startnum + '\'' +
                ", endnum='" + endnum + '\'' +
                ", single='" + single + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
