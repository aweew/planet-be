package com.awe.planet.manager.domain.role.convert;

import com.awe.planet.common.convert.BaseConvert;
import com.awe.planet.manager.domain.role.dto.req.RoleAddReq;
import com.awe.planet.manager.domain.role.dto.req.RoleReq;
import com.awe.planet.manager.domain.role.dto.req.RoleUpdateReq;
import com.awe.planet.manager.domain.role.dto.resp.RoleResp;
import com.awe.planet.manager.domain.role.entity.Role;
import org.mapstruct.Mapper;

/**
 * 系统角色转换器
 *
 * @author Awe
 * @since 2025-12-11 16:45:00
 */
@Mapper(componentModel = "spring")
public interface RoleConvert extends BaseConvert<Role, RoleAddReq, RoleUpdateReq, RoleReq, RoleResp> {

}
