<!--
 * @Author: your name
 * @Date: 2022-01-23 23:55:39
 * @LastEditTime: 2022-01-29 23:28:29
 * @LastEditors: Please set LastEditors
 * @Description: 文件上传组件
 * @FilePath: \admin\src\components\common\uoloadFile.vue
-->

<template>
  <div>
    文件上传组件
    <el-upload
      :action="string"
      multiple
      :file-list="fileList"
      :http-request="uploadFiles"
    > 
    <el-button type="primary">Click to upload</el-button>

    </el-upload>
    <el-button @click="goFile" type="primary"></el-button>
  </div>
</template>

<script lang="ts" setup>
  import { reactive, ref } from "@vue/reactivity";
  import { onBeforeMount } from "vue";
  import type { UploadFile } from 'element-plus/es/components/upload/src/upload.type'
import upload from "element-plus/es/components/upload/src/ajax";
import axios from "axios";

  // 文件接口
  interface RawFile {
    name: string, 
    url: string
  }

  const uploadFilesUrl = ref(''); 

  const fileList = ref<RawFile[]>([]); 


  /* 文件上传 */
  function uploadFiles(params){
    const formData = new FormData(); 
    formData.append('files', params.file); 
    console.log("---->param=" + JSON.stringify(params))

    let config = {
      method: "POST", 
      url: "http://127.0.0.1:8801/api/pub/v1/comm/03002001", 
      headers: {
        "Content-Type": "multipart/form-data"
      },
      data: formData
    }; 

    axios.post(config.url, )

  }

  onBeforeMount(()=>{
    uploadFilesUrl.value = import.meta.env.VITE_APP_URL + "/api/pub/v1/comm/03002001";  // 文件上传路径
 
    console.log("uploadFileUrl == " + uploadFilesUrl.value)
 }); 

</script>

<style scoped>

</style>