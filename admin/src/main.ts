/*
 * @Author: your name
 * @Date: 2022-01-01 11:25:46
 * @LastEditTime: 2022-01-12 23:18:32
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \test-vue\src\main.ts
 */

import { createApp } from 'vue'
import ElementPlus, { ElIcon } from 'element-plus'
import * as ElIcons from '@element-plus/icons-vue'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from "./router"
import { GetRequest, PostRequest } from "./utils/reqdata/requestindex"
import md5 from "js-md5"



const app = createApp(App)
app.use(router);
app.use(ElementPlus);
// app.use(md5);
for (const name in ElIcons) {
  app.component(name, ElIcons[name])
}
app.mount('#app');