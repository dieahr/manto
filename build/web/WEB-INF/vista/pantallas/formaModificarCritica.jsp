<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>


<h1>
  <fmt:message key="formaListadoCriticaes.titulo" />
</h1>


      <div class="card horizontal">
        <div class="card-image">
          <img style="height: 100%; width: 100%;" src="images/${formaModificarCritica.nivel}.png">
          <span class="card-title">${formaModificarCritica.nombre}</span>


        </div>
        <div class="card-stacked">
        <div class="card-content">


          <form id="forma" action="procesarModificarCritica.do" method="post" enctype="multipart/form-data">

              <div class="input-field">
                <i class="material-icons prefix">perm_identity</i>
                <input type="text"
                       name="nombre"

                       maxlength="100"
                       value="${formaModificarCritica.nombre}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoCriticaes.etiqueta.nombre" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">description</i>
                <input type="text"
                       name="descripcion"

                       maxlength="100"
                       value="${formaModificarCritica.descripcion}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoCriticaes.etiqueta.descripcion" />
              </label>
              </div>


              <div class="input-field" form="forma">
            <select name="nivel">
            <option value="${formaModificarCritica.nivel}" disabled selected>
              ${formaModificarCritica.nivel}
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





          <input value="${formaModificarCritica.id}" name="id" style="display: none"/>

          <input value="${formaModificarCritica.hotel}" name="hotel" style="display: none"/>

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
