//axiosInstance.js
//导入axios
// import axios from '../exterior/node_modules/axios/dist/axios'

//使用axios下面的create([config])方法创建axios实例，其中config参数为axios最基本的配置信息。
// const API = axios.create({
// 	baseURL:'https://sj.bycyjs.top', //请求后端数据的基本地址，自定义
// 	timeout: 2000                   //请求超时设置，单位ms
// })
axios.defaults.baseURL = 'https://sj.bycyjs.top';
axios.defaults.timeout=10000;


var user = localStorage.getItem("userdata");
var userdata = JSON.parse(user);
// alert(userdata)
axios.interceptors.request.use(function (config) {
    
    // 在发送请求之前做些什么
    if (userdata != null) {
        config.headers.password = userdata.username
        config.headers.username = userdata.password
    }

    return config;
}, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
});

// 添加响应拦截器
axios.interceptors.response.use(function (response) {
    // 2xx 范围内的状态码都会触发该函数。
    // 对响应数据做点什么
    return response;
}, function (error) {
    // 超出 2xx 范围的状态码都会触发该函数。
    // 对响应错误做点什么
    return Promise.reject(error);
});
//导出我们建立的axios实例模块，ES6 export用法
// export default axios
