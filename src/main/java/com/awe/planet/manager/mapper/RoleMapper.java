package com.awe.planet.manager.mapper;

import com.awe.planet.manager.domain.role.dto.resp.RoleResp;
import com.awe.planet.manager.domain.role.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统角色数据库访问层
 *
 * @author Awe
 * @since 2025-12-11 16:45:00
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<RoleResp> listByUserId(@Param("userId") Long userId);

    /**
     * 查询用户角色编码
     *
     * @param userId 用户 ID
     * @return 角色编码列表
     */
    List<String> listCodesByUserId(@Param("userId") Long userId);

}
