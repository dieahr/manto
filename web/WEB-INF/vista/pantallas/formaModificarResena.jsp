<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>


<h1>
  <fmt:message key="formaListadoResena.titulo" />
</h1>


      <div class="card horizontal">
        <div class="card-image">
          <img style="height: 100%; width: 100%;" src="images/${formaModificarResena.puntuacion}.png">
          <span class="card-title">${formaModificarResena.nombre}</span>


        </div>
        <div class="card-stacked">
        <div class="card-content">


          <form id="forma" action="procesarModificarResena.do" method="post" enctype="multipart/form-data">

              <div class="input-field">
                <i class="material-icons prefix">perm_identity</i>
                <input type="text"
                       name="nombre"

                       maxlength="100"
                       value="${formaModificarResena.nombre}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoResena.etiqueta.nombre" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">description</i>
                <input type="text"
                       name="descripcion"

                       maxlength="100"
                       value="${formaModificarResena.descripcion}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoResena.etiqueta.descripcion" />
              </label>
              </div>


              <div class="input-field" form="forma">
            <select name="puntuacion">
            <option value="${formaModificarResena.puntuacion}" disabled selected>
              ${formaModificarResena.puntuacion}
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





          <input value="${formaModificarResena.id}" name="id" style="display: none"/>

          <input value="${formaModificarResena.estado}" name="estado" style="display: none"/>

          <input class="waves-effect waves-light btn" type="submit"
          name="submit"
          value="Actualizar"/>


          </form>
        </div>
      </div>
      </div>
      <script type="text/javascript">
      $(document).ready(function() {
        $('select').material_select();
      });
      </script>
