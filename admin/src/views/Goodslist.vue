<!--
 * @Author: your name
 * @Date: 2022-01-01 11:46:05
 * @LastEditTime: 2022-01-02 16:37:10
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \test-vue\src\views\Goodlist.vue
-->

<template>
  <el-table :data="tableData" style="width: 100%">
    <el-table-column label="Date" width="180">
      <template #default="scope">
        <div style="display: flex; align-items: center">
          <el-icon><timer /></el-icon>
          <span style="margin-left: 10px">{{ scope.row.date }}</span>
        </div>
      </template>
    </el-table-column>
    <el-table-column label="商品名称" width="180">
      <template #default="scope">
        <el-popover effect="light" trigger="hover" placement="top">
          <template #default>
            <p>shangpin: {{ scope.row.name }}</p>
            <p>address: {{ scope.row.address }}</p>
          </template>
          <template #reference>
            <div class="name-wrapper">
              <el-tag>{{ scope.row.name }}</el-tag>
            </div>
          </template>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column label="Operations">
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
          >Edit</el-button
        >
        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.$index, scope.row)"
          >Delete</el-button
        >
      </template>
    </el-table-column>
  </el-table>
</template>

<script lang="ts" setup>
import { onMounted } from 'vue'
import { Timer } from '@element-plus/icons-vue'
import axios from "axios"
import {GetRequest, PostRequest} from "../utils/reqdata/requestindex"

interface User {
  date: string
  name: string
  address: string
}

const tmpUrl = import.meta.env.VITE_APP_URL

const handleEdit = (index: number, row: User) => {
  console.log(index, row)
}
const handleDelete = (index: number, row: User) => {
  console.log(index, row)
}

const tableData: User[] = lodaData(); 

function lodaData(): Array<User>{

  let reqData: any = {
    "test1": "nihaomyada",
    "test3": "asdfasdf "
  }; 

  PostRequest("02002001", reqData, '', '请求数据中')
    .then((res: any)=>{
      console.log("=====>", JSON.stringify(res));
  });

  let userList: User[] = [
    {
      date: '2016-05-03',
      name: 'To士大夫 m',
      address: 'No. 189, Grove St, Los Angeles',
    },
    {
      date: '2016-05-02',
      name: 'Tom',
      address: 'No. 189, Grove St, Los Angeles',
    },
    {
      date: '2016-05-04',
      name: 'Tom',
      address: 'No. 189, Grove St, Los Angeles',
    },
    {
      date: '2016-05-01',
      name: 'Tom',
      address: 'No. 189, Grove St, Los Angeles',
    },
  ];

 return userList; 
}

onMounted(()=>{
    console.log("-------》", tmpUrl); 
    lodaData(); 
});



</script>
