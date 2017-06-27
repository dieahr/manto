<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
				<meta charset="utf-8">
        <title>USJ</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">


        <link rel="stylesheet" type="text/css" href="css/plantilla.css">
        <link rel="stylesheet" type="text/css" href="css/materialize.css">
        </head>
    </head>

    <body>

        <c:import url="/WEB-INF/vista/comun/barraMenu01.jsp" />

<section style="height: 100vh;">

			<h1 style="text-align:center;" >Bienvenidos a Trivago</h1>
			<div class="carousel" style="widt">
			 <a class="carousel-item" style="width:30% !important; left: 1% !important;" href="#one!"><img src="images/hotel003.jpg"></a>
			 <a class="carousel-item" href="#two!" style="width:30% !important; left: 1% !important;"><img src="images/hotel.jpg"></a>
			 <a class="carousel-item" href="#three!" style="width:30% !important; left: 1% !important;"><img src="images/hotel2.jpg"></a>
			 <a class="carousel-item" href="#four!" style="width:30% !important; left: 1% !important;"><img src="images/hotel3.jpg"></a>
			 <a class="carousel-item" href="#five!" style="width:30% !important; left: 1% !important;"><img src="images/hotel4.jpg"></a>
		 </div>
		<!-- <div class="container">
			<div class="row">
				<div class="col l6 s8" style="padding-top: 10vh;">
						<h3>Bienvenidos a trivago </h3>
				</div>
				<div class="col l6 8" style="padding-top: 10vh;">
					<img src="images/hotel003.jpg" style=" height: 50vh; width:50wh;">
				</div>
			</div>
		</div> -->


</section>



			      <%-- <div style="width=100wh height=100vh" class="">
							<h3>Bienvenidos a trivago </h3>

							<img src="images/hotel003.jpg" style="height: 50vh; width:50wh;"> --%>




            <c:import url="/WEB-INF/vista/comun/barraPie.jsp" />



        <script type="text/javascript" src="js/jQuery.js"></script>
        <script type="text/javascript" src="js/materialize.js"></script>

				<script type="text/javascript">
					$(document).ready(function(){
			      $('.carousel').carousel();
			    });
				</script>

    </body>
</html>
