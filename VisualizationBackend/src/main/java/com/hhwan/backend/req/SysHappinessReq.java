package com.hhwan.backend.req;

public class SysHappinessReq {
    private String country;
    private String label;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "SysHappinessReq{" +
                "country='" + country + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
