<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.ArrayList" %>
   <%@ page import="com.demo.domain.Prospect" %>
   
   <% ArrayList prospectRecSet = (ArrayList)request.getAttribute("prospectRecSet"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>		
		<div class="container">		
		<table>		
			<% for(int rec=0; rec < prospectRecSet.size(); rec++){ %>
			<tr>
			
			<% Prospect pro = (Prospect)prospectRecSet.get(rec); %>
			<td>
			<% pro.getId(); %>
			</td>
			<td>
			<% pro.getfName(); %>
			</td>
			<td>
			<% pro.getlName(); %>
			</td>
			<td>
			<% pro.getNic(); %>
			</td>
			<td>
			<% pro.getLoanAmt(); %>
			</td>
			<td>
			<% pro.getRepayPeriod(); %>
			</td>
			<td>
			<% pro.getInterestRate(); %>
			</td>
			<td>
			<% pro.getInstallmentVal(); %>
			</td>
			<td>
			<% pro.getDate(); %>
			</td>
			
			</tr>
			<% } %>
			
		</table>
		
		</div>

</body>
</html>








































































