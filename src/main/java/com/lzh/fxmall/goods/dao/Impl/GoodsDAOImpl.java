package com.lzh.fxmall.goods.dao.Impl;

import com.lzh.fxmall.commons.info.SystemConstantsUtils;
import com.lzh.fxmall.commons.mybatis.MybatisSessionFactoryUtils;
import com.lzh.fxmall.goods.bean.WxbGood;
import com.lzh.fxmall.goods.dao.IGoodsDAO;
import com.lzh.fxmall.goods.mapper.GoodsMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;


public class GoodsDAOImpl implements IGoodsDAO {

    @Override
    public List<WxbGood> selectGoods(Integer page) throws IOException {

        SqlSession sqlSession = MybatisSessionFactoryUtils.getSqlSessionFactory().openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        List<WxbGood> goods = mapper.selectGoods(page, SystemConstantsUtils.Page.PAGE_SIZE);
        return goods;
    }
}
