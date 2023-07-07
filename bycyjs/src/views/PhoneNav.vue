
<script setup>
import { onMounted } from 'vue'
import $ from "jquery"
$(()=>{
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

</script>
<template>
    <div id="phonenav">
        <van-nav-bar class="title" title="导航" />
        <div class="tab">
            <div class="tab_n">
                <div class="tab_content ">
                    <router-link to="#" class="router-test tab_text">
                        <span>java</span>
                    </router-link>
                    <router-link to="#" class="router-test tab_text">
                        <span>html</span>
                    </router-link>
                    <router-link to="#" class="router-test tab_text">
                        <span>前端笔记</span>
                    </router-link>
                    <router-link to="#" class="router-test tab_text">
                        <span>后端笔记</span>
                    </router-link>
                    <router-link to="#" class="router-test tab_text">
                        <span>js</span>
                    </router-link>
                    <router-link to="/webboard" class="router-test tab_text">
                        <span>留言板</span>
                    </router-link>
                    <router-link to="/function" class="router-test tab_text">
                        <span>功能</span>
                    </router-link>
                </div>
            </div>
        </div>
    </div>
</template>



<style scoped lang="scss">
@import '../assets/title.scss';

.tab {
    width: 100%;
    background-color: #d8d0d0;
  

}

.tab_n {
   
    width: 70vw;
    background-color: #ffffff;
    margin: auto;
    border: 1px solid #ccc;
    border-radius: 1.5vw;
    
}

.logtext {
    margin: auto;
    text-align: center;
    font-size: 2vw;
    margin: 2vw;
}

.tab_content {
    width: 70%;
    margin: auto;
    display: flex;
    flex-wrap: wrap;
    margin-top: 10vh;
}

.tab_content a {
    display: block;
    padding: 1vw;
    margin: 1vh;
    border: 1px solid #ccc;
    border-radius: 1.5vw;
    /* box-shadow: 1px 1px 1px rgba(255, 255, 255, 0.5); */

}

.tab_text span {
    font-size: 20px;

}

.logtext img {
    transform: rotateY(180deg);
    max-height: 3vw;
}
</style>
