package com.guishengran.web;

import com.guishengran.bean.UserEntity;
import com.guishengran.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: guish
 * @Date: 2018/12/26 07:56
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 用户业务逻辑
     */
    @Autowired
    private UserService userService;
    /**
     * 保存用户基本信息
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/save")
    public UserEntity save(UserEntity userEntity) throws Exception {
        userService.save(userEntity);
        return userEntity;
    }
}
