<!--
 * @Author: your name
 * @Date: 2022-01-02 10:59:49
 * @LastEditTime: 2022-01-03 00:36:56
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
      <el-aside width="200px">
         <el-menu
        active-text-color="#ffd04b"
        background-color="#545c64"
        class="el-menu-vertical-demo"
        default-active="2"
        text-color="#fff"
      >
      <!-- 一级菜单 -->
        <el-sub-menu index="1">
          <template #title>
            <el-icon><location /></el-icon>
            <span>商品管理</span>
          </template>
          <el-menu-item-group title="Group One">
            <el-menu-item index="1-1">添加商品</el-menu-item>
            <el-menu-item index="1-2">item one</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="Group Two">
            <el-menu-item index="1-3">item three</el-menu-item>
          </el-menu-item-group>
          <el-sub-menu index="1-4">
            <template #title>item four</template>
            <el-menu-item index="1-4-1">item one</el-menu-item>
          </el-sub-menu>
        </el-sub-menu>
        <el-menu-item index="2">
          <el-icon><icon-menu /></el-icon>
          <span>用户管理</span>
        </el-menu-item>
        <el-menu-item index="3" disabled>
          <el-icon><document /></el-icon>
          <span>菜单3</span>
        </el-menu-item>
        <el-menu-item index="4">
          <el-icon><setting /></el-icon>
          <span>菜单4</span>
        </el-menu-item>
      </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script lang="ts" setup>

let imgurl = "C:\\Users\\vincentEnxy\\Desktop\\Temp\\imgs\\20220102\\20220102_4f024f67-5cf9-41aa-a8b5-d93512b782aa.jpg";

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
</style>