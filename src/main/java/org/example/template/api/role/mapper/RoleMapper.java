package org.example.template.api.role.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.template.model.Account;
import org.example.template.model.Role;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Role> selectRoleList(Role role);
    Role selectRoleById(Role role);
    int insertRole(Role role);
    int updateRole(Role role);
    int deleteRole(Role role);
}
