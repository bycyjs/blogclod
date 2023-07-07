import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import legacy from '@vitejs/plugin-legacy';
import Components from 'unplugin-vue-components/vite'
import { AntDesignVueResolver } from 'unplugin-vue-components/resolvers'


// https://vitejs.dev/config/
export default defineConfig({
  base: './',
  plugins: [
  
    vue(),
    // 
    Components({
      resolvers: [AntDesignVueResolver()]
    }),
    // legacy({
		// 	targets: ['ie>=11'],
		// 	additionalLegacyPolyfills: ['regenerator-runtime/runtime'],
		// }),

    
  ],
  build:{
    target: ['es2015', 'chrome63'], // 默认是modules,百度说是更改这个会去输出兼容浏览器，尝试没啥作用，先配置吧
  },

  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    host: 'localhost',//ip地址
    port: 8070, // 设置服务启动端口号
    open: true, // 设置服务启动时是否自动打开浏览器

    proxy: {
      '/api': {
        target: '<https://sj.bycyjs.top>',
        changeOrigin: true,// 如果配置为true
        rewrite: path => path.replace(/^api/, '')
      }
    }
  }




})
