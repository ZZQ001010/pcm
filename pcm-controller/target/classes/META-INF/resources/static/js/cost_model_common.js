$(function(){
			disabledInput()
		})
		
		$("#feeCollectionMethod").on("change",function(){
			disabledInput()
		})
		
		function disabledInput(){
			var val =$("#feeCollectionMethod").val()
			
			if(val=='A'){
				$("#chargeAmount").attr("disabled","isDisabled")
				$("#chargeAmount").attr("data-rule-required",false)
				$("#chargeRatio").attr("disabled",false)
			}
			else{
				$("#chargeRatio").attr("disabled","isDisabled")
				$("#chargeAmount").attr("disabled",false)
			}
		}