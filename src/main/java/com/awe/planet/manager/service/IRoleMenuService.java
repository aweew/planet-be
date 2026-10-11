package com.awe.planet.manager.service;

import com.awe.planet.manager.domain.roleMenu.dto.req.RoleMenuAddReq;
import com.awe.planet.manager.domain.roleMenu.entity.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 系统角色权限服务接口
 *
 * @author Awe
 * @since 2025-12-11 16:45:00
 */
public interface IRoleMenuService extends IService<RoleMenu> {

    /**
     * 校验并新增角色权限关联
     *
     * @param req 角色权限关联请求
     */
    void assign(RoleMenuAddReq req);

}
