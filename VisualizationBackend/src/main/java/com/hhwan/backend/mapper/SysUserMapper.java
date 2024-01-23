package com.hhwan.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hhwan.backend.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

    @Select("SELECT * FROM happiness WHERE Country_Name = #{countryName}")
    List<Map<String, Object>> getCountryDataByCountryName(@Param("countryName") String countryName);


}
