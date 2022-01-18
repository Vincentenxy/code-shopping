<!--
 * @Author: your name
 * @Date: 2022-01-13 00:21:56
 * @LastEditTime: 2022-01-19 00:55:45
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \admin\src\views\user\Register.vue
-->
<template>
  <div class="sty_main_div">
  <h1>注册</h1>
  <el-form
    ref="registFormRef"
    :model="registForm"
    :rules="formRules"
    label-width="120px"
    class="sty_form"
  >
    <el-form-item label="用户名" prop="username">
      <el-input v-model="registForm.username" class="sty_input"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input type="password" v-model="registForm.password" class="sty_input"></el-input>
    </el-form-item>
    <el-form-item label="手机号" prop="phone">
      <el-input v-model="registForm.phone" class="sty_input"></el-input>
    </el-form-item>
    <el-form-item label="角色" prop="roleId">
    <el-select v-model="registForm.roleId" class="sty_input" placeholder="普通用户">
        <el-option label="店主" value="011"></el-option>
        <el-option label="管理员" value="012"></el-option>
        <el-option label="普通用户" value="012"></el-option>
      </el-select>
    </el-form-item>
  </el-form>
  <el-row :gutter="20">
    <el-col :span="7"></el-col>
    <el-col :span="6">
      <el-button type="primary" @click="registUser()" style="margin-bottom: 20px;">注册</el-button>
    </el-col>
    <el-col :span="6">
      <span><router-link to="/login">去登录</router-link></span>
    </el-col>
</el-row>

  </div>

</template>
<script setup lang="ts">
  import { reactive, ref } from "@vue/reactivity";
  import { PostRequest } from "../../utils/reqdata/requestindex";
  import { ElForm, ElMessage } from "element-plus";
  import Router from "../../router/index"
  import md5 from "js-md5"
  
  const formRules = reactive({
    username: [
      {
        required: true,
        message: '请输入用户名',
        trigger: 'blur',
      },
      {
        min: 4,
        max: 16,
        message: '用户名长度在4-16之间',
        trigger: 'blur',
      },
      {
        pattern: /^[^\s]+$/,
        message: '请输入正确的用户名'
      }
    ],
    password: [
      {
        required: true,
        message: '请输入密码',
        trigger: 'blur',
      },
      {
        min: 8,
        max: 16,
        message: '密码长度须在8-16位之间',
        trigger: 'blur',
      },
      {
        pattern: /^[^\s]+$/,
        message: '请输入正确的用户名'
      }
    ],
    phone: [
      {
        required: true,
        message: '请输入手机号',
        trigger: 'blur',
      },
      {
        min: 11,
        max: 11,
        message: '手机号需为11位',
        trigger: 'blur',
      },
      {
        pattern:/^(13[0-9]|14[579]|15(0-3,6-9)|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/,
        message: "请输入正确的手机号码"
      }
    ],
    roleId: [
      {
        required: true,
        message: '请选择角色',
        trigger: 'blur',
      },
    ]
  }); 

  let registForm = reactive({
    username: '',
    password: '', 
    phone: '', 
    imgId: '',
    roleId: ''
  }); 
  const registFormRef = ref(); 


  /* 用户注册页面 */
  function registUser(){
    console.log("===>用户点击了注册")
    registFormRef.value.validate((valid: boolean)=>{
      if(!valid) return;
      const params = {
        username: registForm.username,
        password: md5(registForm.password), 
        userPhone: registForm.phone,
        imgId: registForm.imgId, 
        fkRoleId: registForm.roleId
      }; 
      console.log("注册请求发送数据", )
      PostRequest('03001002', params, 'pub').then(resp=>{
        console.log("用户注册返回数据==>" + JSON.stringify(resp)); 
        let respBody = resp.respBody; 
        if(respBody.registResult === "1"){
          ElMessage.success(respBody.registMsg);
        }else {
          ElMessage.error(respBody.registMsg);
        }
      }); 
    });

  }


</script>

<style scoped>
.sty_main_div{
  margin: auto;
  width: 400px;
  /* background-color: rgb(204, 231, 199); */
  border-radius: 10px; 
  border: solid 1px black;
}
.sty_form{
  width: auto;
  margin: auto;
}
.sty_input{
  width: 220px;
}

a {
  /* text-decoration: none; */
  color: rgb(52, 140, 241);
}
</style>