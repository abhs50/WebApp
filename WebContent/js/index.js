$(document).ready(function(){

	function showTransactionForm(){
		$("#transaction_form").fadeIn(400);
	}

	function hideTransactionForm(){
		$("#transaction_form").fadeOut(400);	
	}

	function addTransaction(){
		addNewTransaction();
		hideTransactionForm();
	}

	function getCurrentDate(){
		//var dt = Date.parse('today');
		//return dt.toString('MMM, dd');
		var currentDate = new Date();
		var day = currentDate.getDate();
		var month = currentDate.getMonth();
		var year = currentDate.getFullYear();

		var dateString = month + '/' + day + '/' + year;
		return dateString;

	}
	
	function sendData(spendingCategory, amountSpent, description, dt){
		   var sendMsg = spendingCategory+","+amountSpent+","+description+","+dt;
		    alert(sendMsg);
		    $.ajax({
		        type: "POST",
		        url: "HeaderServlet",
		        data: { message : sendMsg }
		    		 
		      }).done(function( msg ) {
		        alert( "Data Saved: " + msg );
		      });
	}

		
	function formTableRow(spendingCategory, amountSpent,
		description, dt){
		var newRow = "<tr><td>" + spendingCategory + "</td><td>" + amountSpent + "</td><td>" 
					+ description + "</td><td>" + dt + "</td></tr>";
		return newRow;
	}

	function addNewTransaction(){
		var spendingCategory = $("#txtCategory").val();
		var amountSpent = $("#txtAmountSpent").val();
		var description = $("#txtDescription").val();
		var dt = getCurrentDate();

		var newRow = formTableRow(spendingCategory, amountSpent, description, dt);
		$('#transaction_table_body').append(newRow);
		sendData(spendingCategory, amountSpent, description, dt);

	}

	//show the transaction form
	$("#btnShowTransactionForm").click(showTransactionForm);

	//add a new transaction
	$("#btnAddTransaction").click(addTransaction);

});