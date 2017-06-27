<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>


<h1>
  <fmt:message key="formaNuevoCritica.titulo" />
</h1>

<div class="card horizontal">
  <div class="card-image">

    <img style="height: 100%; width: 80%;" src="images/Alto.png">
    <span class="card-title">
      <fmt:message key="formaNuevoCritica.titulo" />
    </span>

  </div>
  <div class="card-stacked">
  <div class="card-content">

    <form id="forma" action="procesarRegistroCritica.do" method="post" enctype="multipart/form-data">


        <div class="input-field">
          <i class="material-icons prefix">perm_identity</i>
          <input type="text"
                 name="nombre"

                 maxlength="100"
                 value="">
          <label for="icon_prefix">
            <fmt:message key="formaNuevoCritica.etiqueta.nombre" />
          </label>
        </div>

        <div class="input-field">
          <i class="material-icons prefix">description</i>
          <input type="text"
                 name="descripcion"

                 maxlength="100"
                 value="">
          <label for="icon_telephone">
            <fmt:message key="formaNuevoCritica.etiqueta.descripcion" />
        </label>
        </div>


        <div class="input-field" form="forma">
    <select name="hotel">
      <option value="" disabled selected>
        <fmt:message key="formaNuevoCritica.etiqueta.hotel" />
      </option>
      <c:forEach var="hotel" items="${formaListadoHoteles.hoteles}">
        <option value="${hotel.nombre}">
          ${hotel.nombre}
        </option>
      </c:forEach>
    </select>
    <label>
      <fmt:message key="formaNuevoCritica.etiqueta.hotel" />
    </label>
  </div>

  <div class="input-field" form="forma">
<select name="nivel">
<option value="" disabled selected>
  <fmt:message key="formaNuevoCritica.etiqueta.nivel" />
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
<fmt:message key="formaNuevoCritica.etiqueta.nivel" />
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
