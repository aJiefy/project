

$(function(){
	
	
	$.get("/Lafite/WineServlet?cmd=0",function(data,status){
		 //alert(data);
		var jsonObj = eval("("+data+")");
		console.debug("list.length="+jsonObj.length);
		var html="";
	    for ( var i = 0; i < jsonObj.length; i++) {
			html += "<li style='width: 330px; float:left; margin: 15px 15px; list-style: none;'>" +
						"<figure id='filterFigure'>" +
						"<a href='/Lafite/WineServlet?detail="+jsonObj[i].wINE_ID+"' data-contenturl='portfolio-post.html' data-callback='callPortfolioScripts();' data-contentcontainer='.pcw'>" +
						"<div class='text-overlay' style='margin: 0px 0 0 0;'>" +
							"<p id='filterTitle01'>"+jsonObj[i].wINE_NAME+"</p><br/>" +
							"<p id='filterContent'>▶&nbsp;点击了解更多内容&nbsp;</p>" +
						"</div><br/>" +
						"<img id='filterImage' src='" +jsonObj[i].wINE_IMG+ "' alt='' /><br/>" +
						"<p id='filterTitle02'><i><b>"+jsonObj[i].wINE_NAME+"</b></i></p><br/>" +
						"</a>" +
						"</figure>" +
					"</li>";
			
			$("#filterUL").html(html);
			
			
			
			
		}
		
	  });
});

	
function Wineall(){


	$.get("/Lafite/WineServlet?cmd=0",function(data,status){
		 
		
		var jsonObj=eval("("+data+")");
		console.debug(jsonObj.length);
		var html="";
	    for ( var i = 0; i < jsonObj.length; i++) {
			html += "<li style='width: 330px; float:left; margin: 15px 15px; list-style: none;'>" +
						"<figure id='filterFigure'>" +
						"<a href='/Lafite/WineServlet?detail="+jsonObj[i].wINE_ID+"' data-callback='callPortfolioScripts();' data-contentcontainer='.pcw'>" +
						"<div class='text-overlay' style='margin: 0px 0 0 0;'>" +
							"<p id='filterTitle01'>"+jsonObj[i].wINE_NAME+"</p><br/>" +
							"<p id='filterContent'>▶&nbsp;点击了解更多内容&nbsp;</p>" +
						"</div><br/>" +
						"<img id='filterImage' src='" +jsonObj[i].wINE_IMG+ "' alt='' /><br/>" +
						"<p id='filterTitle02'><i><b>"+jsonObj[i].wINE_NAME+"</b></i></p><br/>" +
						"</a>" +
						"</figure>" +
					"</li>";
			
			$("#filterUL").html(html);
			
			
			
			
		}
		
	  });
};


function Winecq(){
	var winecq = $("#winecq").val();
	
	
	$.get("/Lafite/WineServlet?cmd=1",function(data,status){
	    
		
		var jsonObj=eval("("+data+")");
		console.debug(jsonObj.length);
		var html="";
	    for ( var i = 0; i < jsonObj.length; i++) {
			html += "<li style='width: 330px; float:left; margin: 15px 15px;list-style: none;'>" +
						"<figure id='filterFigure'>" +
						"<a href='/Lafite/WineServlet?detail="+jsonObj[i].wINE_ID+"' data-contenturl='portfolio-post.html' data-callback='callPortfolioScripts();' data-contentcontainer='.pcw'>" +
						"<div class='text-overlay' style='margin: 0px 0 0 0;'>" +
							"<p id='filterTitle01'>"+jsonObj[i].wINE_NAME+"</p><br/>" +
							"<p id='filterContent'>▶&nbsp;点击了解更多内容&nbsp;</p>" +
						"</div><br/>" +
						"<img id='filterImage' src='" +jsonObj[i].wINE_IMG+ "' alt='' /><br/>" +
						"<p id='filterTitle02'><i><b>"+jsonObj[i].wINE_NAME+"</b></i></p><br/>" +
						"</a>" +
						"</figure>" +
					"</li>";
			
			$("#filterUL").html(html);
			
			
			
			
		}
		
	  });
};


function Winecs(){
	var winecq = $("#winecs").val();
	
	
	$.get("/Lafite/WineServlet?cmd=2",function(data,status){
	    
		
		var jsonObj=eval("("+data+")");
		console.debug(jsonObj.length);
		var html="";
	    for ( var i = 0; i < jsonObj.length; i++) {
			html += "<li style='width: 330px; float:left; margin: 15px 15px;list-style: none;'>" +
						"<figure id='filterFigure'>" +
						"<a href='/Lafite/WineServlet?detail="+jsonObj[i].wINE_ID+"' data-contenturl='portfolio-post.html' data-callback='callPortfolioScripts();' data-contentcontainer='.pcw'>" +
						"<div class='text-overlay' style='margin:0px 0 0 0;'>" +
							"<p id='filterTitle01'>"+jsonObj[i].wINE_NAME+"</p><br/>" +
							"<p id='filterContent'>▶&nbsp;点击了解更多内容&nbsp;</p>" +
						"</div><br/>" +
						"<img id='filterImage' src='" +jsonObj[i].wINE_IMG+ "' alt='' /><br/>" +
						"<p id='filterTitle02'><i><b>"+jsonObj[i].wINE_NAME+"</b></i></p><br/>" +
						"</a>" +
						"</figure>" +
					"</li>";
			
			$("#filterUL").html(html);
			
			
			
			
		}
		
	  });
};

function Winezc(){
	var winecq = $("#winecq").val();
	
	
	$.get("/Lafite/WineServlet?cmd=3",function(data,status){
	    
		
		var jsonObj=eval("("+data+")");
		console.debug(jsonObj.length);
		var html="";
	    for ( var i = 0; i < jsonObj.length; i++) {
			html += "<li style='width: 330px; float:left; margin: 15px 15px;list-style: none;'>" +
						"<figure id='filterFigure'>" +
						"<a href='/Lafite/WineServlet?detail="+jsonObj[i].wINE_ID+"' data-contenturl='portfolio-post.html' data-callback='callPortfolioScripts();' data-contentcontainer='.pcw'>" +
						"<div class='text-overlay' style='margin: 0px 0 0 0;'>" +
							"<p id='filterTitle01'>"+jsonObj[i].wINE_NAME+"</p><br/>" +
							"<p id='filterContent'>▶&nbsp;点击了解更多内容&nbsp;</p>" +
						"</div><br/>" +
						"<img id='filterImage' src='" +jsonObj[i].wINE_IMG+ "' alt='' /><br/>" +
						"<p id='filterTitle02'><i><b>"+jsonObj[i].wINE_NAME+"</b></i></p><br/>" +
						"</a>" +
						"</figure>" +
					"</li>";
			
			$("#filterUL").html(html);
			
			
			
			
		}
		
	  });
};


function Winezn(){
	var winecq = $("#winecq").val();
	
	
	$.get("/Lafite/WineServlet?cmd=4",function(data,status){
	    
		
		var jsonObj=eval("("+data+")");
		console.debug(jsonObj.length);
		var html="";
	    for ( var i = 0; i < jsonObj.length; i++) {
			html += "<li style='width: 330px; float:left; margin: 15px 15px;list-style: none;'>" +
						"<figure id='filterFigure'>" +
						"<a href='/Lafite/WineServlet?detail="+jsonObj[i].wINE_ID+"' data-contenturl='portfolio-post.html' data-callback='callPortfolioScripts();' data-contentcontainer='.pcw'>" +
						"<div class='text-overlay' style='margin:0px 0 0 0;'>" +
							"<p id='filterTitle01'>"+jsonObj[i].wINE_NAME+"</p><br/>" +
							"<p id='filterContent'>▶&nbsp;点击了解更多内容&nbsp;</p>" +
						"</div><br/>" +
						"<img id='filterImage' src='" +jsonObj[i].wINE_IMG+ "' alt='' /><br/>" +
						"<p id='filterTitle02'><i><b>"+jsonObj[i].wINE_NAME+"</b></i></p><br/>" +
						"</a>" +
						"</figure>" +
					"</li>";
			
			$("#filterUL").html(html);
			
			
			
			
		}
		
	  });
};