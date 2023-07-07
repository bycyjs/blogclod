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
document.title="邮箱验证码测试"
</script>

<template>
    <div id="login">
        <div class="background">
            <div class="con_top_text">
                <div class="con_top_text_n">
                    <div class="con_top_text_title">
                        <span>邮箱验证码测试</span>
                    </div>
                    <div class="con_top_text_title2">


                        <el-form :label-position="labelPosition" label-width="100px" :model="formLabelAlign"
                            style="max-width: 460px">
                          
                            <el-form-item label="邮箱验证码测试">
                                <el-input v-model="formLabelAlign.mailbox" />
                            </el-form-item>
                           


                        </el-form>
                        <el-row class="mb-4" style="flex-wrap: wrap;">
                            <el-button type="primary" round @click="mailboxvalidate()">发送邮箱验证码</el-button>

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
