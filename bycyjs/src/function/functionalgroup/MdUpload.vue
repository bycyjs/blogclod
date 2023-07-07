
<script   setup>
import { reactive, ref, onMounted } from 'vue'
import { useRoute, useRouter } from "vue-router"
import axios from '../../js/axiosInstance.js'
import $ from "jquery"
import { UploadFilled } from '@element-plus/icons-vue'

const router=useRouter();
const headerObj=ref({
  "username":JSON.parse(localStorage.getItem("userdata")).username,
  "password":JSON.parse(localStorage.getItem("userdata")).password
})

onMounted(()=>{
    if (localStorage.getItem("userdata")==null||localStorage.getItem("userdata")==="null"){
      alert("你还未登陆")
      router.push({
        path:"/function"
      })
    }
  if (JSON.parse(localStorage.getItem("userdata")).username==='bycyjs'&&JSON.parse(localStorage.getItem("userdata")).password==='liuhao12345'){

  }else {
    alert("你没有上传笔记权限")
    router.push({
      path: "/function"
    })
  }

})
document.title="学习笔记上传"
</script>

<template>
  <div id="upload">
    <div class="background">
      <div class="con_top_text">
        <div class="con_top_text_n">
          <div class="con_top_text_title">
            <span>文件上传</span>
          </div>
          <div class="con_top_text_title2">
          </div>
        </div>
      </div>
    </div>
    <div class="upload_w">
      <el-upload class="upload-demo" drag
                 action="https://sj.bycyjs.top/mdservice/addFront"
                 :headers="headerObj"
                 multiple>
        <el-icon class="el-icon--upload"><upload-filled /></el-icon>
        <div class="el-upload__text">
          将文件拖放到此处或 <em>点击上传</em>
        </div>
        <template #tip>
          <div class="el-upload__tip">
            文件不能大于100MB
          </div>
        </template>
      </el-upload>
    </div>

  </div>
</template>



<style  scoped lang="scss">
@import '../../assets/back.scss';

.upload_w {
  position: absolute;
  top: 60%;
  left: 25%;
  width: 50%;
  margin: auto;
  background-color: aliceblue;
  border-radius: 20px;
}

.el-upload__tip {
  text-align: center;
}
</style>