
// 判断页面是否在顶端
$(window).on('scroll', function () {
    "use strict";
    var scrolled = $(window).scrollTop();
    if (scrolled > 100) {
        $(".navigation").css("background-color", "rgba(198, 190, 241, 0.5)");

    } else {
        $(".navigation").css("background-color", "");
    }
});


// 清单箭头
$(".icon_jttsk").hide();
// console.log("testicon")
$(".icon_jt").hover(function () {
        // over
        $(".icon_jiantou").attr("src", "image/icon/jiantouxia.png");
        $(".icon_jttsk").show();
    }, function () {
        // out
        $(".icon_jiantou").attr("src", "image/icon/jiantoushang.png");
        $(".icon_jttsk").hide();
        

    }
);