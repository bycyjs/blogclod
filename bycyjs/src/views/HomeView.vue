<script setup>
import { ref, toRefs, reactive, createApp, onMounted } from 'vue'
import $ from 'jquery'

const tabss = ref([
  {
    span: "笔记",
    h1: "前端笔记",
    span1: "笔记目录",
    aurl: "html/md/learnnote/catalog.html",



  }, {
    span: "笔记",
    h1: "后端学习笔记",
    span1: "笔记目录",
    aurl: "test",

  }
])
const background = ref([
  "/image/divbackground/1.jpeg",
  "/image/divbackground/2.jpg",
  "/image/divbackground/3.png",
  "/image/divbackground/4.jpg",
  "/image/divbackground/5.png",
  "/image/divbackground/6.png",
  "/image/divbackground/7.png",
  "/image/divbackground/8.png",
])

const divimg = ref({
  background: 'url(' + background.value[1] + ') no-repeat',
  backgroundSize: 'cover'
})

onMounted(() => {

})


document.title = "主页"
</script>

<template>
  <div id="index">
    <div class="background">
      <van-nav-bar class="title" title="主页" />


      <div class="con_top_text">
        <div class="con_top_text_n">

          <div class="con_top_text_title">
            <span>半夜才有精神</span>
          </div>


          <div class="con_top_text_title2">
            <span>新的一天，新的开始</span>
          </div>
          <div class="con_top_text_btu">
            <div class="con_top_text_btu1">
              <a href="javascript:;">
                <img src="../../public/image/icon/箭头_页面_向下_o.png" alt="">
                开始阅读
              </a>
            </div>
            <div class="con_top_text_btu2">
              <a href="javascript:;">
                <img src="../../public/image/icon/icon_h9lil6qalut/QQ.png" alt="">
                QQ
              </a>
            </div>
          </div>
          <div class="con_top_text_log">
            <ul>
              <li>

                <a href="#" class="con_top_text_log_github">
                  <el-tooltip class="box-item" effect="dark" content="访问我的GitHub" placement="top">
                    <img src="../../public/image/icon/icon_h9lil6qalut/github.png" alt="">
                  </el-tooltip>
                </a>

              </li>
              <li>
                <a href="#" class="con_top_text_log_youxing">
                  <el-tooltip class="box-item" effect="dark" content="邮件联系我" placement="top">
                    <img src="../../public/image/icon/icon_h9lil6qalut/youxiang.png" alt="">
                  </el-tooltip>

                </a>
              </li>
              <li>
                <a href="#" class="con_top_text_log_qq">
                  <el-tooltip class="box-item" effect="dark" content="QQ联系我：704812528" placement="top">
                    <img src="../../public/image/icon/icon_h9lil6qalut/QQ.png" alt="">
                  </el-tooltip>

                </a>
              </li>
              <li>

                <a href="#" data-title="删除删除删除">
                  <el-tooltip class="box-item" effect="dark" content="微信扫一扫" placement="top">
                    <router-link to="weixing" class="router-test tab_text">
                      <img src="../../public/image/icon/icon_h9lil6qalut/weixin.png" alt="">
                    </router-link>
                  </el-tooltip>

                </a>
              </li>
            </ul>
          </div>
        </div>

      </div>

    </div>

    <div class="content">
      <div class="content_top">
        <div class="content_top_title">
          <div>
            <img src="" alt="">
            <h1>理想的自己</h1>
          </div>
        </div>
        <div class="content_top1">
          洋葱、萝卜和西红柿不相信世界上有南瓜这种东西， 它们认为那是一种空想。 南瓜不说话， 默默地生长。 —— 于尔克•舒比格
        </div>
        <div class="content_top2">
          人的一生， 其实就是一场自己对自己的战争。 每个人的身上，都有两个自己：
          好的自己和坏的自己。让积极打败消极，让高尚打败鄙陋，让真诚打败虚伪，让宽容打败计较，让快乐打败忧郁，让勤奋打败懒惰，让坚强打败脆弱。 只要你愿意，完全可以一辈子都做最好的自己。
        </div>
      </div>
      <div class="content_mid">
        <div class="content_top_title">
          <div>
            <img src="" alt="">
            <h1>公告</h1>
          </div>
        </div>
        <div class="content_mid_content">
          本博客所发布的各种软件文章仅限用于学习和研究目的；任何人不得将上述内容用于商业或者非法用途，否则，一切后果请用户自负。本站信息来自网络，版权争议与本站无关。您必须在下载后的24个小时之内，从您的电脑中彻底删除上述内容。如果您喜欢该程序，请支持正版软件，购买注册，得到更好的正版服务。如有侵权请邮件与我联系处理。
        </div>
      </div>
      <div class="content_next">
        <div class="content_top_title">
          <div>
            <img src="" alt="">
            <h1>推荐文章</h1>
          </div>
        </div>
        <div class="content_next_content_w">
          <div class="content_next_content">
            <div class="content_next_content0">

              <div v-for="tab in tabss" :style="divimg" class="content_next_content1 essay">

                <div class="essay_a">
                  <span>{{ tab.span }}</span>
                </div>
                <div class="essay_b">
                  <h1>{{ tab.h1 }}</h1>
                </div>

                <div class="essay_c">
                  <span>
                    {{ tab.span1 }}
                  </span>
                </div>
                <div class="essay_d">
                  <a href="#">阅读更多</a>
                </div>



              </div>
            </div>
          </div>
        </div>

      </div>
    </div>
    <div class="last">
      <div class="last_external">

        <div class="lasta">
          <a href="#">
            <div class="last_a">
              <h1>某小程序加密逻辑解析</h1>
            </div>
            <div class="last_b">
              <div class="last_c">
                <p>
                  前言近期学校开始让在外实习的，每天都得打卡校友邦，再加上外地朋友也由于种种原因要回学校，但还要打卡，就开始研究了这个东西，但是呢以前写过，回过头跑程序发现报错，估摸着那边改了或者加了防护，前面签到啥的接口没什么好提的，没啥难度，这次记录的是
                </p>
              </div>
              <div class="last_d">
                <span>20xx-3-5</span>
                <span>半夜才有精神</span>
              </div>
              <hr>
              <div class="last_e">
                <div>
                  <span>java</span>
                </div>

              </div>
            </div>
          </a>
        </div>

      </div>

    </div>

  </div>
</template>

<style scoped lang="scss">
@import '../assets/back.scss';
@import '../assets/title.scss';


.con_top_text_btu {
  margin-top: 30%;
  display: flex;
  justify-content: space-between;
  height: 4vh;

}

.con_top_text_btu a {
  display: block;
  padding: 1vw;
  @media screen and (max-device-width:1000px) {
    padding: 6vh;
    color: #ffffff;
  }
}

.con_top_text_btu a img {
  height: 2vh;
}



.con_top_text_btu a:hover {
  border: 1px solid #ccc;
  border-radius: 1.5vw;
  box-shadow: 1px 1px 1px rgba(255, 255, 255, 0.5);
  color: rgb(0, 0, 0);

}


.con_top_text_log {
  margin-top: 40%;
}

.con_top_text_log ul {
  display: flex;
  justify-content: space-around;
}



.con_top_text_log img {
  max-height: 4vh;
}

.content {
  margin-top: 0.5vh;
  width: 80%;
  margin-left: 10%;
  border: 1px solid #d4cece;
  background-color: #fdfdfd;
  border-radius: 1.5vw;
}

.content_top_title,
.content_top1,
.content_top2 {
  margin-top: 2vh;
}

.content_top_title {
  display: flex;
  justify-content: space-around;
}

.content_top1,
.content_top2,
.content_mid_content {
  width: 60%;
  margin-left: 20%;
  font-size: 2vw;
  text-align: center;
  padding: 1vw;
  @media screen and (max-device-width:1000px){
    font-size: 2vh;
  }

}

.content_mid_content {
  color: #ff0000;
}

.content_next_content_w {
  display: flex;
  justify-content: space-around;
}

.content_next_content {
  min-height: 0;
  width: 90%;

}

.content_next_content0 {
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
@media screen and (max-device-width:1000px) {
  display: block;
}
}

.essay {
  /* background-color: #ff0000; */
  margin: 1vw;
  width: 45%;
  /* min-width: 409.74px; */
  /* height: 40vh; */
@media screen and (max-device-width:1000px){
  width: 95%;
}
}

.essay_a {
  margin-top: 7%;
  width: 100%;

}

.essay_a span {
  display: block;
  text-align: center;
}



.essay_b {
  margin-top: 3%;
  width: 100%;

}

.essay_b h1 {
  text-align: center;
}

.essay_c {
  margin-top: 10%;
  width: 100%;

}

.essay_c span {
  display: block;
  text-align: center;
}

/* 阅读更多按钮 */

.essay_d {
  margin-top: 5%;
  width: 100%;
  height: 20%;
  /* margin: auto 0; */
}

.essay_d a {

  display: block;
  margin: 0 auto;
  background-color: rgba(194, 245, 221, 0.7);
  text-align: center;
  width: 30%;
  height: 100%;
  line-height: 50px;
  border: 1px solid rgba(194, 245, 221, 0.5);
  border-radius: 20px;
}

.last_external {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  padding: 5vw;
  @media screen and (max-device-width:1000px){
    display: block;
  }
}


.last_external .lasta {
  width: 25vw;
  /* height: 40vh; */
  background-color: rgb(255, 255, 255);
  margin: 0.5vw;
  @media screen and (max-device-width:1000px){
    width: 95%;
  }

}

.essay {
  border-radius: 2vw;
}

.lasta {
  border-radius: 1.5vw;
}

.last_a {

  width: 100%;
  background-color: #4dcbcb;
  height: 20vh;
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  border-radius: 1.5vw 1.5vw 0 0;
}

.last_a h1 {

  font-size: 1.5vw;
  display: block;
  text-align: center;

}

.last_c {
  padding-top: 1vw;
}

.last_c p {
  width: 100%;
  overflow: hidden;
  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
  border-style: none;
  font-size: 1vw;

}

.last_b {
  width: 95%;
  margin: auto;
}

.last_d {
  display: flex;
  justify-content: space-between;
  padding-top: 1vw;
}

.last_d span {
  display: block;
}

.last_e {
  display: flex;
}

.last_e div {
  background-color: #4dcbcb;
  border: 1px solid #4dcbcb;
  border-radius: 4vw;
  padding: 0.2vw;
  margin: 0.2vw;
}

.last_e div span {
  font-size: 1vw;
}</style>
