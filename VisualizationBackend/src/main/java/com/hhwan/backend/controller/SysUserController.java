package com.hhwan.backend.controller;
import com.hhwan.backend.req.SysUserLoginReq;
import com.hhwan.backend.req.SysUserRegistReq;
import com.hhwan.backend.resp.SysUserLoginResp;
import com.hhwan.backend.resp.commonResp;
import com.hhwan.backend.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user_table")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("register")
    public commonResp register(@RequestBody SysUserRegistReq req){
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        commonResp resp = new commonResp<>();
        sysUserService.register(req);
        return resp;

    }

    @PostMapping("login")
    public commonResp login(@RequestBody SysUserLoginReq req) {
        req.setPassword(DigestUtils.md5DigestAsHex(req.getPassword().getBytes()));
        commonResp resp = new commonResp<>();
        SysUserLoginResp loginResp = sysUserService.login(req);
        if (loginResp == null) {
            resp.setSuccess(false);
            return resp;
        } else {
            resp.setContent(loginResp);
            return resp;
        }
    }

}
