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