//			提交不推荐号码
			$("#submit_button").on("click",function(){
            	$.ajax({
            		url: "/postBadNumber",
            		type:"post",
            		data : $("#postBadNumber").serialize(),
            		success: function(responseData){
            			alert(responseData);
            		}
            	});
        	});
//			提交开奖号码
			$("#submit_lottoNumber").on("click",function(){
            	$.ajax({
            		url: "/postLottoNumber",
            		type:"post",
            		data : $("#postLottoNumber").serialize(),
            		success: function(responseData){
            			alert(responseData);
            		}
            	});
        	});
//        	搜索框
        	$("#search").on("click",function(){
            	$.ajax({
            		url:"",
            		type:"",
            		success:function(responseDate){
            			alert("说了没用你不信");
            		}
            		
            	});
        	});
//        	获取开奖号码
        	function getLottoNumber() {
            	$.ajax({
            		url: "/getLottoNumber",
            		type:"get",
            		success: function(responseData){
//            			$("#time").text(responseData.time+1);
            			$("#lastTime").text(responseData.time);
            			$("#theTime").text(responseData.time);
//            			$("#lastBadTime").text(responseData.time+1);
            			$("#lottoBlueBall1").val(responseData.blueBall1);
            			$("#lottoBlueBall2").val(responseData.blueBall2);
            			$("#lottoBlueBall3").val(responseData.blueBall3);
            			$("#lottoBlueBall4").val(responseData.blueBall4);
            			$("#lottoBlueBall5").val(responseData.blueBall5);
            			$("#lottoRedBall1").val(responseData.redBall1);
            			$("#lottoRedBall2").val(responseData.redBall2);
            			
            			getTheBadNumber(responseData.time);
            			
            		}
            	});
        	}
//        	获取本期不推荐号码
        	function getBadNumber() {
            	$.ajax({
            		url: "/getBadNumber",
            		type:"get",
            		success: function(responseData){
            			$("#time").text(responseData.time);
            			$("#lastBadTime").text(responseData.time);
            			$("#badBlueBall1").val(responseData.blueBall1);
            			$("#badBlueBall2").val(responseData.blueBall2);
            			$("#badBlueBall3").val(responseData.blueBall3);
            			$("#badBlueBall4").val(responseData.blueBall4);
            			$("#badBlueBall5").val(responseData.blueBall5);
            			$("#badRedBall1").val(responseData.redBall1);
            			$("#badRedBall2").val(responseData.redBall2);
            		}
            	});
 
        	}
//        	获取制定期数的不推荐号码
        	function getTheBadNumber(time) {
            	$.ajax({
            		url: "/getTheBadNumber?time="+time,
            		type:"GET",
            		success: function(responseData){
            			$("#theBadBlueBall1").val(responseData.blueBall1);
            			$("#theBadBlueBall2").val(responseData.blueBall2);
            			$("#theBadBlueBall3").val(responseData.blueBall3);
            			$("#theBadBlueBall4").val(responseData.blueBall4);
            			$("#theBadBlueBall5").val(responseData.blueBall5);
            			$("#theBadRedBall1").val(responseData.redBall1);
            			$("#theBadRedBall2").val(responseData.redBall2);
            		}
            	});
        	};
        	
        	
//        	生成随机号码
        	$("#submit_usernumber").on("click",function(){
            	$.ajax({
            		url: "/getUserNumber",
            		type:"get",
            		success: function(responseData){
            			console.dir(responseData);
            			$("#userBlueBall1").val(responseData.blueBall1);
            			$("#userBlueBall2").val(responseData.blueBall2);
            			$("#userBlueBall3").val(responseData.blueBall3);
            			$("#userBlueBall4").val(responseData.blueBall4);
            			$("#userBlueBall5").val(responseData.blueBall5);
            			$("#userRedBall1").val(responseData.redBall1);
            			$("#userRedBall2").val(responseData.redBall2);
            			}
            		});
        		
        	});
        	
        	
//        	读取txt内容
        	function getUpdateLog() {
        		$.ajax({
        	        url: '/updatelog/updatelog.txt',
        	        dataType: 'text',
        	        success: function(data) {
        	            layer.alert(data,{title:"更新日志"});
        	        }
        	    });
			}
        
