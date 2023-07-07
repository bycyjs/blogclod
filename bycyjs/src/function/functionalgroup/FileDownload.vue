
<script setup>
import { reactive, ref, onMounted, h } from 'vue'
import { useRoute, useRouter } from "vue-router"
import axios from '../../js/axiosInstance.js'
import $ from "jquery"
// $(() => {
// alert("test")
// })
axios.defaults.timeout=100000;
const tableData = ref([{
    id: "",
    filename: "",
    uploadtime: "",
    filetype: ""
}]);
onMounted(() => {
    var _this = this;
    axios({
        method: 'post',
        url: "fileservice/selectRecord",
    }).then((result) => {
        tableData.value = result.data.data
        console.log(tableData)
    }).catch((err) => {

    });
})

function xz(resp) {


    // var data = {
    //     "id": resp.id,
    //     "filename": resp.filename,
    //     "uploadtime": resp.uploadtime,
    // }
    axios({
        method: 'post',
        url: "fileservice/download",
        responseType: 'blob',
        data: {
            "id": resp.id,
            "filename": resp.filename,
            "uploadtime": resp.uploadtime,
        }
    })
        .then((result) => {
            const $link = document.createElement('a');
            $link.href = URL.createObjectURL(result.data);
            $link.download = resp.filename;
            $link.click();

        }).catch((err) => {

        });

}
function  sc(id){
                    var _this=this
                    axios({
                        method:'get',
                        url: "https://sj.bycyjs.top/fileservice/deleteRecord/"+id,
                        
                    }).then((result) => {
                        if(result.data.code==1){
                            alert("删除成功")
                        }
                    }).catch((err) => {
                        
                    });
                }

document.title="文件下载"

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
    <!-- <img src="../../../public/file/upload/sk/2023-06-16/20210731_194451.jpg" alt=""> -->
    <div id="filedownload">
        <div class="background">
            <div class="con_top_text">
                <div class="con_top_text_n">
                    <div class="con_top_text_title">
                        <span>文件下载</span>
                    </div>
                    <div class="con_top_text_title2">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="table">
        <div class="tablea">
            <div style="width: 100%;">
                <div style="display: flex; padding: 20px;" class="tableaa">
                    <div>id</div>
                    <div>上传时间</div>
                    <div>文件名</div>
                    <div>文件类型</div>
                    <div>操作</div>
                </div>
                <div v-for="table in tableData" style="display: flex; padding: 10px;" class="tableaa">
                    <div>{{ table.id }}</div>
                    <div>{{ table.filename }}</div>
                    <div>{{ table.uploadtime }}</div>
                    <div>{{ table.filetype }}</div>
                    <div>
                        <el-button type="primary" round @click="xz(table)">下载</el-button>
                        <el-button type="success" round @click="sc(table.id)">删除</el-button>
                    </div>


                </div>

            </div>
        </div>

    </div>
</template>



<style  scoped lang="scss">
@import '../../assets/back.scss';

.el-table .warning-row {
    --el-table-tr-bg-color: var(--el-color-warning-light-9);
}

.el-table .success-row {
    --el-table-tr-bg-color: var(--el-color-success-light-9);
}

/* .con_top_text_n {
    margin-top: 150px;
   
} */
.table {
    width: 100%;
}

.tablea {
    background-color: aliceblue;
    width: 70%;
    margin: auto;
    padding: 20px;
    border-radius: 20px;
}

.tableaa div {
    width: 33.333333%;
    text-align: center;
}
</style>