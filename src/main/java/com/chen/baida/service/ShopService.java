package com.chen.baida.service;


import com.chen.baida.form.AddShopForm;
import com.chen.baida.form.UpdateShopForm;
import com.chen.baida.model.Shop;
import com.chen.baida.session.SharedUser;
import com.chen.baida.vo.MessageVo;
import com.chen.baida.vo.SearchShopParam;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 16:41
 */


public interface ShopService {

    List<Shop> searchShop(SearchShopParam params);

    Long countShop(SearchShopParam params);

    MessageVo deleteShop(String shopId);

    MessageVo addShop(SharedUser curUser, AddShopForm shopForm);

    MessageVo updateShop(SharedUser curUser, UpdateShopForm shopForm);

    UpdateShopForm getShopById(String shopId);

}
