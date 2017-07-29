<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>


<h1>
  <fmt:message key="formaNuevoResena.titulo" />
</h1>

<div class="card horizontal">
  <div class="card-image">

    <img style="height: 100%; width: 80%;" src="images/Alto.png">
    <span class="card-title">
      <fmt:message key="formaNuevoResena.titulo" />
    </span>

  </div>
  <div class="card-stacked">
  <div class="card-content">

    <form id="forma" action="procesarRegistroResena.do" method="post" enctype="multipart/form-data">


        <div class="input-field">
          <i class="material-icons prefix">perm_identity</i>
          <input type="text"
                 name="nombre"

                 maxlength="100"
                 value="">
          <label for="icon_prefix">
            <fmt:message key="formaNuevoResena.etiqueta.nombre" />
          </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">description</i>
          <input type="text"
                 name="descripcion"

                 maxlength="100"
                 value="">
          <label for="icon_telephone">
            <fmt:message key="formaNuevoResena.etiqueta.descripcion" />
        </label>
        </div>


        <div class="input-field" form="forma">
            <i class="material-icons prefix">description</i>
          <input type="text"
                 name="estado"

                 maxlength="100"
                 value="">
          <label for="icon_telephone">
    <label>
      <fmt:message key="formaNuevoResena.etiqueta.estado" />
    </label>
  </div>

  <div class="input-field" form="forma">
<select name="puntuacion">
<option value="" disabled selected>
  <fmt:message key="formaNuevoResena.etiqueta.puntuacion" />
</option>
  <option value="Alto">
    Alto
  </option>
  <option value="Medio">
    Medio
  </option>
  <option value="Bajo">
    Bajo
  </option>
</select>
<label>
<fmt:message key="formaNuevoResena.etiqueta.puntuacion" />
</label>
</div>


    <input class="waves-effect waves-light btn" type="submit"
    name="submit"
    value="Agregar"/>


    </form>

  </div>
</div>
</div>

<script type="text/javascript">
$(document).ready(function() {
  $('select').material_select();
});
</script>
