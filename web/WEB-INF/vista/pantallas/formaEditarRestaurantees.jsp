<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style media="screen">
  div.card{
    margin: 50px;
  }
</style>

<form>
        <div class="input-field">
          <input id="search" type="search" required>
          <label class="label-icon" for="search"><i class="material-icons">search</i></label>
          <i class="material-icons">close</i>
        </div>
      </form>


<h1>
  <fmt:message key="formaListadoRestaurantees.titulo" />
</h1>




 <div class="fixed-action-btn">
    <a href="solicitarRegistroRestaurante.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
  </div>

 <c:forEach var="restaurante" items="${formaListadoRestaurantees.restaurantees}">


      <div class="card horizontal">
        <div class="card-image">
          <img style="height: 100%; width: 100%;" src="${restaurante.imagen}">
          <span class="card-title">${restaurante.nombre}</span>

          <a href="procesarEliminarRestaurante.do?id=<c:out value="${restaurante.id}"/>" class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">delete</i></a>
          <a style="left: 50px;" class="btn-floating halfway-fab waves-effect waves-light blue"><i class="material-icons">mode_edit</i></a>


        </div>
        <div class="card-stacked">
        <div class="card-content">


          <form>

            <input class="waves-effect waves-light btn" type="button"
            value="Reset"
            onclickan="location.href='solicitarRegistroRestaurante.do'" />
            <input class="waves-effect waves-light btn" type="submit"
            name="org.apache.struts.taglib.html.CANCEL"
            value="cancelar"
            onclick="bCancel=true;">

              <div class="input-field">
                <i class="material-icons prefix">view_headline</i>
                <input type="text"
                       name="nombre"

                       maxlength="100"
                       value="${restaurante.nombre}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoRestaurantees.etiqueta.nombre" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">description</i>
                <input type="text"
                       name="descripcion"

                       maxlength="100"
                       value="${restaurante.descripcion}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoRestaurantees.etiqueta.descripcion" />
              </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">credit_card</i>
                <input type="number" step='any'
                       name="precio"

                       maxlength="100"
                       value="${restaurante.precio}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoRestaurantees.etiqueta.precio" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">today</i>
                <input type="text"
                       name="horario"

                       maxlength="100"
                       value="${restaurante.horario}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoRestaurantees.etiqueta.horario" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      id="estado"
                      name="estado"

                       maxlength="100"
                       value="${restaurante.estado}">
                <label for="icon_prefix" class="active">
                  <fmt:message key="formaListadoRestaurantees.etiqueta.estado" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      id="pais"
                      name="pais"

                       maxlength="100"
                       value="${restaurante.pais}">
                <label for="icon_telephone" class="active">
                  <fmt:message key="formaListadoRestaurantees.etiqueta.pais" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      name="direccion"
                      id="direccion"
                       maxlength="100"
                       value="${restaurante.direccion}">
                <label for="icon_prefix" class="active">
                  <fmt:message key="formaListadoRestaurantees.etiqueta.direccion" />
                </label>
              </div>

              <div class="file-field input-field">
          <div class="btn">
          <span>
          <fmt:message key="formaListadoRestaurantees.etiqueta.foto" />
          </span>
          <input type="file"
           name="imagen"
           value="${restaurante.imagen}">
          </div>
          <div class="file-path-wrapper">
          <input class="file-path validate" type="text">
          </div>
          </div>

          <input class="waves-effect waves-light btn" type="submit"
          name="submit"
          value="Agregar y terminar"/>
          <input class="waves-effect waves-light btn" type="submit"
          name="submit"
          value="Agregar y volver"
          onclick="forma.action='procesarRegistroRestaurante.do?volver=si'"/>


          </form>
        </div>
      </div>
      </div>

      </c:forEach>
