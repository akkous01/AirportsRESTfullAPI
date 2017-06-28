<%-- 
    Document   : index
    Created on : Jun 27, 2017, 11:09:23 PM
    Author     : Antria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Airports Database</title>

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
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
            <h1 style="text-align: center">Airports Database</h1>
            </div>
            <div class="col-md-4"></div>
        </div>
        <hr>
        <div class="row">
            <div class="col-md-4"></div>
            <div class  =" col-md-4" style="text-align: center">
            <h3>Query</h3>
            <form name="countryForm" action="desplayAirports.jsp" method="POST">

                Enter a country code or name:
                <input type="text" name="country" required="" value="" size="35" />
                <br><br>
                <input type="reset" class="btn btn-info" value="Clear" name="clear" />
                <input type="submit" class="btn btn-info" value="Submit" name="submit" />
            </form>
            </div>
            <div class="col-md-4"></div>
        </div>
        <hr>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4" style="text-align: center">
            <h3 >Reports</h3>
            <form name="top10form" action="desplayTop10.jsp">
                Countries with the most airports:   <input type="submit" class="btn btn-info" value="Submit" name="top10" />
            </form>

            <br>

            <form name="top10lowform" action="desplayTop10low.jsp">
                Countries with the least airports:   <input type="submit" class="btn btn-info" value="Submit" name="top10low" />
            </form>

            <br>

            <form name="uniqueSurface" action="desplaySurface.jsp">
                Surfaces for each country:   <input type="submit" value="Submit" class="btn btn-info" name="unqueSurface" />
            </form>

            <br>

            <form name="top10lowform" action="desplayRunways.jsp">
                Most common Runways Identifications:   <input type="submit" value="Submit" class="btn btn-info" name="top10low" />
            </form>
            </div>
            <div class="col-md-4"></div>
            
        </div>
    </body>
</html>
