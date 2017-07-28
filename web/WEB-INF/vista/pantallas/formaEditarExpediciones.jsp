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
  <fmt:message key="formaListadoExpediciones.titulo" />
</h1>




 <div class="fixed-action-btn">
    <a href="solicitarRegistroExpedicion.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
  </div>

 <c:forEach var="expedicion" items="${formaListadoExpediciones.expediciones}">


      <div class="card horizontal">
        <div class="card-image">
          <span class="card-title">${expedicion.nombre}</span>

          <a href="procesarEliminarExpedicion.do?id=<c:out value="${expedicion.id}"/>" class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">delete</i></a>
          <a style="left: 50px;" class="btn-floating halfway-fab waves-effect waves-light blue"><i class="material-icons">mode_edit</i></a>


        </div>
        <div class="card-stacked">
        <div class="card-content">


          <form>

            <input class="waves-effect waves-light btn" type="button"
            value="Reset"
            onclickan="location.href='solicitarRegistroExpedicion.do'" />
            <input class="waves-effect waves-light btn" type="submit"
            name="org.apache.struts.taglib.html.CANCEL"
            value="cancelar"
            onclick="bCancel=true;">

              <div class="input-field">
                <i class="material-icons prefix">view_headline</i>
                <input type="text"
                       name="nombre"

                       maxlength="100"
                       value="${expedicion.nombre}">
                <label for="icon_prefix">
                  <fmt:message key="formaListadoExpediciones.etiqueta.nombre" />
                </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">description</i>
                <input type="text"
                       name="descripcion"

                       maxlength="100"
                       value="${expedicion.descripcion}">
                <label for="icon_telephone">
                  <fmt:message key="formaListadoExpediciones.etiqueta.descripcion" />
              </label>
              </div>

              <div class="input-field">
                <i class="material-icons prefix">credit_card</i>
                <input type="number" step='any'
                       name="cantidad"

                       maxlength="100"
                       value="${expedicion.cantidad}">
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
                       value="${expedicion.estado}">
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
                       value="${expedicion.pais}">
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
                       value="${expedicion.direccion}">
                <label for="icon_prefix" class="active">
                  <fmt:message key="formaListadoExpediciones.etiqueta.direccion" />
                </label>
              </div>
                
              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      name="fecha"
                       maxlength="100"
                       value="${expedicion.fecha}">
                <label for="icon_prefix" class="active">
                  <fmt:message key="formaListadoExpediciones.etiqueta.fecha" />
                </label>
              </div>
                
              <div class="input-field">
                <i class="material-icons prefix">my_location</i>
                <input type="text"
                      name="hora"
                       maxlength="100"
                       value="${expedicion.hora}">
                <label for="icon_prefix" class="active">
                  <fmt:message key="formaListadoExpediciones.etiqueta.hora" />
                </label>
              </div>  

          <input class="waves-effect waves-light btn" type="submit"
          name="submit"
          value="Agregar y terminar"/>
          <input class="waves-effect waves-light btn" type="submit"
          name="submit"
          value="Agregar y volver"
          onclick="forma.action='procesarRegistroExpedicion.do?volver=si'"/>


          </form>
        </div>
      </div>
      </div>

      </c:forEach>
