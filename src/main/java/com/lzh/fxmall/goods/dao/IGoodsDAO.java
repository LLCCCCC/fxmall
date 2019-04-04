package com.lzh.fxmall.goods.dao;

import com.lzh.fxmall.goods.bean.WxbGood;

import java.io.IOException;
import java.util.List;

public interface IGoodsDAO {

    List<WxbGood> selectGoods(Integer page) throws IOException;
}
