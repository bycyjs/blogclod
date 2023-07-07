import { message,notification } from 'ant-design-vue';
import 'ant-design-vue/es/message/style/css.js'
import 'ant-design-vue/es/notification/style/css.js'

export default{
    install(app){
        app.config.globalProperties.$message=message;
        app.config.globalProperties.$notification=notification;
    }
}