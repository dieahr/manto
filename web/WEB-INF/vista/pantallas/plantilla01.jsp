<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>Gestor de Roles Web.io v3 Beta - UPCHIAPAS</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<script type="text/javascript" src="js/Ajax.js"></script>


		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="css/plantilla.css">
        <link rel="stylesheet" type="text/css" href="css/mensajes.css">
        <link rel="stylesheet" type="text/css" href="css/materialize.css"></head>
				<style media="screen">
					html {
    font-family: GillSans, Calibri, Trebuchet, sans-serif;
  }
				</style>

				<script type="text/javascript" src="js/jQuery.js"></script>
        <script type="text/javascript" src="js/materialize.js"></script>

    </head>

    <body>
    <c:import url="/WEB-INF/vista/comun/barraMenu01.jsp" />
      <section style="min-height: 100vh;"class="">
				  <c:import url="/WEB-INF/vista/pantallas/${param.c}" />
      </section>
					<c:import url="/WEB-INF/vista/comun/barraPie.jsp" />


    </body>
</html>
