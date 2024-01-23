package com.hhwan.backend.service;

import com.hhwan.backend.req.SysHappinessReq;
import com.hhwan.backend.resp.listResp;

public interface SysHappinessService {
    listResp happinessData(SysHappinessReq req);
}
