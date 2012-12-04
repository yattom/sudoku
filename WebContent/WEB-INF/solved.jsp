<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数独(回答)</title>
</head>
<body>
入力:
<pre>${ quiz }</pre>

回答:
<pre>${ sudoku.dump() }</pre>

</body>
</html>