<!--
 * @Author
  components: { Userlist },: your name
 * @Date: 2022-01-02 11:07:14
 * @LastEditTime: 2022-01-11 00:00:12
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \test-vue\src\views\Login.vue
-->
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
        <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
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
function submitForm(loginFormRef: any){
  console.log("=======》用户点击登录")
  const login = () =>{
    loginFormRef.value.validdate((valid: boolean)=>{
      if(!valid) return;
      const params = {
        userName: ruleForm.name,
        password: ruleForm.passwd
      };
      PostRequest('03001001', params, 'pub').then((resp)=>{
        console.log("========>" + JSON.stringify(resp));
      }); 
    });
  }
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