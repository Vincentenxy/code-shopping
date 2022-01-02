/*
 * @Author: your name
 * @Date: 2022-01-02 10:50:22
 * @LastEditTime: 2022-01-02 18:21:15
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
        path: "goods-list",
        name: "GoodsList",
        component: () => import("../views/Goodslist.vue")
      },
      {
        path: "goods-info",
        name: "商品详情",
        component: () => import("../views/Goodsinfo.vue")
      }
    ]
  },
  {
    path: "/user",
    name: "用户管理",
    component: Layout,
    children: [
      {
        path: "user-list",
        name: "Userlist",
        component: () => import("../views/Userlist.vue")
      },
      {
        path: "user-setting",
        name: "Usersetting",
        component: () => import("../views/Usersetting.vue")
      }
    ]
  },
  {
    path: "/:pathMatch(.*)*",
    name: "NotFound",
    component: () => import("../views/Notfound.vue")
  }
];

const router: Router = createRouter({
  history: createWebHashHistory(),
  routes,
})

export default router;
