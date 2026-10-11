package com.awe.planet.manager.domain.roleMenu.convert;

import com.awe.planet.common.convert.BaseConvert;
import com.awe.planet.manager.domain.roleMenu.dto.req.RoleMenuAddReq;
import com.awe.planet.manager.domain.roleMenu.dto.req.RoleMenuReq;
import com.awe.planet.manager.domain.roleMenu.dto.req.RoleMenuUpdateReq;
import com.awe.planet.manager.domain.roleMenu.dto.resp.RoleMenuResp;
import com.awe.planet.manager.domain.roleMenu.entity.RoleMenu;
import org.mapstruct.Mapper;

/**
 * 系统角色权限转换器
 *
 * @author Awe
 * @since 2025-12-11 16:45:00
 */
@Mapper(componentModel = "spring")
public interface RoleMenuConvert extends BaseConvert<RoleMenu, RoleMenuAddReq, RoleMenuUpdateReq, RoleMenuReq, RoleMenuResp> {

}
