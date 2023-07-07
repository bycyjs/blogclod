

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import layui from 'layui'
import 'layui/dist/css/layui.css'
import $ from 'jquery'

import Vant from 'vant'
import 'vant/lib/index.css';


const app = createApp(App)
app.use(Vant)
app.use(createPinia())
app.use(router)
app.use(ElementPlus)
app.use(layui)
app.use($)

app.mount('#app')
