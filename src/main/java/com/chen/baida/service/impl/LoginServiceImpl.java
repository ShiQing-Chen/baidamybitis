package com.chen.baida.service.impl;

import com.chen.baida.form.UserInfoForm;
import com.chen.baida.mapper.UserMapper;
import com.chen.baida.model.User;
import com.chen.baida.service.LoginService;
import com.chen.baida.session.SessionUtils;
import com.chen.baida.session.SharedUser;
import com.chen.baida.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

import static com.chen.baida.model.User.ROLE_ID_UNKNOW;

/**
 * @author HanHongmin 2018-11-12
 */
@Service
public class LoginServiceImpl implements LoginService {
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public LoginServiceImpl(UserMapper userMapper,BCryptPasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public MessageVo login(HttpServletRequest request, String mobile, String password) {
        User user = userMapper.findByMobile(mobile);
        if(user == null){
            return new MessageVo(false, "登录失败，用户名或密码不匹配");
        }

        if(!passwordEncoder.matches(password,user.getPassword())){
            return new MessageVo(false, "登录失败，用户名或密码不匹配");
        }

        if(User.ROLE_ID_ADMIN != user.getRoleId()){
            return new MessageVo(false, "登录失败，没有权限");
        }

        SharedUser sharedUser = new SharedUser();
        sharedUser.setId(user.getId());
        sharedUser.setMobile(user.getMobile());
        sharedUser.setName(user.getName());
        sharedUser.setRoleId(user.getRoleId());
        SessionUtils.setCurUser(request,sharedUser);
        return new MessageVo(true);
    }

    @Override
    public MessageVo qrLogin(HttpServletRequest request, UserInfoForm form) {
        User user = userMapper.findByMobile(form.getMobile().trim());
        Date now = new Date();
        if(user==null){
            user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setCreateTime(now);
            user.setLastLoginTime(now);
            user.setName(form.getName());
            user.setPassword(null);
            user.setRoleId(ROLE_ID_UNKNOW);
            user.setMobile(form.getMobile());
            user.setSchoName(form.getSchoName());
            user.setSubName(form.getSubName());
            int count = userMapper.addUser(user);
            if(count!=1){
                return new MessageVo(false,"保存信息失败");
            }
        }else{
            user.setLastLoginTime(now);
            user.setName(form.getName());
            user.setMobile(form.getMobile());
            user.setSchoName(form.getSchoName());
            user.setSubName(form.getSubName());
            int count = userMapper.updateBasicInfo(user);
            if(count!=1){
                return new MessageVo(false,"更新信息失败");
            }
        }

        //登录成功的逻辑，待改善，改为jjwt
        SharedUser curUser = new SharedUser();
        curUser.setId(user.getId());
        curUser.setMobile(user.getMobile());
        curUser.setName(user.getName());
        curUser.setRoleId(user.getRoleId());
        SessionUtils.setCurUser(request,curUser);

        return new MessageVo(true);
    }
}
