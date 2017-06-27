<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>


<h1>
  <fmt:message key="formaListadoHoteles.titulo" />
</h1>


      <div class="card horizontal">
        <div class="card-image">
          <img style="height: 100%; width: 100%;" src="${formaModificarHotel.imagen}">
          <span class="card-title">${formaModificarHotel.nombre}</span>


        </div>
        <div class="card-stacked">
        <div class="card-content">


          <form id="forma" action="procesarModificarHotel.do" method="post" enctype="multipart/form-data">

              <div class="input-field">
                <i class="material-icons prefix">view_headline</i>
                <input type="text"
                       name="nombre"

                       maxlength="100"
                       value="${formaModificarHotel.nombre}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoHoteles.etiqueta.nombre" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">description</i>
                <input type="text"
                       name="descripcion"

                       maxlength="100"
                       value="${formaModificarHotel.descripcion}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoHoteles.etiqueta.descripcion" />
              </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">credit_card</i>
                <input type="number" step='any'
                       name="precio"

                       maxlength="100"
                       value="${formaModificarHotel.precio}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoHoteles.etiqueta.precio" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">today</i>
                <input type="text"
                       name="horario"

                       maxlength="100"
                       value="${formaModificarHotel.horario}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoHoteles.etiqueta.horario" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      id="estado"
                      name="estado"

                       maxlength="100"
                       value="${formaModificarHotel.estado}">
                <label for="icon_prefix" class="active">
                  <fmt:message key="formaListadoHoteles.etiqueta.estado" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      id="pais"
                      name="pais"

                       maxlength="100"
                       value="${formaModificarHotel.pais}">
                <label for="icon_telephone" class="active">
                  <fmt:message key="formaListadoHoteles.etiqueta.pais" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      name="direccion"
                      id="direccion"
                       maxlength="100"
                       value="${formaModificarHotel.direccion}">
                <label for="icon_prefix" class="active">
                  <fmt:message key="formaListadoHoteles.etiqueta.direccion" />
                </label>
              </div>



          <input value="${formaModificarHotel.imagen}" name="imagen" style="display: none"/>

          <input value="${formaModificarHotel.id}" name="id" style="display: none"/>

          <input class="waves-effect waves-light btn" type="submit"
          name="submit"
          value="Actualizar"/>


          </form>
        </div>
      </div>
      </div>
