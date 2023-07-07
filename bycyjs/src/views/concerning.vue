<script setup>

document.title="关于"
</script>

<template>
<div id="concerning">
    <div class="background">
            <div class="con_top_text">
                <div class="con_top_text_n">
                    <div class="con_top_text_title">
                        <span>关于</span>
                    </div>
                    <div class="con_top_text_title2">
                        <span>草色全经细雨湿，花枝欲动春风寒。</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="concerning">
            <div class="concerning_n">
                <div class="concerning_a">
                    <div class="concerning_t">
                        <a href="">
                            <div>文章</div>
                        </a>
                        <a href="">
                            <div>分类</div>
                        </a>
                        <a href="tab.html">
                            <div>标签</div>
                        </a>
                    </div>
                    <!-- <div class="concerning_img"><img src="../image/photogrtaph/刘浩.jpg" alt=""></div> -->
                    <div class="concerning_ico">
                        <div><img src="../../public/image/icon/icon_24rtwbfdje8/github.png" alt=""></div>
                        <div><img src="../../public/image/icon/icon_24rtwbfdje8/QQ.png" alt=""></div>
                        <div><img src="../../public/image/icon/icon_24rtwbfdje8/weixin.png" alt=""></div>
                        <div><img src="../../public/image/icon/icon_24rtwbfdje8/youxiang.png" alt=""></div>
                    </div>
                </div>
                <div class="concering_b">
                    <div>
                        <span>半夜才有精神</span>
                    </div>
                </div>
                <div class="concering_c">
                    <div>
                        <span>摸鱼程序员</span>
                    </div>
                </div>
                <div class="concering_d"><span>对未来真正的感慨，就是把一切都献给现在。</span></div>
                <div class="concering_e">
                    <div>
                        <img src="" alt="">
                        <span>我的技能</span>
                    </div>

                    <div class="concering_ea">
                      
                            <div>
                                <!-- <el-progress type="circle" :percentage="25"></el-progress> -->
                            </div>
                           
                        
                        <div>

                        </div>
                    </div>
                </div>
                <div >
                    <div>
                        <img src="" alt="">
                        <span>其他技能</span>
                    </div>

                </div>
                <div>
                    <div>
                        <img src="" alt="">
                        <span>相册</span>
                    </div>
                </div>

            </div>
        </div>
</div>
</template>

<style scoped lang="scss">
@import '../assets/back.scss';

body{
    background-color: #d4cece;
}
.concerning {
    width: 100%;
}

.concerning_n {
    width: 90%;
    background-color: rgb(255, 255, 255);
    margin: auto;
}

.concerning_a {
    display: flex;
    justify-content: space-around;
}

.concerning_t {
    display: flex;
}
.concerning_t div{
    margin: 1vw;
}

.concerning_img{
    transform: translate3d(0, -65%, 0);
}
.concerning_img img {
    max-height: 10vw;
    border: 1px solid #d4cece;
    border-radius: 50%;

}

.concerning_ico {
    display: flex;
}
.concerning_ico div{
    margin: 1vw;
}
.concerning_ico img{
    max-height: 3vw;
}
.concering_b{
    width: 100%;
}
.concering_b div span,
.concering_c div span
{
    display: block;
    text-align: center;
}
.concering_b div span{
    font-size: 3.5vw;
}
.concering_c{
    margin-top: 2vh;
}
.concering_c div span,
.concering_d span{
    font-weight: 200;
    font-size: 0.3vw;
    color: #a7a3a3;
}
.concering_d{
    margin-top: 5vh;
}
.concering_d span{
    display: block;
    text-align: center;
    font-size: 0.5vw;
}

.concering_e{
    width: 100%;
}
.concering_e div:nth-child(1) span{
    display: block;
    text-align: center;
}
.concering_ea{
    width: 100%;
}
.concering_ea div:nth-child(1){
    width: 30%;
    height: 3vw;
    /* background-color: yellow; */
}

</style>
