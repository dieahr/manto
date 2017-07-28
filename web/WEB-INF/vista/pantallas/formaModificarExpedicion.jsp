<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>


<h1>
  <fmt:message key="formaListadoExpediciones.titulo" />
</h1>


      <div class="card horizontal">
        
        <div class="card-stacked">
        <div class="card-content">


          <form id="forma" action="procesarModificarExpedicion.do" method="post" enctype="multipart/form-data">

              <div class="input-field">
                <i class="material-icons prefix">view_headline</i>
                <input type="text"
                       name="nombre"

                       maxlength="100"
                       value="${formaModificarExpedicion.nombre}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoExpediciones.etiqueta.nombre" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">description</i>
                <input type="text"
                       name="descripcion"

                       maxlength="100"
                       value="${formaModificarExpedicion.descripcion}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoExpediciones.etiqueta.descripcion" />
              </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">credit_card</i>
                <input type="number" step='any'
                       name="cantidad"

                       maxlength="100"
                       value="${formaModificarExpedicion.cantidad}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoExpediciones.etiqueta.cantidad" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      id="estado"
                      name="estado"

                       maxlength="100"
                       value="${formaModificarExpedicion.estado}">
                <label for="icon_prefix" class="active">
                  <fmt:message key="formaListadoExpediciones.etiqueta.estado" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      id="pais"
                      name="pais"

                       maxlength="100"
                       value="${formaModificarExpedicion.pais}">
                <label for="icon_telephone" class="active">
                  <fmt:message key="formaListadoExpediciones.etiqueta.pais" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      name="direccion"
                      id="direccion"
                       maxlength="100"
                       value="${formaModificarExpedicion.direccion}">
                <label for="icon_prefix" class="active">
                  <fmt:message key="formaListadoExpediciones.etiqueta.direccion" />
                </label>
              </div>
                
              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      name="fecha"
                       maxlength="100"
                       value="${formaModificarExpedicion.fecha}">
                <label for="icon_prefix" class="active">
                  <fmt:message key="formaListadoExpediciones.etiqueta.fecha" />
                </label>
              </div>
                
              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      name="hora"
                       maxlength="100"
                       value="${formaModificarExpedicion.hora}">
                <label for="icon_prefix" class="active">
                  <fmt:message key="formaListadoExpediciones.etiqueta.hora" />
                </label>
              </div>


          <input value="${formaModificarExpedicion.id}" name="id" style="display: none"/>

          <input class="waves-effect waves-light btn" type="submit"
          name="submit"
          value="Actualizar"/>


          </form>
        </div>
      </div>
      </div>
