

	$(function() {
		$("#getSSNPost").click(getSSN);
		$("#updateSSNPost").click(updateSSNPost);
		$("#updateSSNArea").hide();
		$("#getSSNArea").hide();
	  }
	);
	
	function getSSN(){
		$("#getSSNArea").hide();
		$("#getSSNAreaText").html("get...");
		$.ajax({
			url:"efoxsfcSSNSTATUS/"+$("#strPlantCodeGet").val()+"/"+$("#strSSNGet").val(),
			type:"GET",
			dataType:"text",
			success:function(result){
				$("#getSSNAreaText").html(result);
				$("#getSSNArea").show();
			},
			error:function(){
				$("#getSSNAreaText").html("error ,please check the log");
				$("#getSSNArea").show();
			}
		});
	}
	
	function updateSSNPost(){
		$("#updateSSNArea").hide();
		$("#updateSSNAreaText").html("post...");
		$.ajax({
			url:"efoxsfcSSNSTATUS",
			type:"POST",
			contentType:"application/json;charset=utf-8",
			dataType:"text",
			data:"{"+
			"\"strPlantCode\":\""+$("#strPlantCode").val()+"\","+
			"\"strSSN\":\""+$("#strSSN").val()+"\","+
			"\"strFixtureID\":\""+$("#strFixtureID").val()+"\","+
			"\"strTestResult\":\""+$("#strTestResult").val()+"\","+
			"\"strErrorCode\":\""+$("#strErrorCode").val()+"\","+
			"\"strFailDetailReason\":\""+$("#strFailDetailReason").val()+"\","+
			"\"strTestDatatime\":\""+$("#strTestDatatime").val()+"\","+
			"\"strEMPID\":\""+$("#strEMPID").val()+"\","+
			"\"strDIAG\":\""+$("#strDIAG").val()+"\","+
			"\"strCurStation\":\""+$("#strCurStation").val()+"\","+
			"\"strLineName\":\""+$("#strLineName").val()+"\","+
			"\"strField1\":\""+$("#strField1").val()+"\","+
			"\"strField2\":\""+$("#strField2").val()+"\","+
			"\"strField3\":\""+$("#strField3").val()+"\","+
			"\"strActionCode\":\""+$("#strActionCode").val()+"\","+
			"\"strActionDesc\":\""+$("#strActionDesc").val()+"\","+
			"\"strReplacePN\":\""+$("#strReplacePN").val()+"\","+
			"\"strFailCSN\":\""+$("#strFailCSN").val()+"\","+
			"\"strNewCSN\":\""+$("#strNewCSN").val()+"\","+
			"\"strField4\":\""+$("#strField4").val()+"\","+
			"\"strField5\":\""+$("#strField5").val()+"\","+
			"\"strField6\":\""+$("#strField6").val()+"\","+
			"\"strField7\":\""+$("#strField7").val()+"\","+
			"\"strField8\":\""+$("#strField8").val()+"\","+
			"\"strField9\":\""+$("#strField9").val()+"\","+
			"\"strAtoTestLogname\":\""+$("#strAtoTestLogname").val()+"\","+
			"\"strAtoTestParam\":\""+$("#strAtoTestParam").val()+"\","+
			"\"strATOTestApplicationVersion\":\""+$("#strATOTestApplicationVersion").val()+"\","+
			"\"strClientIp\":\""+$("#strClientIp").val()+"\","+
			"\"strWebUrl\":\""+$("#strWebUrl").val()+"\""+
				"}",
			success:function(result){
				$("#updateSSNAreaText").html(result);
				$("#updateSSNArea").show();
			},
			error:function(error){
				$("#updateSSNAreaText").html("error ,please check the log");
				$("#updateSSNArea").show();
			}
		});
	}
	