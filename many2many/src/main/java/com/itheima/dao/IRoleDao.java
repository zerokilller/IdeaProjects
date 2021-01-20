package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

public interface IRoleDao {
    /**
     *@Description: 查询所有角色
     *@Author:景文博
     *@Param:
     *@Return:
     */
    List<Role> findAll();

}
