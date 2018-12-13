package com.chen.baida.service.impl;


import com.chen.baida.form.AddShopForm;
import com.chen.baida.form.UpdateShopForm;
import com.chen.baida.mapper.ShopMapper;
import com.chen.baida.model.Shop;
import com.chen.baida.service.ShopService;
import com.chen.baida.session.SharedUser;
import com.chen.baida.vo.MessageVo;
import com.chen.baida.vo.SearchShopParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ShiQing_Chen
 * @date 2018/11/26 16:41
 */

@Service
public class ShopServiceImpl implements ShopService {
    private static final Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);

    private final ShopMapper shopMapper;

    @Autowired
    public ShopServiceImpl(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }


    @Override
    public List<Shop> searchShop(SearchShopParam params) {
        return shopMapper.searchShop(params);
    }

    @Override
    public Long countShop(SearchShopParam params) {
        return shopMapper.countShop(params);
    }

    @Override
    public MessageVo deleteShop(String shopId) {
        int count = shopMapper.deleteShop(shopId);
        return new MessageVo(count==1);
    }

    @Override
    public MessageVo addShop(SharedUser curUser, AddShopForm shopForm) {
        Shop shop = new Shop();
        BeanUtils.copyProperties(shopForm,shop);
        shop.setId(UUID.randomUUID().toString());
        shop.setCreateTime(new Date());
        shop.setCreatorId(curUser.getId());
        shop.setIsDeleted(false);

        int count = shopMapper.addShop(shop);
        return new MessageVo(count == 1);
    }

    @Override
    public MessageVo updateShop(SharedUser curUser, UpdateShopForm shopForm) {
        Shop shop = shopMapper.getById(shopForm.getId());
        BeanUtils.copyProperties(shopForm,shop,"id","createTime","creatorId","deleted");

        int count = shopMapper.updateShop(shop);
        return new MessageVo(count == 1);
    }

    @Override
    public UpdateShopForm getShopById(String shopId) {
        return shopMapper.getUpdateFormById(shopId);
    }
}
