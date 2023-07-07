<script setup>
import {onMounted, reactive, ref} from 'vue'
import { useRoute, useRouter } from "vue-router"
import axios from '../../js/axiosInstance.js'
const labelPosition = ref('top')
const router = useRouter()
const formLabelAlign = reactive({
    username: '',
    password: '',
    mailboxvalidate: '',
    mailbox: ""
})
const mailboxv = ref()
function mailboxvalidate() {
    var _this = this;
    axios({
        method: 'get',
        url: "userservice/sendVerificationCodelogin/" + formLabelAlign.mailbox,
    }).then((result) => {
        _this.mailboxv = result.data.data;
        alert('邮箱验证码发送成功')
    }).catch((err) => {

    });
}
function bd() {
    var _this = this;
    if (_this.mailboxv === _this.formLabelAlign.mailboxvalidate) {
        axios({
            method: 'get',
            url: "mailboxService/addMailbox/" + _this.formLabelAlign.mailbox,

        }).then((result) => {
            
                alert(result.data.msg)
                router.push({
                    path: "/function"
                })
           
        }).catch((err) => {
            
        });
    } else {
        alert("验证码错误")
    }
}
document.title="添加邮箱"

onMounted(()=>{
  if (localStorage.getItem("userdata")==null||localStorage.getItem("userdata")==="null"){
    alert("你还未登陆")
    router.push({
      path:"/function"
    })
  }
})
</script>

<template>
    <div id="login">
        <div class="background">
            <div class="con_top_text">
                <div class="con_top_text_n">
                    <div class="con_top_text_title">
                        <span>添加邮箱</span>
                    </div>
                    <div class="con_top_text_title2">


                        <el-form :label-position="labelPosition" label-width="100px" :model="formLabelAlign"
                            style="max-width: 460px">
                          
                            <el-form-item label="添加邮箱">
                                <el-input v-model="formLabelAlign.mailbox" />
                            </el-form-item>
                            <div style="display: flex;">

                                <el-form-item label="邮箱验证码">
                                    <el-input v-model="formLabelAlign.mailboxvalidate" />
                                </el-form-item>

                                <el-row class="mb-4" style="margin-top:30px; ">
                                    <el-button type="primary" plain @click="mailboxvalidate()">获取邮箱验证吗</el-button>
                                </el-row>


                            </div>


                        </el-form>
                        <el-row class="mb-4" style="flex-wrap: wrap;">
                            <el-button type="primary" round @click="bd()">绑定邮箱</el-button>

                        </el-row>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped lang="scss">
@import '../../assets/back.scss';

.con_top_text_n span {
    color: #000;
}

.con_top_text_n {
    background-color: rgba(197, 212, 110, 0.7);
    border-radius: 20px;
    padding: 20px;
}
</style>
