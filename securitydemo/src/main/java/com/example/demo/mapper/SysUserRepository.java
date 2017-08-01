package com.example.demo.mapper;

import com.example.demo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lenovo on 2017/8/1.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}
