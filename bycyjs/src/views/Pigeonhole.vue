<script setup>

document.title = "归档"
</script>

<template>
  <div id="pigeonhole">
    <van-nav-bar class="title" title="归档"/>
    <div class="background">
      <div class="con_top_text">
        <div class="con_top_text_n">
          <div class="con_top_text_title">
            <span>归档</span>
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
        <div class="layui-timeline">
          <div class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis layui-icon-circle"></i>
            <div class="layui-timeline-content layui-text">
              <div class="layui-timeline-title">2023.8.4前几天把电脑装成liunx系统装不会win了</div>
            </div>
          </div>
          <div class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis layui-icon-circle"></i>
            <div class="layui-timeline-content layui-text">
              <div class="layui-timeline-title"><a href="#">2023.6.8创建学习记录目录</a></div>
            </div>
          </div>
          <div class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis layui-icon-circle"></i>
            <div class="layui-timeline-content layui-text">
              <div class="layui-timeline-title">测试完成</div>
            </div>
          </div>
          <div class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis layui-icon-circle"></i>
            <div class="layui-timeline-content layui-text">
              <div class="layui-timeline-title">2023年6月6日，测试。</div>
            </div>
          </div>
          <!-- <div class="layui-timeline-item">
              <i class="layui-icon layui-timeline-axis layui-icon-circle"></i>
              <div class="layui-timeline-content layui-text">
                  <div class="layui-timeline-title">2023年6月6日，测试。</div>
              </div>
          </div> -->
          <div class="layui-timeline-item">
            <i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
              <div class="layui-timeline-title">2023年6月6日把归档写了一部分。</div>
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
