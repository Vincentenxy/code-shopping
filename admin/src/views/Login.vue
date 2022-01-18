<template>
  <div class="login_box">
    <div class="header-div">
      <img src ="../assets/logo.png" alt="logo" />
    </div>
    <el-form
      ref="loginFormRef"
      class="login_form"
      :model="ruleForm"
      :rules="loginRules"
    >
      <el-form-item lable="用户名" prop="name" >
        <el-input v-model="ruleForm.name" prefix-icon="user" style="width: 300px;"></el-input>
      </el-form-item>
      <el-form-item lable="密码" prop="passwd">
        <el-input type="password" v-model="ruleForm.passwd" prefix-icon="lock" style="width: 300px;"></el-input>
      </el-form-item>
    </el-form>
    <el-button type="primary" @click="submitForm()">登录</el-button>
    <el-button type="info" @click="resetLoginForm">重置</el-button>
    <br/><br/>
    <span>没有账号？现在 <router-link to="/regist">注册</router-link></span>
  </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from "@vue/reactivity";
import { PostRequest } from "./../utils/reqdata/requestindex";
import { ElForm, ElMessage } from "element-plus";
import Userlist from "./Userlist.vue";
  import Router from "../router/index"
import md5 from "js-md5"

const ruleForm = reactive({
  name: '',
  passwd: ''
});

// 校验规则
const loginRules = reactive({
  name: [
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
  ],
  passwd: [
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
  ]
}); 

// 
const loginFormRef = ref(); 

/* 提交form表单 */
function submitForm(){
  const login = () =>{
    loginFormRef.value.validate((valid: boolean)=>{
      if(!valid) return;
      const params = {
        username: ruleForm.name,
        password: md5(ruleForm.passwd)
      };
      PostRequest('03001001', params, 'pub').then((resp)=>{
        let respBody = resp.respBody; 
        if("1" === respBody.verifyResult){ // 登录成功
          Router.push("/main");
        }else {
          ElMessage.error(respBody.verifyMsg)
        }
      }); 
    });
  }

  login(); 
}

/* 重置form表单 */
function resetLoginForm(){
  loginFormRef.value.resetFields();
}


</script>

<style scoped>
.login_form {
  width: 100%;
  padding: 0 25%;
  box-sizing: border-box;
}
.login_box {
  width: 400px;
  height: 300px;
  background-color: #fff;
  border-radius: 3px;
  margin: auto;
  border: solid 1px black;
  border-radius: 10px;
  text-align: center;
}

a {
  /* text-decoration: none; */
  color: rgb(52, 140, 241);
}

.header-div img {
  vertical-align: middle;
  height: 60px;
  width: 60px;
  margin: 5px auto ;
}
</style>