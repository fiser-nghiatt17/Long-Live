<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html>
<html lang="en" class="mdl-js">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><tiles:insertAttribute name="title"/></title>
<tiles:insertAttribute name="cssLib" />
</head>

<body>

<tiles:insertAttribute name="nav" />

<tiles:insertAttribute name="body" />

<tiles:insertAttribute name="footer" />
</body>
<tiles:insertAttribute name="jsLib" />
<tiles:insertAttribute name="galleria" />
</html>