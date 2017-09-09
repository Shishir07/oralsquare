<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Oral Square</title>  
     <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet" type="text/css"/>
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body ng-app="myApp" class="ng-cloak">
  	
  	  
      <div class="container-fluid">
        <div class="row-fluid">
            <div class="span10 offset1">
                <h1 class="topbox">
                      <img src="static/img/logo.png" height="90" width="90" alt="logo"/>
                      <img src="static/img/name.png" height="120" width="400" alt="name"/>
                </h1>
                
                <div class="generic-container" ng-view></div>
            </div>
        </div>
	  </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="/static/js/formsubmit.js"></script>
  </body>
</html>

