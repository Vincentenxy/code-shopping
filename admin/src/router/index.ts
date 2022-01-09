/*
 * @Author: your name
 * @Date: 2022-01-02 10:50:22
 * @LastEditTime: 2022-01-10 00:20:08
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \test-vue\src\router\index.ts
 */

import { createRouter, createWebHashHistory, Router } from "vue-router";
import Layout from "../components/Layout/index.vue";


const routes: Array<any> = [
  {
    path: "/",
    redirect: "/main"
  },
  {
    path: "/login",
    name: "Login",
    component: () => import("../views/Login.vue"),
  },
  {
    path: "/main",
    component: Layout,
    redirect: "/home",
    children: [
      {
        path: "/home",
        name: "Home",
        component: () => import("../views/Home.vue"),
      }
    ]
  },
  {
    path: "/goods",
    name: "商品管理",
    component: Layout,
    children: [
      {
        path: "InputGoods",
        name: "商品录入",
        component: () => import("../views/goods/InputGoods.vue")
      },
      {
        path: "ModifyGoodsInfo",
        name: "修改商品信息",
        component: () => import("../views/goods/ModifyGoodsInfo.vue")
      }
    ]
  },
  {
    path: "/orders",
    name: "订单管理",
    component: Layout,
    children: [
      {
        path: "ViewOrderInfo",
        name: "订单信息查询",
        component: () => import("../views/orders/ViewORderInfo.vue")
      }
    ]
  },
  {
    path: "/:pathMatch(.*)*",
    name: "通用错误提示页面!",
    component: () => import("../views/Notfound.vue")
  }
];

const router: Router = createRouter({
  history: createWebHashHistory(),
  routes,
})

export default router;
