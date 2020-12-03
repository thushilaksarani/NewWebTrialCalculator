<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<link href="resource\CSS\TrialCal.css" rel="stylesheet">
<title>Insert title here</title>
</head>

<body>

	<div class="nav-bar-page">
		<h1>Loan Calculator</h1>
		<br><p>Login : ${user_name}</p>
	</div>
	
	<div class="cal">
		<div class="form">
		<form class="cal-form" action="trialCal" method="post">
		<table>
				<tr>
				<td><label>Prospect Name</label></td>
				<td></td>
				<td><input type="text" name="firstName" placeholder="First Name"/>
				<input type="text" name="lastName" placeholder="Last Name"/></td>
				</tr>
				
				<tr>
				<td><label>NIC Number</label></td>
				<td>&nbsp&nbsp&nbsp</td>
				<td><input type="text" name="nic"/></td>
				</tr>
				
				<tr>
				<td><label>Loan Amount</label></td>
				<td></td>
				<td><input type="text" name="loanAmt" id="loanAmt"/> </td>
				</tr>
				
				<tr>
				<td><label>Repayment Period</label></td>
				<td></td>
				<td><input type="text" name="repayPeriod" id="repayPeriod"/>&nbsp&nbsp<label>Months</label></td>
				</tr>
				
				<tr>
				<td><label>Interest Rate</label></td>
				<td></td>
				<td><input type="text" name="interestRate" id="interestRate" placeholder="Input in Decimal Form"/></td>
				</tr>
				
				<tr>
				<td><label>Installment Value</label></td>
				<td></td>
				<td><input type="text" id="installmentValue" name="installmentValue" readonly /></td>
				</tr>
				
				<tr>
				<td></td>
				<td></td>
				<td><br><button class="button button1" name="computebutton" id="computebutton" value="compute" type="button" onclick="myFunction()">
							Compute</button>
				<button class="button button2" name="viewbutton" id="viewbutton" value="view" type="submit" >
							Save</button>
				<button class="button button3" name="resetbutton" id="resetbutton" value="reset" type="button" onclick="shedule()">
							view shedule</button>
				<button class="button button4" name="viewprospectbutton" id="viewprospectbutton" value="view" type="submit" >
							View Prospects</button></td>
				</tr>
				
				
		</table>	
		
		
			
		</form>
		</div>
	</div>
	
	<script>
		function myFunction() {
 		
 			var l = document.getElementById("loanAmt").value;
 			var loanAmt =parseFloat(l);
 			var n = document.getElementById("repayPeriod").value;
 			var repayPeriod =parseFloat(n);
 			var i = document.getElementById("interestRate").value;
 			var interestRate=parseFloat(i);

 			var instalmentVal= (loanAmt*(interestRate/12))/(1-(Math.pow((1+interestRate/12), (-repayPeriod))));
 			var instalmentValue = instalmentVal.toFixed(2);
 			
 			document.getElementById("installmentValue").value = instalmentValue;			
		}

		function shedule(){

			var l = document.getElementById("loanAmt").value;
 			var loanAmt =parseFloat(l);
 			
 			var n = document.getElementById("repayPeriod").value;
 			var repayPeriod =parseInt(n);
 			
 			var i = document.getElementById("interestRate").value;
 			var interestRate=parseFloat(i);

 			var r = document.getElementById("installmentValue").value;
 			var installmentValue=parseFloat(r);
			
			document.write("<table ><tr> <th>Rental No</th> <th>Rental Value</th> <th>Interest Amount</th> <th>Capital Amount</th> <th>Capital Balance</th> </tr>");

			document.write("<tr> <td>0</td>  <td>0</td> <td>0</td> <td>0</td> <td>"+(l)+"</td> </tr>");

			var iAmt;
			var cAmt;
			for (var a=1; a <= repayPeriod; a++) {
				iAmt=loanAmt*interestRate/12;
				cAmt=installmentValue-iAmt;
				loanAmt = loanAmt-cAmt;

				iAmt=iAmt.toFixed(2);
				cAmt=cAmt.toFixed(2);
				loanAmt=loanAmt.toFixed(2);
				
				document.write("<tr>");
				document.write("<td>"+(a)+"</td> <td>"+(installmentValue)+"</td> <td>"+(iAmt)+"</td> <td>"+(cAmt)+"</td> <td>"+(loanAmt)+"</td>" );
				document.write("</tr>");
			}
			document.write("</table>");
		}
		
	</script>
	
	
	
</body>
</html>

























