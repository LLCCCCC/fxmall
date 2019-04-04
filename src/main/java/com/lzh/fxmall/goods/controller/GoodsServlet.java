package com.lzh.fxmall.goods.controller;

import com.lzh.fxmall.goods.bean.WxbGood;
import com.lzh.fxmall.goods.service.IGoodsService;
import com.lzh.fxmall.goods.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoodsServlet extends HttpServlet {

    private IGoodsService goodsService = new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        page = page==null?"1":page;
        List<WxbGood> goods = goodsService.selectGoodsByPage(Integer.parseInt(page));
        req.setAttribute("goods",goods);
        req.getRequestDispatcher("goodsList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
