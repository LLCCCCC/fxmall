package com.lzh.fxmall.goods.service;

import com.lzh.fxmall.goods.bean.WxbGood;

import java.io.IOException;
import java.util.List;

public interface IGoodsService {
    List<WxbGood> selectGoodsByPage(Integer page) throws IOException;
}
