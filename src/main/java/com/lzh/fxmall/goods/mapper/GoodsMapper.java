package com.lzh.fxmall.goods.mapper;

import com.lzh.fxmall.goods.bean.WxbGood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    List<WxbGood> selectGoods(@Param("index") Integer index, @Param("size") Integer size);
}
