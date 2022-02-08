/*
 * @Author: your name
 * @Date: 2022-01-01 19:52:56
 * @LastEditTime: 2022-02-08 23:12:29
 * @LastEditors: Please set LastEditors
 * @Description: 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 * @FilePath: \test-vue\src\utils\reqdata\index.ts
 */

import http from "./reqeusttool"

/**
 * 请求常量
 */
enum ReqConstans {
  BASE_URL_PRI = "/api/pri/v1/adm/",
  BASE_URL_COMM = "/api/pub/v1/comm/",
}

export const GetRequest = (reqUrl: string) => {
  return http.request({
    url: reqUrl,
    method: "GET"
  });
};

/**
 * 
 * @param reqCode 请求接口
 * @param reqData 发送的数据
 * @param reqType 第一个参数为请求类型 pri, pub； 第二个参数为接口描述
 * @returns 
 */
export const PostRequest = (reqCode: string, reqData: any, ...reqParams: string[]) => {

  // 组发送数据
  let reqStr: any = {
    "reqCode": reqCode,
    "reqMsg": reqParams[1],
    "reqComm": {},
    "reqBody": reqData
  }

  return http.request({
    url: (reqParams && reqParams[0] && reqParams[0] === 'pub' ? ReqConstans.BASE_URL_COMM : ReqConstans.BASE_URL_PRI) + reqCode,
    method: "POST",
    data: reqStr
  });

};

/**
 * 文件上传接口
 * @param reqCode 请求码
 * @param reqData 请求数据
 */
export const UploadFile = (reqCode: string, reqData: any) => {

  http.getInsideConfig().headers = {
    "Content-Type": "multipart/form-data"
  };

  return http.request({
    url: ReqConstans.BASE_URL_COMM + reqCode,
    method: "POST",
    data: reqData.fileData
  });
}