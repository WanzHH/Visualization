package com.hhwan.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hhwan.backend.entity.SysUserEntity;
import com.hhwan.backend.mapper.SysUserMapper;
import com.hhwan.backend.req.SysUserLoginReq;
import com.hhwan.backend.req.SysUserRegistReq;
import com.hhwan.backend.resp.SysUserLoginResp;
import com.hhwan.backend.service.SysUserService;
import com.hhwan.backend.utils.CopyUtil;
import com.hhwan.backend.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Autowired
    private SnowFlake snowFlake;

    //查询loginName是否被注册
    public SysUserEntity selectByLoginName(String name){
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUserEntity::getName,name);
        List<SysUserEntity> userEntityList = sysUserMapper.selectList(wrapper);
        if(CollectionUtils.isEmpty(userEntityList)){
            return  null;
        }else {
            return userEntityList.get(0);
        }
    }

    @Override
    public void register(SysUserRegistReq req) {
        SysUserEntity user = CopyUtil.copy(req, SysUserEntity.class);
        if(ObjectUtils.isEmpty(req.getId())){
            SysUserEntity userDb = selectByLoginName(req.getName());
            if(ObjectUtils.isEmpty(userDb)){
                user.setId(snowFlake.nextId());
                sysUserMapper.insert(user);
            }
        }
    }

    public String checkPassword(String name){
        QueryWrapper<SysUserEntity> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysUserEntity::getName,name);
        List<SysUserEntity> userEntityList = sysUserMapper.selectList(wrapper);
        String password = userEntityList.get(0).getPassword();
        System.out.println(password);
        if(CollectionUtils.isEmpty(userEntityList)){
            return  null;
        }else {
            return password;
        }
    }

    @Override
    public SysUserLoginResp login(SysUserLoginReq req) {
        SysUserEntity userDb = selectByLoginName(req.getName());
        System.out.println(userDb);
        if(ObjectUtils.isEmpty(userDb)){
            //用户不存在
            return null;
        }
        if(!Objects.equals(req.getPassword(), checkPassword(req.getName()))){
            //密码错误
            return null;
        }else {
            //登陆成功
            SysUserLoginResp userLoginResp = CopyUtil.copy(userDb, SysUserLoginResp.class);
            return userLoginResp;
        }
    }
}
