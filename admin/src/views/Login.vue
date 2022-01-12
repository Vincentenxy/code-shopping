
<template>
  Login Page
  <div class="login_box">
    <el-form
      ref="loginFormRef"
      class="login_form"
      :model="ruleForm"
      :rules="loginRules"
    >
      <el-form-item lable="用户名" prop="name">
        <el-input v-model="ruleForm.name" prefix-icon="user"></el-input>
      </el-form-item>
      <el-form-item lable="密码" prop="passwd">
        <el-input type="password" v-model="ruleForm.passwd" prefix-icon="lock"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm()">登录</el-button>
        <el-button type="info" @click="resetLoginForm ">重置</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script lang="ts" setup>
import { reactive, ref } from "@vue/reactivity";
import { PostRequest } from "./../utils/reqdata/requestindex";
import { ElForm } from "element-plus";
import Userlist from "./Userlist.vue";
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
  console.log("===>用户点击登录"); 
  const login = () =>{
    console.log("00000>>>>")
    loginFormRef.value.validate((valid: boolean)=>{
      if(!valid) return;
      const params = {
        username: ruleForm.name,
        password: md5(ruleForm.passwd)
      };
      console.log("--------->"+JSON.stringify(params))
      PostRequest('03001001', params, 'pub').then((resp)=>{
        console.log("========>" + JSON.stringify(resp));
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
  padding: 0 20px;
  box-sizing: border-box;
}
.login_box {
  width: 450px;
  height: 300px;
  background-color: #fff;
  border-radius: 3px;
  margin: auto;
}
</style>