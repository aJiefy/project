

$("#a2").click(function () {
/*        var $goodsCount = parseInt($("#inputcss").val());
        $goodsCount = $goodsCount + 1;

        $("#inputcss").val($goodsCount);*/
	alert("1");
});

$("#a1").click(function () {
/*        var $goodsCount = parseInt($("#inputcss").val());
        $goodsCount = $goodsCount - 1;
        $("#inputcss").val($goodsCount);
        if ($goodsCount == 0) {
            $("#inputcss").val("1");
        }*/
});

$("#inputcss").bind("input", function () {
        if ($("#inputcss").val() == "") {
            $("#inputcss").val() = "abc";
            alert("1");
        }
});

$("#a3").click(function () {
	//alert(123);
	var name = $("#name").text();
	var winenumber = $("#inputcss").val();
	var img = $("#img").val();
	var money = $("#money").text();
	console.debug("name="+name);
	$.post("/Lafite/cartServlet?cmd=addItems", { "winenumber": winenumber , "money": money , "img": img , "name": name} );
});