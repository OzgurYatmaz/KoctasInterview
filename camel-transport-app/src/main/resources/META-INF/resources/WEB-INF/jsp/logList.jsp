<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<title>Log Yonetimi</title>


</head>
<body>
	<div class="container">
		 
		<h1>Tum loglar burada:</h1>
		<table class="table">
			<thead>
				<tr>
					<th>dateTime</th>
					<th>classInfo</th>
					<th>level</th>
					<th>message</th>
					<th>exceptionInfo</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${logs}" var="log">
					<tr>
						<td>${log.dateTime}</td>
						<td>${log.classInfo}</td>
						<td>${log.level}</td>
						<td>${log.message}</td>
						<td>${log.exceptionInfo}</td>
						<td><a type="button" class="btn btn-warning"
							href="/deleteLog?id=${log.id}"> Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
	

</body>
</html>

 	
