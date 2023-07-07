<script setup>
import {onMounted, ref} from 'vue'
import axios from '../../js/axiosInstance'
import {MoreFilled} from '@element-plus/icons-vue'

const activities = ref([
  {
    content: 'Custom icon',
    timestamp: '2018-04-12 20:46',
    size: 'large',
    type: 'primary',
    icon: MoreFilled,
  }])

onMounted(() => {
  axios({
    method: "get",
    url: "mdservice/findByFrontPager/1/5"
  }).then((resf) => {
    activities.value = resf.data.data.data
    console.log(activities)
    for (let i = 0; i < activities.length; i++) {
      activities[i].time = mds[i].time.slice(0, 10)
    }
    console.log(activities)
  }).catch((err) => {
    alert("出错了")
  })
})

function note(activity) {
  axios({
    method: "get",
    url: "mdservice/selectFront/" + activity.time + "/" + activity.filename
  }).then((resf) => {
    if (resf.data.code === 1) {
      //新打开一个页面（about:blank是打开浏览器空白页的命令）, _blank：打开一个新的窗口
      // var newPage = window.open("about:blank", "_blank");
      var newPage = window.open(activity.filename, activity.filename);
      //将后台传过来的html页面写到新打开的浏览器窗口中显示
      newPage.document.write(resf.data.data);
      newPage.document.title = activity.filename



    } else {
      alert("失败")
    }
  })
}
document.title="学习笔记"
</script>

<template>
  <div id="note">
    <div class="background">
      <div class="con_top_text">
        <div class="con_top_text_n">
          <div class="con_top_text_title">
            <span>学习笔记目录</span>
          </div>
          <div class="con_top_text_title2">
            <span>新的一天，新的开始</span>
          </div>
        </div>
      </div>
    </div>
    <!-- 时间线 -->
    <div class="pigeonhole">
      <div class="pigeonhole_n">
        <el-timeline>
          <el-timeline-item
              v-for="(activity, index) in activities"
              :key="index"
              :icon="activity.icon"
              :type="activity.type"
              :color="activity.color"
              :size="activity.size"
              :hollow="activity.hollow"
              :timestamp="activity.time"
          >
            <a href="#" @click="note(activity)"> {{ activity.filename }}</a>
          </el-timeline-item>
        </el-timeline>
      </div>


    </div>


  </div>
</template>

<style scoped lang="scss">
@import '../../assets/back.scss';

.pigeonhole {
  width: 100%;
  margin-top: 50px;
  margin-bottom: 50px;
}

.pigeonhole_n {

  width: 60%;
  margin: auto;
  padding: 50px;
  background-color: blanchedalmond;
  border-radius: 40px;

}
</style>
