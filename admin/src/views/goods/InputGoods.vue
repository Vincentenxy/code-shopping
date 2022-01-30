<!--
 * @Author: your name
 * @Date: 2022-01-09 23:41:51
 * @LastEditTime: 2022-01-26 00:24:20
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \admin\src\views\goods\InputGoods.vue
-->
<template>
  <div style="width:80%;">
    <h1>基本信息</h1>
    <el-form
    ref="goodsInfoFormRef"
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
    <el-form-item label="商品描述" prop="desc">
      <el-input v-model="goodsInfo.desc"></el-input>
    </el-form-item>
    <el-form-item label="标签" prop="label">
      <el-cascader :options="goodsInfo.labelList" ></el-cascader>
    </el-form-item><el-form-item label="商品状态" prop="statue">
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
    <el-form-item label="平台价格" prop="platformPrice">
      <el-input v-model="goodsInfo.platformPrice"></el-input>
    </el-form-item>
    <el-form-item label="规格数量" prop="formatCount">
      <el-input-number v-model="goodsInfo.formatCount" :min="1" :max="100" ></el-input-number>
    </el-form-item>
    <el-form-item label="规格状态" prop="formatStatus">
      <el-select label="规格状态" placeholder="请选择规格状态" v-model="goodsInfo.selectedFormatStatue">
        <el-option v-for="item in goodsInfo.formatStatue" :key="item.key" :label="item.value" :value="item.key"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="品牌id" prop="formatBrand">
      <el-select label="品牌" placeholder="商品品牌" v-model="goodsInfo.selectedBrandId">
        <el-option v-for="item in goodsInfo.formatBrand" :key="item.brandId" :label="item.brandName" :value="item.brandId"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="详细规格信息" prop="formatDetail">
      <el-input v-model="goodsInfo.platformPrice"></el-input>
    </el-form-item>
 
    <el-form-item>
      <router-view></router-view>
    </el-form-item>
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
    desc: '',     // 商品详情
    selectedBrandId: '',  // 客户选中的品牌id
    categoryId: '',  // 类别ID
    shopId: '',      // 店铺id
    selectedStatue: '',   // 选中的状态
    formatName: '',  // 规格名称
    formatPrice: '', // 规格价格
    formatCount: '', // 规格数量
    selectedFormatStatue: '', // 选中的规格状态
    platformPrice: '',        // 平台价格
    formatDetail: '',         // 此规格详细信息
    labelList: [     // 标签选择
      {
        
      }
    ],
    statues: [       // 商品状态
      {
        "key": "0",
        "value": "在售"
      },
      {
        "key": "1",
        "value": "停售"
      },
    ],   
    formatStatue: [ // 规格状态
      {
        "key": "0",
        "value": "在售"
      },
      {
        "key": "1",
        "value": "停售"
      },
    ],
    formatBrand: [          // 规格品牌
      {
        "brandId": "",      // 品牌id
        "brandName": "",    // 品牌名称
        "brandNameEng": "", // 品牌英文名称
        "brandDesc": "",    // 平拍描述
        "fkCategoryId": "", // 类别ID
      }
    ]
  }); 

  // 校验规则
  const verifyRules = reactive({
    goodsNum: [
      {
        required: true,
        message: '请输入商品唯一编号',
        trigger: 'blur',
      },
      {
        min: 10,
        max: 30,
        message: '商品唯一编号必须大于10位小于30位',
        trigger: 'blur',
      }
    ],
    name: [
      {
        required: true,
        message: '请输入商品名称',
        trigger: 'blur',
      },
      {
        min: 1,
        max: 33,
        message: '商品唯一编号必须大于1位小于33位',
        trigger: 'blur',
      }
    ],
    label: [
    ],
    formatName: [
      {
        required: true,
        message: '请输如入规格名称',
        trigger: 'blur',
      },
      {
        min: 10,
        max: 30,
        message: '商品唯一编号必须大于10位小于30位',
        trigger: 'blur',
      }
    ],
    desc: [
      {
        required: true,
        message: '请输入商品描述',
        trigger: 'blur',
      },
      {
        min: 5,
        max: 100,
        message: '商品描述需要大于5位小于100位',
        trigger: 'blur',
      }
    ],
    formatPrice: [
      {
        required: true,
        message: '请输入商品价格',
        trigger: 'blur',
      }
    ],
    platformPrice: [
      {
        required: true,
        message: '请输入平台价格',
        trigger: 'blur',
      }
    ],
    statues: [
      {
        required: true,
        message: '请输入平台价格',
        trigger: 'blur',
      }
    ],
    formatBrand: [
      {
        required: true,
        message: '请选择品牌id',
        trigger: 'blur',
      }
    ],
    formatDetail: [
      {
        required: true,
        message: '请输入规格详情',
        trigger: 'blur',
      }
    ]
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

  /**
   * 添加商品
   */
  const goodsInfoFormRef = ref(); 
  function addGoodsInfo(){
    goodsInfoFormRef.value.validate((valid: boolean)=>{
      if(!valid) return; 
      let reqData = {
        "goodsNum": goodsInfo.value.goodsNum,
        "goodsName": goodsInfo.value.name,
        "goodsLabel": goodsInfo.value.label,
        "goodsDesc": goodsInfo.value.desc,
        "goodsStatue": goodsInfo.value.selectedStatue,
        "categoryId": goodsInfo.value.categoryId,
        "shopId": goodsInfo.value.shopId,
        "formatName": goodsInfo.value.formatName,
        "formatPrice": goodsInfoFormRef.value.formatPrice,
        "formatCount": goodsInfo.value.formatCount,
        "formatStatus": goodsInfo.value.formatStatue,
        "formatBrand": goodsInfo.value.formatBrand,
        "platformPrice": goodsInfo.value.platformPrice
      }; 

      const response = PostRequest('', reqData).then(resp => {
        console.log("020002 = " + JSON.stringify(resp))
      }); 
    }); 
    
  }


  /* 生命周期函数 */
  onBeforeMount(()=>{
    queryRelevantInfo(); 
  }); 


</script>

<style scoped>

</style>