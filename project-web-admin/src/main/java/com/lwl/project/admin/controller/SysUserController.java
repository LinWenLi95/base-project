package com.lwl.project.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lwl.project.admin.pojo.dto.Result;
import com.lwl.project.admin.pojo.dto.ResultCode;
import com.lwl.project.admin.pojo.dto.SysUserDTO;
import com.lwl.project.admin.pojo.entity.SysUser;
import com.lwl.project.admin.pojo.vo.SysUserVO;
import com.lwl.project.admin.service.BaseService;
import com.lwl.project.admin.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lwl
 */
@Slf4j
@Api(tags = "用户信息管理")
@RestController
@RequestMapping("/users")
public class SysUserController extends BaseController<SysUser> {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public BaseService<SysUser> getBaseService() {
        return sysUserService;
    }

    public ResponseEntity<Result<Object>> add(SysUserDTO userDTO) {
        int result = 0;
        if (userDTO != null) {
            SysUser user = new SysUser();
            BeanUtils.copyProperties(userDTO, user);
            result = sysUserService.add(user);
        }
        return result == 1 ? Result.success() : Result.success(ResultCode.UNEXPECTED_RESULTS);
    }
}
