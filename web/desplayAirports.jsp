<%-- 
    Document   : desplayAirports
    Created on : Jun 27, 2017, 11:26:01 PM
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
        <title>Airports </title>

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
        <%
            String country = new String();
            String desplayTableAirports = "block";
            String desplayMessageAirports = "none";
            String desplayTableRunways = "block";
            String desplayMessageRunways = "none";
            
            if(request.getParameter("country") != null){
                
                country = request.getParameter("country");
               
            }
            else{
                desplayTableRunways = "none";
                desplayTableAirports = "none";
            }
            
            ClientQuery q = new ClientQuery();
            String runways = q.getRunways(country);
            String airports = q.getAirports(country);
            if(airports.equals("")){
                desplayMessageAirports = "block";
            }
            
            if(runways.equals("")){
                desplayMessageRunways = "block";
            }
        %>
        
        <h1 style="text-align: center">Airports in <%=country %></h1>
        <table class="table" style="visibility:<%= desplayTableAirports %>">
            <thead>
                <tr>
                    <th>Airport ID</th>
                    <th>Name</th>
                    <th>Municipality</th>
                    
                </tr>
            </thead>
            <tbody>
                <%= airports%>
            </tbody>
        </table>
        
            <br>
        
        <h1 style="text-align: center">Runways in <%=country %></h1>
            <table class="table" style="desplay:<%= desplayTableRunways %>">
            <thead>
                <tr>
                    <th>Country's Code</th>
                    <th>Country's Name</th>
                    <th>Continent</th>
                    <th>Airport ID</th>
                    <th>Airport Name</th>
                    <th>Runway ID</th>
                    <th>Surface</th>
                    <th>Runway Identification</th>
                </tr>
            </thead>
            <tbody>
                <%= runways%>
            </tbody>
        </table>

    </body>
</html>
