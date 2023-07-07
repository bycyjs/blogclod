<script setup>
import {onMounted, reactive, ref} from 'vue'
import axios from '../js/axiosInstance'

const WebBoard = reactive({
  userName: "",
  emil: "",
  webUrl: "",
  content: "",
})

const liuyan = ref({})
const page = ref()
const ys = ref(5)
/*默认加载5条留言*/
onMounted(() => {
  console.log("test")
  axios({
    method: 'get',
    url: "commentservice/findByCommentPager/1/5",
  }).then((result) => {
    liuyan.value = result.data.data
    page.value = result.data.data.total
    console.log(liuyan.value)
  }).catch((err) => {
    alert("加载留言失败")
  });
})

/*加载更多留言*/
function more() {
  if (ys.value < page.value) {
    ys.value = ys.value + 5;
    axios({
      method: 'get',
      url: "commentservice/findByCommentPager/1/" + ys.value,
    }).then((result) => {
      liuyan.value = result.data.data
      page.value = result.data.data.total
      console.log(liuyan.value)
    }).catch((err) => {
      alert("出错了")
    });
  } else {
    alert("没有留言")
  }
}

/*发表留言*/
function submit() {
  if (WebBoard.userName != null && WebBoard.userName != '') {
    if (WebBoard.content != null && WebBoard.content != '') {
      axios({
        method: "post",
        url: "commentservice/addComment",
        data: {
          username: WebBoard.userName,
          emil: WebBoard.emil,
          webUrl: WebBoard.webUrl,
          content: WebBoard.content
        }
      }).then((result) => {
        if (result.data.code === 1) {
          alert("留言发表成功")
        } else {
          alert("发表留言失败")
        }
      }).catch((err) => {

      })
    } else {
      alert('请输入留言')
    }
  } else {
    alert("请输入姓名")

  }
}
document.title="留言板"
</script>

<template>
  <div id="webBoard">
    <div class="background">
      <div class="con_top_text">
        <div class="con_top_text_n">
          <div class="con_top_text_title">
            <span>留言板</span>
          </div>
          <div class="con_top_text_title2">
            <span>新的一天，新的开始</span>
          </div>
        </div>
      </div>
    </div>
    <div class="webBoard">
      <div class="webBoard_n">
        <div class="webBoard_text">
          <div class="webBoard_text_log">
            <img src="../../public/image/icon/微信.png" alt="">
            <span>留言板</span>
          </div>
          <div class="webBoard_text_span">
            <span>欢迎大家到在此随意谈吐，我会认真回复</span>
          </div>
          <div>

          </div>
        </div>


      </div>
      <div class="reply">
        <van-nav-bar class="title" title="留言" />
        <div class="reply_n">
          <div class="logreply">
            <img src="../../public/image/icon/微信.png" alt="">
            <span>留言</span>
          </div>
          <div class="reply_textframe">

            <div class="reply_text">
              <div class="reply_text_input">
                <div>
                  <input class="top_input" v-model="WebBoard.userName" type="text"
                         placeholder="昵称/QQ号（必填）" @input="testa()">
                </div>
                <div>
                  <input class="top_input" v-model="WebBoard.emil" type="email" name="" id=""
                         placeholder="请输入邮箱">
                </div>
                <div>
                  <input class="top_input" v-model="WebBoard.webUrl" type="text"
                         placeholder="网站（https：//）">
                </div>

              </div>
              <div class="reply_text_c">
                <textarea v-model="WebBoard.content" placeholder="在这里输入评论"></textarea>
                <div class="but">
                  <button @click="submit()">发表</button>
                </div>
              </div>
            </div>


          </div>
          <div class="portrait">
            <div class="portrait_n">
              <div class="portrait_tx">
                <img src="" alt="" class="portrait_img">
              </div>
            </div>

          </div>
          <div class="comment">
            <div class="comment_n">
              <div class="comment_title">
                <span>留言</span>
              </div>
              <div class="write_up">
                <div class="write_up_leirong">
                  <li v-for=" ly in liuyan.data">
                    <div class="write_up_leirong_top">

                      <img class="write_img" src="#" alt="">
                      <div class="write_up_leirong_n">
                        <span>{{ ly.username }}</span>
                      </div>
                      <div class="write_up_leirong_time">
                        <span>{{ ly.time }}</span>
                      </div>
                    </div>

                    <div class="write_up_leirong_dh">

                      <div class="write_up_leirong_lr">
                        <span>{{ ly.content }}</span>
                      </div>

                    </div>
                    <div class="write_up_img">
                      <div class="praise">
                        <img src="../../public/image/icon/dianzan.png" alt="">
                        <span>{{ ly.praise }}</span>
                      </div>
                      <div class="tread">
                        <img src="../../public/image/icon/cai.png" alt="">
                        <span>{{ ly.tread }}</span>
                      </div>
                    </div>
                  </li>
                  <button @click="more()" class="more">加载更多评论</button>

                </div>
              </div>
            </div>
          </div>
        </div>


      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
@import '../assets/back.scss';
@import '../assets/title.scss';
.webBoard {
  width: 100%;
  background-color: #d8d0d0;
}

.webBoard_n {
  position: relative;
  bottom: 5vw;
  width: 85vw;
  background-color: #ffffff;
  margin: auto;
  border: 1px solid #ccc;
  border-radius: 1.5vw;
}

.webBoard_text {
  width: 100%;
}

.webBoard_text_log {
  margin: auto;
  text-align: center;
  font-size: 2vw;
  margin: 2vw;
}

.webBoard_text_log img {
  max-height: 3vw;
}

.webBoard_text_span {
  margin: auto;
  text-align: center;
  font-size: 1.5vw;
}

.reply {
  width: 100%;
  margin-top: 2vh;
}

.reply_n {

  width: 85%;
  background-color: #ffffff;
  margin: auto;

  border: 1px solid #ccc;
  border-radius: 1.5vw;

}


.logreply img {
  max-height: 3vw;

}


.logreply span {
  font-weight: 1000;
  font-size: 1.5vw;
}

.reply_textframe {
  width: 90%;
  margin: auto;
  border: 1px solid rgb(0, 0, 0, 0.1);

}

.reply_text {
  width: 100%;
}

.reply_text_input {
  width: 100%;
  display: flex;

}

.reply_text_input div {
  width: 33.3%;
  height: 15vh;
  border-style: none none dashed none;
  border-color: rgba(0, 0, 0, 0.1);
}

.reply_text_input input {
  border: none;
  width: 100%;
  height: 100%;
  font-size: 1vw;
}

.reply_text_input input::-webkit-input-placeholder {
  font-size: 1vw;
}

.reply_text_c {
  width: 100%;
  height: 10vw;
}

.reply_text_c textarea {
  border: none;
  width: 100%;
  height: 80%;
  font-size: 4vw;
}

.reply_text_c textarea::-webkit-input-placeholder {
  font-size: 4vw;
}

.but button {
  display: block;
  margin-left: auto;
  background-color: #d8d0d0;
  width: 9vh;

}

/* qq头像 */
.portrait {
  width: 100%;

}

.portrait_n {
  width: 50%;
  margin: auto;
}

.portrait_tx {
  margin: auto;
}

.portrait_tx img {
  display: block;
  margin: auto;
}

/* 留言 */
.comment {
  width: 100%;

}

.comment_n {
  width: 85%;
}

.comment_title span {
  font-size: 2vw;
  font-weight: 1000;
}

/* 评论 */
.write_up {
  width: 100%;
}

.write_up_leirong {
  width: 80%;
  margin: auto;
  /* display: flex; */
}

.write_up_leirong li {
  display: flex;
  margin-top: 20px;
  background-color: bisque;
  border-radius: 20px;
  /* min-width: 300px; */

}

.write_up_leirong_top {
  margin-left: 10px;
  margin-right: 40px;
}

.write_up_leirong_time span {
  background-color: #5bdddd;
  border-radius: 20px;
  /* line-height: 50px; */
  text-align: center;
}

/* 对话框 */
/* 留言 */

.write_up_leirong_dh {
  min-width: 100px;
  height: 50px;
  border-radius: 10px;
  background-color: aquamarine;
  position: relative;
  /* margin-left: 80px; */
  /* padding-left: 30px; */

}

.write_up_leirong_dh::before {
  position: absolute;
  top: 15px;
  left: -20px;
  content: '';
  width: 0;
  height: 0;
  border-right: 10px solid aquamarine;
  border-bottom: 10px solid transparent;
  border-left: 10px solid transparent;
  border-top: 10px solid transparent;
}

.write_up_img {
  display: flex;
}

.write_up_img > div > img {
  background-color: #5bdddd;
}

.write_up_leirong_n {
  font-size: 1px;
}

.write_up_leirong_time {
  color: #ff0000;
  font-size: 1px;
}

.write_up_leirong_dh {
  margin: auto 0;
}

.write_up_leirong_lr span {
  line-height: 50px;
  text-align: center;
}

/* 加载更多评论 */
.more {

  display: block;
  margin: auto;
  padding: 20px;
  border: none;
  border-radius: 20px;
  background-color: #b9e8cc;
  margin-top: 20px;
  margin-bottom: 20px;

}

.write_up_img{
  padding: 20px;
}
/*点赞图片*/
.write_up_img div img{
  border-radius: 20px;
}
</style>
