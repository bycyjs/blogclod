<script lang="ts" setup>
import { RouterView } from 'vue-router'
import $ from "jquery"
import { startSakura } from '../js/wbjs/yinghua.js'
import { onMounted, ref } from "vue";

import { Tabbar, TabbarItem } from 'vant';

const active = ref('home');


onMounted(() => {
  startSakura()
})

</script>

<template>
  <div class="backgroundimg">

    <!-- 回到顶部 -->
    <div class="gobackto">
      <a href="#">
        <!-- <el-tooltip class="item" effect="dark" content="返回顶部" placement="top"> -->
        <img src="../../public/image/icon/返回顶部.png" alt="">
        <!-- </el-tooltip> -->
      </a>
    </div>
    <!--顶部导航栏-->
    <div class="navigation">
      <nav>
        <div class="navigation_sidebar">
          <a href="javascript:;" id="sidebbar">
            <img src="../../public/image/icon/菜单.png" alt="">
          </a>
        </div>
        <div class="navigation_log">
          <a href="index.html">半夜才有精神|个人博客 </a>
        </div>
        <div class="navigation_nav">
          <ul>
            <li class="icon_link">
              <router-link to="/" class="router-test">

                <div class="icon_link1">
                  <img src="../../public/image/icon/icon_2t92f13wu22/home.png" alt="">
                  首页
                </div>


              </router-link>
            </li>
            <li class="icon_link">
              <router-link to="/tab" class="router-test">

                <div class="icon_link1">
                  <img src="../../public/image/icon/标签_o.png" alt="">
                  标签
                </div>

              </router-link>

            </li>

            <li class="icon_link">
              <a href="html/taxon.html">
                <div class="icon_link1">
                  <img src="../../public/image/icon/icon_2t92f13wu22/quanlingyuguimo.png" alt="">
                  分类
                </div>

              </a>
            </li>
            <li class="icon_link">
              <router-link to="/pigeonhole" class="router-test">
                <div class="icon_link1">
                  <img src="../../public/image/icon/icon_2t92f13wu22/wendang.png" alt="">
                  归档

                </div>
              </router-link>
            </li>
            <li class="icon_link">
              <router-link to="/concerning" class="router-test">
                <div class="icon_link1">
                  <img src="../../public/image/icon/关于.png" alt="">
                  关于
                </div>

              </router-link>
            </li>

            <li class="icon_link">
              <router-link to="/webboard" class="router-test">
                <div class="icon_link1">
                  <img src="../../public/image/icon/icon_2t92f13wu22/weixin.png" alt="">
                  留言区
                </div>

              </router-link>
            </li>
            <li class="icon_link">
              <a href="html/friendlink.html">
                <div class="icon_link1">
                  <img src="../../public/image/icon/icon_2t92f13wu22/cylxr.png" alt="">
                  友链
                </div>

              </a>
            </li>
            <li class="icon_link">
              <a href="#" class="icon_jt">
                <div class="icon_link1 icon_jt">
                  <img src="../../public/image/icon/icon_2t92f13wu22/lianjie.png" alt="">
                  清单
                  <img class="icon_jiantou" src="../../public/image/icon/jiantoushang.png" alt="">
                  <div class="icon_jttsk icon_jt">
                    <div class="icon_zw">
                      <div class="icon_jt">
                        <a href="#">
                          <img src="../../public/image/icon/icon_2t92f13wu22/weixin.png" alt="">
                          碎语
                        </a>
                      </div>
                      <div class="icon_jt">
                        <router-link to="/function" class="router-test">
                          <img src="../../public/image/icon/连接.png" alt="">
                          功能
                        </router-link>
                      </div>
                    </div>


                  </div>
                </div>

              </a>
            </li>
            <li class="icon_link">
              <a href="">
                <div class="icon_link1">
                  <img src="../../public/image/icon/icon_2t92f13wu22/搜索.png" alt="">
                </div>
              </a>
            </li>
          </ul>
        </div>
      </nav>
    </div>
    <RouterView />
    <!--版权-->
    <div class="copyright">
      <div class="copyright_top">
        <div class="copyright_top_ti">
          <div>版权所有©2023半夜才有精神|个人主页|Welcome to here!</div>
          <div>xxxxxxxxxxxx</div>
        </div>
        <div class="copyright_top_log">
          <div><a href=""><img src="../../public/image/icon/icon_h9lil6qalut/github.png" alt=""></a></div>
          <div><a href=""><img src="../../public/image/icon/icon_h9lil6qalut/QQ.png" alt=""></a></div>
          <div><a href=""><img src="../../public/image/icon/icon_h9lil6qalut/weixin.png" alt=""></a></div>
          <div><a href=""><img src="../../public/image/icon/icon_h9lil6qalut/youxiang.png" alt=""></a></div>
        </div>
      </div>
      <div class="copyright_text">xxxxxxxxxxxxxxx</div>
      <div class="copyright_text">xxxxxxxxxxxxxxx</div>
    </div>
    <!-- 手机端底部导航栏 -->
    <van-tabbar v-model="active" class="phoneNav">
      <van-tabbar-item  icon="home-o">
        <router-link to="/home" class="router-test">
          主页
        </router-link>
      </van-tabbar-item>
      <van-tabbar-item  icon="apps-o">
        <router-link to="/tab" class="router-test">
         标签
        </router-link>
      </van-tabbar-item>
      <van-tabbar-item  icon="friends-o">
        <router-link to="/phonnav" class="router-test">导航</router-link>
      </van-tabbar-item>
      <van-tabbar-item  icon="setting-o">
        <router-link to="/pigeonhole" class="router-test"> 归档</router-link>
       </van-tabbar-item>
    </van-tabbar>

  </div>
</template>

<style scoped lang="scss">
* {
  margin: 0;
  padding: 0;

}


.backgroundimg {
  width: 100%;
  background: url("../../public/image/background.jpg") no-repeat;
  /* background-size: 100%; */
  background-attachment: fixed;
  background-position: center 0;
  background-size: cover;

}

/* 回到顶部 */
.gobackto {
  position: fixed;
  top: 80%;
  left: 90%;

  img {
    min-height: 1vh;
  }
}


/* 顶部导航栏 */
.navigation {
  padding: 20px;
  width: 100%;
  position: fixed;
  z-index: 998;
  @media screen and (max-device-width: 1000px){
    display: none;
  }
  .navigation_sidebar {
    display: none;

    img {
      max-height: 20px;
    }
  }

  .navigation_log {
    margin-left: 5%;
    @media screen and (max-device-width: 1000px){
      width: 100%;
      text-align: center;
      margin-left: 0;
    
    }
    a {
      color: #a0b6e3;
      font-size: 2vw;
      @media screen and (max-device-width: 1000px){
       font-size: 3vh;
      }
    }
  }

  nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  a {
    text-decoration: none;
  }

  .navigation_nav {
    ul {
      margin: auto 0;
      display: flex;

      a {
        color: #e085a2;
        font-size: 1vw;
      }
    }

    li {
      margin-right: 2vw;
    }

    .icon_link {
      img {
        max-height: 1.5vw;
      }

      /* 清单 */
      .icon_jttsk {

        width: 100%;
        position: fixed;
        z-index: 998;
        display: none;
      }

      .icon_link1:hover {
        .icon_jttsk {
          display: block;
        }
      }

      .icon_zw {
        padding-top: 2.5vw;

        div {
          margin: 0;
          padding: 0.5vw;
        }
      }


    }
    @media screen and (max-device-width: 1000px){
      display: none;
    }
  }

}


/* 背景，只占一个页面 */
.background {
  width: 100%;
  background: url("../../public/image/background.jpg") no-repeat;
  background-size: cover;
}

/* 版权 */
.copyright {
  background-color: rgba(198, 190, 241, 0.5);

  .copyright_top {
    display: flex;
    justify-content: space-between;
    margin-left: 10%;
    margin-right: 10%;

    .copyright_top_log {
      margin-top: 2vh;
      display: flex;

      img {
        margin-left: 2vw;
        max-height: 3vh;
      }
    }

    .copyright_top_ti {
      div {
        margin-top: 2vw;
      }
    }

    .copyright_text {
      margin-top: 2vh;
      margin-left: 10%;
      margin-right: 10%;
    }

  }
  @media screen and (max-device-width:1000px) {
    display: none;
  }

}
// 手机端导航
.phoneNav{
  display: none;
  @media screen and (max-device-width: 1000px) {
      display: block;
      display: flex;
     
      
  }
}

</style>
