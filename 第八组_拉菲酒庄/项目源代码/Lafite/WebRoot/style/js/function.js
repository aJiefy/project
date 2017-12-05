
$(function(){
	//alert(123);
	
	//transmit username to cart
//	$("#mycart").bind("click",function(){
//		var name = $("#username").text();
//		console.debug("username="+name);
//		
//		$.post("cartServlet",{  //post不用写上下文
//			"name":name
//			
//		},function(data,status){
//	        //alert("Data: " + data + ",Status: " + status);
//			
//	    });
//		
//	});
	
	
	
	
	
	
	
});



function login(){
	window.location.href="login.jsp";
}




//验证码
function changeRandomCode(){
//    alert(1);
    document.getElementById("randomCodeImg").src="/Lafite/randomCode?"+new Date().getTime();//idea 不用写上下文

}

//检查账号是否存在
function checkUsername() {
	//alert(123);
	var username = $("#form-username").val();
	console.debug(username);
	
	
	 $.post("/Lafite/userServlet?cmd=ifExistUser",
	    {
			"username":username,
	    },
	        function(data,status){
	        //alert("数据: \n" + data + "\n状态: " + status);
	        $("#tip").text(data);
	    });
}

//检查电话是否存在
function checkUserTel() {
	//alert(123);
//	var tel = $("#form-tel").val();
//	console.debug(tel);
//	
//	
//	 $.post("/lafite/userServlet?cmd=checkTel",
//	    {
//			"tel":tel,
//	    },
//	        function(data,status){
//	        //alert("数据: \n" + data + "\n状态: " + status);
//	        $("#tipTel").text(data);
//	    });
}

