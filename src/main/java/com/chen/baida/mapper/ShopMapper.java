package com.chen.baida.mapper;

import com.chen.baida.form.UpdateShopForm;
import com.chen.baida.model.Shop;
import com.chen.baida.vo.SearchShopParam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @Description //TODO
 * @date 2018/12/6 22:35
 */
@Mapper
@Repository
public interface ShopMapper {

    @SelectProvider(type = ShopProvider.class, method = "searchShop")
    List<Shop> searchShop(SearchShopParam params);

    @SelectProvider(type = ShopProvider.class, method = "countShop")
    Long countShop(SearchShopParam params);

    @Update(" update baida t set t.is_deleted = true where t.id = #{shopId}")
    int deleteShop(String shopId);

    @Insert(" insert into shop(id, shop_name, shop_address, shop_path, shop_status, shop_desc, shop_phone, " +
            "start_fee, start_time, end_time, shop_activity, shop_heat, longitude, latitude, " +
            "creator_id, is_deleted, create_time, update_time) values" +
            " (#{id}, #{shop_name}, #{shop_address}, #{shop_path}, #{shop_status}, #{shop_desc}," +
            " (#{shop_phone}, #{start_fee}, #{start_time}, #{end_time}, #{shop_activity}, #{shop_heat}," +
            " (#{longitude}, #{latitude}, #{creator_id}, false, #{create_time}, #{update_time})")
    int addShop(Shop shop);

    @Select(" select * from shop s where s.id = #{shopId}")
    Shop getById(String shopId);

    @Select(" select s.* from shop s where s.id = #{shopId}")
    UpdateShopForm getUpdateFormById(String shopId);

    @Update(" update shop s " +
            " set t.act_name = #{actName}, " +
            " t.start_time = #{startTime}, " +
            " t.end_time = #{endTime}, " +
            " t.location = #{location}, " +
            " t.organizer = #{organizer}, " +
            " t.co_organizer = #{coOrganizer}, " +
            " t.leader_organizer = #{leaderOrganizer} " +
            " where t.id = #{id}")
    int updateShop(Shop shop);
}
