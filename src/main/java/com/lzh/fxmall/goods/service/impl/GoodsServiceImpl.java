package com.lzh.fxmall.goods.service.impl;

import com.lzh.fxmall.commons.info.SystemConstantsUtils;
import com.lzh.fxmall.goods.bean.WxbGood;
import com.lzh.fxmall.goods.dao.IGoodsDAO;
import com.lzh.fxmall.goods.dao.Impl.GoodsDAOImpl;
import com.lzh.fxmall.goods.service.IGoodsService;

import java.io.IOException;
import java.util.List;

public class GoodsServiceImpl implements IGoodsService {

    private static IGoodsDAO goodsDAO = new GoodsDAOImpl();

    @Override
    public List<WxbGood> selectGoodsByPage(Integer page) throws IOException {
        if (page < 0){
            throw new IndexOutOfBoundsException("页码不能小于1");
        }
        int index = (page-1)* SystemConstantsUtils.Page.PAGE_SIZE;
        List<WxbGood> goods = goodsDAO.selectGoods(index);
        return goods;
    }
}
