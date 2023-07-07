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
const mailboxv = ref();
/*const mailboxa = ref();*/
const d = ref(0);

function enroll() {
 /* if (d.value !== 1) {
    alert("没有获取验证码")
    return;
  }*/
  /*if (mailboxa.value === mailboxv.value) {*/
    axios({
      method: 'post',
      url: "userservice/login/"+mailboxv.value,
      data: {
        username: formLabelAlign.username,
        password: formLabelAlign.password,
        mailboxvalidate: formLabelAlign.mailboxvalidate

      }
    }).then((result) => {
      if (result.data.code === 1) {
        alert(result.data.data)
        var userdata = {
          "username": formLabelAlign.username,
          "password": formLabelAlign.password
        }
        localStorage.setItem("userdata", JSON.stringify(userdata))
        router.push({
          path: "/function"
        })
      } else {
        alert(result.data.msg)
      }

    }).catch((err) => {

    });
/*  }*/

}

/*发送验证码*/

function mailboxvalidate() {

  axios({
    method: 'get',
    url: "userservice/sendVerificationCodelogin/" + formLabelAlign.mailboxvalidate,
  }).then((result) => {
   /* mailboxa.value = result.data.data*/
   /* d.value = 1*/
    if (result.data.code===1){
      alert(result.data.data)
    }else {
      alert(result.data.msg)
    }

  }).catch((err) => {
    alert("验证码发送失败")
  });
}

document.title = "注册"

</script>

<template>
  <div id="enroll">
    <div class="background">
      <div class="con_top_text">
        <div class="con_top_text_n">
          <div class="con_top_text_title">
            <span>注册</span>
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
              <el-form-item label="要绑定的邮箱">
                <el-input v-model="formLabelAlign.mailboxvalidate"/>
              </el-form-item>
              <div style="display: flex;">

                <el-form-item label="邮箱验证码">
                  <el-input v-model="mailboxv"/>
                </el-form-item>

                <el-row class="mb-4" style="margin-top:30px; ">
                  <el-button type="primary" plain @click="mailboxvalidate()">获取邮箱验证吗</el-button>
                </el-row>


              </div>


            </el-form>
            <el-row class="mb-4" style="flex-wrap: wrap;">
              <el-button type="primary" round>
                <router-link to="/login" class="router-test tab_text">
                  登陆
                </router-link>
              </el-button>
              <el-button type="success" round @click="enroll()">注册</el-button>
            </el-row>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<style scoped lang="scss">
@import '../../assets/back.scss';

.con_top_text_n {
  margin-top: 150px;
  background-color: rgba(197, 212, 110, 0.7);
  border-radius: 20px;
  padding: 20px;
}
</style>