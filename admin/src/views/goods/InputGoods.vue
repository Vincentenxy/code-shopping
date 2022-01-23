<!--
 * @Author: your name
 * @Date: 2022-01-09 23:41:51
 * @LastEditTime: 2022-01-23 23:58:26
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \admin\src\views\goods\InputGoods.vue
-->
<template>
  <div style="width:80%;">
    <h1>基本信息</h1>
    <el-form
    ref="ruleFormRef"
    :model="goodsInfo"
    :rules="verifyRules"
    label-width="120px"
    class="demo-ruleForm"
  >
    <el-form-item label="商品唯一编号" prop="goodsNum">
      <el-input v-model="goodsInfo.goodsNum"></el-input>
    </el-form-item>
    <el-form-item label="商品名称" prop="name">
      <el-input v-model="goodsInfo.name"></el-input>
    </el-form-item>
    <el-form-item label="标签" prop="label">
      <el-select v-model="goodsInfo.label">洗衣机</el-select>
    </el-form-item>
    <el-form-item label="商品描述" prop="desc">
      <el-input v-model="goodsInfo.desc"></el-input>
    </el-form-item>
    <el-form-item label="商品状态" prop="statue">
      <el-select label="请选择状态" placeholder="商品状态" v-model="goodsInfo.selectedStatue">
        <el-option v-for="item in goodsInfo.statues" :key="item.key" :label="item.value" :value="item.key"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item>
      <span>商品图片</span>
      <el-input type="file"></el-input>
    </el-form-item>
    <h1>规格信息</h1>
    <el-form-item label="规格名称" prop="formatName">
      <el-input v-model="goodsInfo.formatName"></el-input>
    </el-form-item>
    <el-form-item label="规格价格" prop="formatPrice">
      <el-input v-model="goodsInfo.formatPrice"></el-input>
    </el-form-item>
    <el-form-item label="规格数量" prop="formatCount">
      <el-input v-model="goodsInfo.formatCount"></el-input>
    </el-form-item>
    <el-form-item label="规格状态" prop="formatStatus">
      <el-input v-model="goodsInfo.formatStatue"></el-input>
    </el-form-item>
    <el-form-item label="品牌id" prop="formatBrand">
      <el-select label="品牌" placeholder="商品品牌" v-model="goodsInfo.selectedBrandId">
        <el-option v-for="item in goodsInfo.formatBrand" :key="item.brandId" :label="item.brandName" :value="item.brandId"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="平台价格" prop="platformPrice">
      <el-input v-model="goodsInfo.platformPrice"></el-input>
    </el-form-item>
    <el-form-item>
      <router-view></router-view>
    </el-form-item>

<!--     
    <el-form-item label="类别" prop="categoryId">
      <el-select v-model="goodsInfo.categoryId"></el-select>
    </el-form-item>
    <el-form-item label="规格名称" prop="formatName">
      <el-input v-model="goodsInfo.formatName"></el-input>
    </el-form-item>
    <el-form-item label="规格价格" prop="formatPrice">
      <el-input v-model="goodsInfo.shopId"></el-input>
    </el-form-item> -->

    <el-form-item>
      <el-button type="primary">提交</el-button>
      <el-button type="primary">重置</el-button>
    </el-form-item>
  </el-form>

  </div>
</template>

<script lang="ts" setup>
  import { reactive, ReactiveFlags, ref } from "@vue/reactivity";
  import { onBeforeMount } from "@vue/runtime-core";
  import { PostRequest } from "../../utils/reqdata/requestindex";

  const goodsInfo = ref({
    goodsNum: '', // 商品唯一编号
    name: '',     // 商品名称
    label: '',    // 商品标签
    desc: '',     // 商品描述
    selectedBrandId: '',  // 客户选中的品牌id
    selectedStatue: '',   // 选中得到状态
    statues: [    // 商品状态
      {
        "key": "0",
        "value": "在售"
      },
      {
        "key": "1",
        "value": "停售"
      },
    ],   
    formatName: '',  // 规格名称
    formatPrice: '', // 规格价格
    formatCount: '', // 规格数量
    formatStatue: [  // 规格状态

    ],
    formatBrand: [   // 规格品牌
      {
        "brandId": "",      // 品牌id
        "brandName": "",    // 品牌名称
        "brandNameEng": "", // 品牌英文名称
        "brandDesc": "",    // 平拍描述
        "fkCategoryId": "", // 类别ID
      }
    ], 
    platformPrice: '',      // 平台价格
  
  

  }); 

  // 校验规则
  const verifyRules = reactive({

  }); 

  /* 请求获取相关信息 */
  async function queryRelevantInfo(){
    let reqData = {};
    const response = await PostRequest('02002002', reqData).then(resp => {
      let respBody = resp.respBody;
      goodsInfo.value.formatBrand = respBody.brandInfos; 
      console.log("----> goodlsInfo==" + JSON.stringify(goodsInfo.value))
    });
  }

  /* 图片上传 */
  async function uploadFiles(){

  }

  /* 生命周期函数 */
  onBeforeMount(()=>{
    queryRelevantInfo(); 
  }); 


</script>

<style scoped>

</style>