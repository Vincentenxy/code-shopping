/*
 * @Author: your name
 * @Date: 2022-01-01 11:25:46
 * @LastEditTime: 2022-01-02 18:26:28
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \test-vue\src\main.ts
 */

import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from "./router"


const app = createApp(App)
app.use(router);
app.use(ElementPlus);
app.mount('#app');