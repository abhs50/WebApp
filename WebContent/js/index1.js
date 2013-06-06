$(document).ready(function(){
	$('#spent_amount').keyup(function(){
		var amountSpent = $(this).val();
		console.log(amountSpent);
		if(amountSpent.length > 0){
			var regex = /^[0-9]*([.][0-9]+)?$/;
			if(!regex.test(amountSpent)){
				$('#spent_amount_error').html('Only numbers are allowed');
			}else{
				$('#spent_amount_error').html('');
			}
		}else{
			$('#spent_amount_error').html('');
		}
	});

	$('#add_transaction').click(function(){
		addTransaction();
	});

	function addTransaction(){
		console.log('Button clicked');
		var spendingCategory = $('#spending_category').val();
		var amountSpent = $('#spent_amount').val();
		console.log(spendingCategory);
		console.log(amountSpent);

		var dateString = getTodaysDate();

		var newRow = "<tr><td>"+$('#spending_category').val()+"</td><td>"+$('#spent_amount').val()+"</td><td>"+dateString+"</td></tr>";
		console.log(newRow);
		$('#transaction_table').append(newRow);

	}

	function getTodaysDate(){
		var currentDate = new Date();
		var day = currentDate.getDate();
		var month = currentDate.getMonth();

		var dateString = month + ' ' + day;
		return dateString;
	}

});