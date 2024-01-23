package com.hhwan.backend.service.impl;

import com.hhwan.backend.mapper.SysUserMapper;
import com.hhwan.backend.req.SysHappinessReq;
import com.hhwan.backend.resp.listResp;
import com.hhwan.backend.service.SysHappinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SysHappinessImpl implements SysHappinessService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public listResp happinessData(SysHappinessReq req){
        listResp resp = new listResp();
        List<Map<String, Object>> result = sysUserMapper.getCountryDataByCountryName(req.getCountry());
        resp.setInformation(result);
        System.out.println(result);
        return resp;
    }

}
