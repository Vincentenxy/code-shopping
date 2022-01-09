<!--
 * @Author: your name
 * @Date: 2022-01-02 11:07:14
 * @LastEditTime: 2022-01-08 20:04:23
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \test-vue\src\views\Login.vue
-->
<template>
  <div>
    Login Page
    <div class="">
      <el-form
        reg="ruleForm"
        :model="ruleForm"
        :rules="rules"
        label-width="120px"
        class="sty-ruleForm"
      >
        <el-form-itme lable="用户名" prop="name">
          <el-input v-model="ruleForm.name"></el-input>
        </el-form-itme>
        <el-form-itme lable="密码" prop="passwd">
          <el-input type="password" v-model="ruleForm.passwd"></el-input>
        </el-form-itme>
        <el-form-itme>
          <el-button type="primary" @click="submitForm('ruleForm')"> 登录</el-button>
        </el-form-itme>
      </el-form>
      
    </div>
  </div>
</template>

<script lang="ts" setup>
import { reactive } from "@vue/reactivity";

const ruleForm = reactive({
  name: '请输入用户名',
  passwd: ''
});

// 校验规则
const rules = reactive({
  name: [
    {
      required: true,
      message: 'Please input Activity name',
      trigger: 'blur',
    },
    {
      min: 3,
      max: 5,
      message: 'Length should be 3 to 5',
      trigger: 'blur',
    },
  ],
}); 


function submitForm(l_data: any){
  console.log("=======》用户点击登录")
}


</script>

<style scoped>
.sty-ruleForm{
  width: 300px;
  height: 30px;
}
</style>