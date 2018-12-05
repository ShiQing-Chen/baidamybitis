package com.chen.baida.mapper;

import com.chen.baida.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author HanHongmin 2018-03-23
 * @since 0.0.1
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 根据手机号查询用户
     * @param mobile 手机号码
     * @return 用户信息
     */
    @Select("select u.* " +
            "from user u " +
            "where u.mobile = #{mobile} ")
    User findByMobile(@Param("mobile") String mobile);

    @Insert("insert into user(id, name, password, role_id, mobile, create_time, last_login_time, scho_name, sub_name) values" +
            " (#{id}, #{name}, #{password}, #{roleId}, #{mobile}, #{createTime}, #{lastLoginTime}, #{schoName}, #{subName})")
    int addUser(User user);

    @Update("update user u " +
            " set u.name = #{name}," +
            " u.scho_name = #{schoName}," +
            " u.sub_name = #{subName} " +
            " where u.id = #{id}")
    int updateBasicInfo(User user);
}
