<script setup>
import {reactive, ref} from 'vue'
import {useRouter} from "vue-router"
import axios from '../../js/axiosInstance.js'

const labelPosition = ref('top')
const router = useRouter()
const formLabelAlign = reactive({
  username: '',
  password: '',
  mailboxvalidate: '',
})
/*const mailboxv = ref()*/

function mailboxvalidate() {

  axios({
    method: 'get',
    url: "https://sj.bycyjs.top/mailboxService/sendVerificationCode",
    headers: {
      "username": formLabelAlign.username
    }

  }).then((result) => {
    /*console.log(result.data)
    mailboxv.value = result.data.data;*/
    alert('邮箱验证码发送成功')

  }).catch((err) => {
    alert("邮箱验证码发送失败")
  })
}

/*登陆验证*/
function login() {
  var _this = this;
/*  console.log(mailboxv.value)*/

/*  if (mailboxv.value === formLabelAlign.mailboxvalidate) {*/
    axios({
      method: 'post',
      url: "https://sj.bycyjs.top/userservice/validateUser/"+formLabelAlign.mailboxvalidate,
      data: {
        username: formLabelAlign.username,
        password: formLabelAlign.password,
      }
    }).then((result) => {
      if (result.data.code === 1) {
        alert('登陆成功')
        // this.$router.push({name:"layout"})
        var userdata = {
          "username": formLabelAlign.username,
          "password": formLabelAlign.password
        }
        localStorage.setItem("userdata", JSON.stringify(userdata))
        router.push({
          path: "/function"
        })
      }else {
        alert(result.data.msg)
      }
    }).catch((err) => {

    });
  /*} else {
    alert('验证码错误')
  }*/

}

document.title = "登陆"
</script>

<template>
  <div id="login">
    <div class="background">
      <div class="con_top_text">
        <div class="con_top_text_n">
          <div class="con_top_text_title">
            <span>登陆</span>
          </div>
          <div class="con_top_text_title2">


            <el-form :label-position="labelPosition" label-width="100px" :model="formLabelAlign"
                     style="max-width: 460px">
              <el-form-item label="用户名">
                <el-input v-model="formLabelAlign.username"/>
              </el-form-item>
              <el-form-item label="密码">
                <el-input v-model="formLabelAlign.password"/>
              </el-form-item>
              <div style="display: flex;">

                <el-form-item label="邮箱验证码">
                  <el-input v-model="formLabelAlign.mailboxvalidate"/>
                </el-form-item>

                <el-row class="mb-4" style="margin-top:30px; ">
                  <el-button type="primary" plain @click="mailboxvalidate()">获取邮箱验证吗</el-button>
                </el-row>


              </div>


            </el-form>
            <el-row class="mb-4" style="flex-wrap: wrap;">
              <el-button type="primary" round @click="login()">登陆</el-button>
              <el-button type="success" round>
                <router-link to="/enroll" class="router-test tab_text">
                  注册
                </router-link>
              </el-button>
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
