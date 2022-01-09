<!--
 * @Author: your name
 * @Date: 2022-01-02 10:59:49
 * @LastEditTime: 2022-01-10 00:33:24
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \test-vue\src\Layout\index.vue
-->
<template>
  <el-container>
    <el-header style="text-align: left; font-size: 12px">
      <div class="header-div">
        <img src ="../../assets/logo.png" alt="logo" />
        <span>微信商城管理端</span>
      </div>
    </el-header>
    <el-container>
    
      <el-aside :width="isCollapse ? '60px': '200px'">
        <div class="toggle-button" @click="openCollapse">|||</div>
        <el-menu
          active-text-color="#ffd04b"
          background-color="#545c64"
          class="el-menu-vertical-demo"
          default-active="2"
          text-color="#fff"
          router
          :collapse="isCollapse"
          :collapse-transition="false"
        >

        <el-sub-menu v-for="item in menus" 
          :index="item.menuId" 
          :key="item.menuId" 
        >
          <template #title>
            <span>{{item.menuName}}</span>
          </template>
          <el-menu-item
            v-for="itemc in item.childMenus"
            :index="itemc.router"
            :key="itemc.menuId"
          >
            <template #title>
              <span>{{itemc.menuName}}</span>
              <!-- <router-link to="/Goodsinfo">Goodsinfo</router-link> -->
            </template>
          </el-menu-item>
        </el-sub-menu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script lang="ts" setup>
  import {ref, onBeforeMount, onMounted, reactive } from "@vue/runtime-core";
  import { GetRequest, PostRequest } from "../../utils/reqdata/requestindex"
  import Goodsinfo from "../../views/Goodsinfo.vue"
 
  // 菜单栏接口
  interface iNavMenu {
    menuId: string, 
    menuName: string,
    menuIcon: string,
    childMenus?: Array<iNavMenu>
  }

  let imgurl: string = "C:\\Users\\vincentEnxy\\Desktop\\Temp\\imgs\\20220102\\20220102_4f024f67-5cf9-41aa-a8b5-d93512b782aa.jpg";

  // 左侧菜单栏信息 
  let menus = ref<iNavMenu[]>([]); 
  let mainRouter = ref<string>(''); // 动态路由
  
  // 菜单展开折叠控制变量
  let isCollapse = ref<boolean>(true); 
  
  /**
   * 获取管理端相关信息 
   */
  function queryAdminInfo(){
    let reqData = {
      "userId": "123123"
    };
    PostRequest("02003001", reqData).then( res=> {
      console.log("menuInfo=" + JSON.stringify(res.respBody))
      menus.value = res.respBody.menuInfo;
   }); 
  }

  /**
   * 修改菜单展开关闭属性
   */
  function openCollapse(){
    isCollapse.value = !isCollapse.value; 
  }


  onBeforeMount(()=>{
    /* 页面初始化数据获取 */ 
    queryAdminInfo();   // 获取首页相关信息
    console.log("0---->", menus)
  }); 

  onMounted(()=>{
    console.log("1---->", menus)
  }); 

</script>

<style scoped>
.el-container{
  height: 1000px;
}
.el-aside{
  background-color: #333744;
}
.el-main{
  background-color: #eaedf1;
}
.el-header{
  background-color: #373d41;
  color: #fff;
  font-size: 20px;
}
.header-div img {
  vertical-align: middle;
  height: 60px;
  width: 60px;
  margin-right: 10px;
}
.toggle-button{
  background-color: #4a5064; 
  font-size: 10px;
  line-height: 24px;
  color:#fff;
  text-align: center;
  letter-spacing: 0.2em;
  cursor: pointer;
}
</style>