package com.chen.baida.service.impl;


import com.chen.baida.model.User;
import com.chen.baida.service.LoginService;
import com.chen.baida.session.SessionUtils;
import com.chen.baida.session.SharedUser;
import com.chen.baida.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


/**
 * @author HanHongmin 2018-11-12
 */
@Service
public class LoginServiceImpl implements LoginService {
//    private final UserMapper userMapper;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    public LoginServiceImpl(UserMapper userMapper, BCryptPasswordEncoder passwordEncoder) {
//        this.userMapper = userMapper;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public MessageVo login(HttpServletRequest request, String mobile, String password) {
//        User user = userMapper.findByMobile(mobile);
//        if(user == null){
//            return new MessageVo(false, "登录失败，用户名或密码不匹配");
//        }
//
//        if(!passwordEncoder.matches(password,user.getPassword())){
//            return new MessageVo(false, "登录失败，用户名或密码不匹配");
//        }
//
//        if(User.ROLE_ID_ADMIN != user.getRoleId()){
//            return new MessageVo(false, "登录失败，没有权限");
//        }
//
        SharedUser sharedUser = new SharedUser();
        sharedUser.setId("2222");
        sharedUser.setMobile("12121212");
        sharedUser.setName("cc");
        sharedUser.setRoleId(1);
        SessionUtils.setCurUser(request,sharedUser);
        return new MessageVo(true);
    }
}
