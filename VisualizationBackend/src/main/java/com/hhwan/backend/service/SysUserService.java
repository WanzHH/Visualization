package com.hhwan.backend.service;

import com.hhwan.backend.req.SysUserLoginReq;
import com.hhwan.backend.req.SysUserRegistReq;
import com.hhwan.backend.resp.SysUserLoginResp;

public interface SysUserService {
    void register(SysUserRegistReq req);

    SysUserLoginResp login(SysUserLoginReq req);
}
