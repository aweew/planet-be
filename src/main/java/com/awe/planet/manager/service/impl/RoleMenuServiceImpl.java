package com.awe.planet.manager.service.impl;

import com.awe.planet.common.constant.ErrorCodeEnum;
import com.awe.planet.common.constant.enums.StatusEnum;
import com.awe.planet.common.exception.BusinessException;
import com.awe.planet.manager.domain.menu.entity.Menu;
import com.awe.planet.manager.domain.role.entity.Role;
import com.awe.planet.manager.domain.roleMenu.dto.req.RoleMenuAddReq;
import com.awe.planet.manager.domain.roleMenu.entity.RoleMenu;
import com.awe.planet.manager.mapper.RoleMenuMapper;
import com.awe.planet.manager.service.IMenuService;
import com.awe.planet.manager.service.IRoleMenuService;
import com.awe.planet.manager.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * 系统角色权限服务实现类
 *
 * @author Awe
 * @since 2025-12-11 16:45:00
 */
@Service("roleMenuService")
@Transactional(rollbackFor = Exception.class)
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    @Resource
    private IRoleService roleService;

    @Resource
    private IMenuService menuService;

    /**
     * 校验并新增角色权限关联
     *
     * @param req 角色权限关联请求
     */
    @Override
    public void assign(RoleMenuAddReq req) {
        Role role = roleService.getById(req.getRoleId());
        Menu menu = menuService.getById(req.getMenuId());
        if (Objects.isNull(role) || Objects.isNull(menu)) {
            throw new BusinessException(ErrorCodeEnum.DATA_NOT_FOUND);
        }
        if (!StatusEnum.ENABLE.equals(role.getStatus()) || !StatusEnum.ENABLE.equals(menu.getStatus())) {
            throw new BusinessException(ErrorCodeEnum.DATA_DISABLED);
        }
        RoleMenu exists = this.baseMapper.selectAny(req.getRoleId(), req.getMenuId());
        if (Objects.nonNull(exists)) {
            if (Boolean.TRUE.equals(exists.getIsDelete())) {
                this.baseMapper.restore(exists.getId());
            }
            return;
        }
        this.save(RoleMenu.builder().roleId(req.getRoleId()).menuId(req.getMenuId()).build());
    }

}
