package com.lzh.fxmall;

import com.lzh.fxmall.goods.bean.WxbGood;
import com.lzh.fxmall.goods.dao.Impl.GoodsDAOImpl;

import java.util.List;

/**
 * 第一次git更改
 */
public class Test {
    public static void main(String[] args) {
        //线程1
        new Thread(new Runnable() {
            @Override
            public void run() {
                GoodsDAOImpl goodsDAO = new GoodsDAOImpl();
                try {
                    List<WxbGood> goods = goodsDAO.selectGoods(1);
                    goods.get(0).setGoodName("千锋");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                GoodsDAOImpl goodsDAO1 = new GoodsDAOImpl();
                try {
                    List<WxbGood> goods = goodsDAO1.selectGoods(1);
                    System.out.println("线程1的二次执行：" + goods.get(0).getGoodName());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //线程2
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        GoodsDAOImpl dao = new GoodsDAOImpl();
                        try {
                            List<WxbGood> wxbGoods = dao.selectGoods(1);
                            System.out.println("线程2：" + wxbGoods.get(0).getGoodName());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            }
        }).start();
    }
}
