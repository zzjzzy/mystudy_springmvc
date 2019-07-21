$(function(){
	$("#coalBtn").click(function(){
		loadData();
	});
})

function loadData(){
	$.ajax({
		type: "post",
		url: "/springmvc/study/json.action",
		async: true,
		data: {aaa: "手机"},
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: function(result){
			console.log(result.length);
		},
		error: function(xhr, textStatus, errorThrown){
			alert("碳核查基础数据加载失败");
		},
	})
}
