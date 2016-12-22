<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Super calculator</title>
</head>
<body>
<div id="result">
  <c:if test="${not empty result}">
     Calculation result <br/>
     ${expression.firstOperand} ${expression.operationName}  ${expression.secondOperand} = ${result}
  </c:if>
  <c:forEach var="entry" items="${errors}">
     ${entry.value} <br/>
  </c:forEach>
  <br/>
</div>
<form action="/Calculator/calc" method="POST">
Value 1:<input type="text" name="val1" value = "${expression.firstOperand}"/><br/>
Value 2:<input type="text" name="val2" value = "${expression.secondOperand}"/><br/>
operation name:<input type="text" name="operationName" value = "${expression.operationName}"/><br/>
<input type="submit" value="Send request"/>
</form>
</body>
</html>