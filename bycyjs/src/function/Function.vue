<script setup>
import $ from "jquery"
import {useRouter} from "vue-router"
import {ref} from 'vue'

const router = useRouter();
$(() => {
  var tabText = $(".tab_text")
  var color = ["#a7f4b7", "#a892dc", "#dfad69", "#df698d", "#7ac4bd", "#87d994", "#c7e7cc"]
  for (var i = 0; i < tabText.length; i++) {
    var sj = Math.floor(Math.random() * 7);
    $(tabText[i]).css("background-color", color[sj]);

  }
  $(".tab_text").hover(function () {
        $(this).css("background-color", "rgb(178, 230, 212)");

      }, function () {
        // out
        var sj = Math.floor(Math.random() * 7);
        $(this).css("background-color", color[sj]);
      }
  );
})

const userdata = ref(JSON.parse(localStorage.getItem("userdata")))

function loginpd() {
  if (localStorage.getItem("userdata") === null || localStorage.getItem("userdata") === "") {

    alert("你还未登陆")
    return false;
  }
  return true;
}

function upload() {

  if (loginpd()) {
    router.push({
      path: "/upload"
    })
  }
}

function filedownload() {
  if (loginpd()) {
    router.push({
      path: "/filedownload"
    })
  }
}
function addmailbox() {
  if (loginpd()) {
    router.push({
      path: "/addmailbox"
    })
  }
}
function sendmailboxcode() {
  if (loginpd()) {
    router.push({
      path: "/sendmailboxcode"
    })
  }
}
function mdupload() {
  if (loginpd()) {
    router.push({
      path: "/mdupload"
    })
  }
}
function note() {
    router.push({
      path: "/note"
    })
}
function quitlogin(){
  if (localStorage.getItem("userdata")!=null&&localStorage.getItem("userdata")!=="null"){
    localStorage.setItem("userdata",null)
    alert("退出登陆成功")
    router.push(({
      path:"/function"
    }))
  }else {
    alert("你还未登陆")
  }


}
document.title="功能"
</script>

<template>
  <div id="fuction">
    <van-nav-bar class="title" title="功能" />
    <div class="background">
      <div class="con_top_text">
        <div class="con_top_text_n">
          <div class="con_top_text_title">
            <span>功能界面</span>
          </div>
          <div class="con_top_text_title2">
            <span>新的一天，新的开始</span>
            <br>
            <span v-if="userdata!=null">{{ userdata.username }},欢迎登陆</span>
            <span v-if="userdata==null">你还未登陆，请登陆</span>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="fuctionlick">

    <div class="tab">
      <div class="tab_n">

        <div class="logtext">
          <img src="../../public/image/icon/icon_h9lil6qalut/标签_o.png" alt="">
          <span>功能链接</span>
        </div>
        <div class="tab_content ">
          <router-link to="/login" class="router-test tab_text">
            <span>登陆</span>
          </router-link>
          <router-link to="/enroll" class="router-test tab_text">
            <span>注册</span>
          </router-link>
          <a href="#" @click="upload()" class="router-test tab_text">
            <span>文件上传</span>
          </a>
          <a href="#" @click="filedownload()" class="router-test tab_text">
            <span>文件下载</span>
          </a>
          <a href="#" @click="addmailbox()" class="router-test tab_text">
            <span>添加邮箱</span>
          </a>
          <a href="#" @click="sendmailboxcode()" class="router-test tab_text">
            <span>发送邮箱验证码测试</span>
          </a>

          <a href="#" @click="mdupload()" class="router-test tab_text">
            <span>学习笔记上传</span>
          </a>
          <a @click="note()" class="router-test tab_text">
            <span>学习笔记目录</span>
          </a>
          <a @click="quitlogin()" class="router-test tab_text">
            <span>退出登陆</span>
          </a>
        </div>
      </div>
    </div>

  </div>
</template>

<style scoped lang="scss">
@import '../assets/back.scss';
@import '../assets/tab.css';
@import '../assets/title.scss';
</style>
