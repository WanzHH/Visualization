package com.hhwan.backend.resp;

import java.util.List;
import java.util.Map;

public class listResp {
    private List<Map<String, Object>> information;

    public List<Map<String, Object>> getInformation() {
        return information;
    }

    public void setInformation(List<Map<String, Object>> information) {
        this.information = information;
    }
}
