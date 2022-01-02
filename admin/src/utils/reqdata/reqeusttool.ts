/*
 * @Author: your name
 * @Date: 2022-01-01 19:09:04
 * @LastEditTime: 2022-01-02 18:48:43
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \test-vue\src\utils\reqeusttool.ts
 */

import axios, { AxiosInstance, AxiosRequestConfig } from "axios"
import NProgress from "nprogress"
import "nprogress/nprogress.css"


class HttpRequest {
  private readonly baseUrl: string;
  constructor() {
    // this.baseUrl = "http://127.0.0.1:8801";
    this.baseUrl = import.meta.env.VITE_APP_URL;
  }

  getInsideConfig() {
    const config = {
      baseURL: this.baseUrl,
      headers: {
      }
    }
    return config;
  }

  /* 请求拦截 */
  interceptors(instance: AxiosInstance, url: string | number | undefined) {
    instance.interceptors.request.use(config => {
      // 添加全局的loading
      // 请求头携带token
      NProgress.start();
      return config;
    }, (error: any) => {
      return Promise.reject(error);
    });
    // 响应拦截
    instance.interceptors.response.use(res => {
      // 返回数据
      NProgress.done();
      const { data } = res;
      console.log("返回数据:", res);
      return data;
    }, (error: any) => {
      console.log("error=>", error);
      return Promise.reject(error);
    });
  }


  request(options: AxiosRequestConfig) {
    const instance = axios.create();
    options = Object.assign(this.getInsideConfig(), options);
    this.interceptors(instance, options.url);
    return instance(options);
  }

}

const http = new HttpRequest()
export default http;