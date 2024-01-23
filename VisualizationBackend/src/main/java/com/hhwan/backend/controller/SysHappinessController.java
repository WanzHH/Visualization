package com.hhwan.backend.controller;

import com.hhwan.backend.req.SysHappinessReq;
import com.hhwan.backend.req.SysUserRegistReq;
import com.hhwan.backend.resp.commonResp;
import com.hhwan.backend.resp.listResp;
import com.hhwan.backend.service.SysHappinessService;
import com.hhwan.backend.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/info")
public class SysHappinessController {

    @Autowired
    private SysHappinessService sysHappinessService;
    @PostMapping("happiness")
    public commonResp happinessData(@RequestBody SysHappinessReq req){
        System.out.println(req);
        commonResp resp = new commonResp<List<Map<String, Object>>>();
        listResp listResp = sysHappinessService.happinessData(req);
        resp.setContent(listResp.getInformation());
        System.out.println(resp);
        return resp;

    }
}
