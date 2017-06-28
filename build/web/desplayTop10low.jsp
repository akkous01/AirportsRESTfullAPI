<%-- 
    Document   : desplayTop10low
    Created on : Jun 27, 2017, 11:21:39 PM
    Author     : Antria
--%>

<%@page import="com.lunatech.airports.client.ClientQuery"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Top 10 countries with the most airports</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <% ClientQuery q = new ClientQuery(); %>
         <h1 style="text-align: center">Top 10 countries with the least airports</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>Country</th>
                    <th>Number of Airports</th>
                </tr>
            </thead>
            <tbody>
                <%= q.top10Low()%>
            </tbody>
        </table>
    </body>
</html>
