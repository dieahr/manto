<!DOCTYPE html>
<html >

<head>
    <title>Clima</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/plantilla.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch' href='http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css'>
</head>

<style> 
    main{
      background:pink;
      border-radius:.8em;
      margin-top:2em;
    }
    label{
      margin:1em -.5em;
    }
    label:hover{
      height:auto;
    }
    #temp{
      font-size:8rem;
      font-weight:bold;
    }
    
    #condition{
      font-weight:bold;
      text-transform:uppercase;
    }
</style>

<body>
 
<div class="container-fluid">
  <main class="container">
    <div class="row">    
      <div class="col-md-12 text-center">
        <h1 id="city"><img id="icon" /> </h1>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12 text-center">  
        <p id="condition"></p>
        <p id="temp"><p>
         <fieldset>
          <legend class="sr-only">Seleccione Fahrenheit o Celsius</legend>
          <label class="ui-state-active" for="f">&deg;F</label>
          <input type ="radio" name="temp_select" id="f">
          <label for="c" class="active">&deg;C</label>
          <input type="radio" name="temp_select" id="c">
        </fieldset>
      </div>
    </div>
  </main>
</div>
  
  <script> 
  $(function getWeather() {
      var url = 'https://api.wunderground.com/api/35d9c39ec27c86b6/geolookup/conditions/q/autoip.json';
      $.getJSON(url, function(data) {
        $('#city').append(data.location.city + ", " + data.location.state);
        $('#temp').append(data.current_observation.feelslike_f + '&deg;F');
        $('#icon').attr('src', data.current_observation.icon_url);
        $('#condition').append(data.current_observation.weather);
      

        $("#c").click(function(){
          $("#f").removeClass("ui-state-active");
          $(this).addClass("ui-state-active");
          $("#temp").html(data.current_observation.feelslike_c + '&deg;C');
        });
        $("#f").click(function(){
          $("#temp").html(data.current_observation.feelslike_f + "&deg;F");
        });
    });
});

$(function() {
    $("input").checkboxradio({icon: false});
});

</script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.0/jquery-ui.min.js'></script>
<script src="js/index.js"></script>

</body>
</html>
