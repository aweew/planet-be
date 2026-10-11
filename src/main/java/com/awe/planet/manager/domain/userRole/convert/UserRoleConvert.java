package com.awe.planet.manager.domain.userRole.convert;

import com.awe.planet.common.convert.BaseConvert;
import com.awe.planet.manager.domain.userRole.dto.req.UserRoleAddReq;
import com.awe.planet.manager.domain.userRole.dto.req.UserRoleReq;
import com.awe.planet.manager.domain.userRole.dto.req.UserRoleUpdateReq;
import com.awe.planet.manager.domain.userRole.dto.resp.UserRoleResp;
import com.awe.planet.manager.domain.userRole.entity.UserRole;
import org.mapstruct.Mapper;

/**
 * 系统用户角色转换器
 *
 * @author Awe
 * @since 2025-12-11 16:45:02
 */
@Mapper(componentModel = "spring")
public interface UserRoleConvert extends BaseConvert<UserRole, UserRoleAddReq, UserRoleUpdateReq, UserRoleReq, UserRoleResp> {

}
