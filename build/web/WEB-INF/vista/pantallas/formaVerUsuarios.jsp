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
  <fmt:message key="formaListadoUsuarios.titulo" />
</h1>




 <div class="fixed-action-btn">
    <a href="solicitarAgregarUsuario.do" class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
  </div>

 <c:forEach var="usuario" items="${formaListadoUsuarios.usuarios}">


      <div class="card horizontal">
        <div class="card-image">
          <img style="height: 100%; width: 100%;" src="/images/user.png">
          <span class="card-title">${usuario.nombre.nombre}</span>

          <a href="procesarEliminarUsuario.do?id=<c:out value=""/>" class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">delete</i></a>
          <a href='' style="left: 50px;" class="btn-floating halfway-fab waves-effect waves-light blue"><i class="material-icons">mode_edit</i></a>


        </div>
        <div class="card-stacked">
        <div class="card-content">
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoUsuarios.etiqueta.apellidoMaterno" />
            </h5>
            <p class="col s6 m6 l6">
              ${usuario.nombre.apellidoMaterno}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoUsuarios.etiqueta.apellidoPaterno" />
            </h5>
            <p class="col s6 m6 l6">
              ${usuario.nombre.apellidoPaterno}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoUsuarios.etiqueta.nombrePrefijo" />
            </h5>
            <p class="col s6 m6 l6">
              ${usuario.nombre.prefijo}
            </p>
          </div>
          <div class="row">
            <h5 class="col s6 m6 l6">
              <fmt:message key="formaListadoUsuarios.etiqueta.nombreUsuario" />
            </h5>
            <p class="col s6 m6 l6">
              ${usuario.credencial.nombreUsuario}
            </p>
          </div>

          <a class="waves-effect waves-light blue btn" href="#descripcion${usuario.id}">
            Mas informacion
          </a>

          <div id="descripcion${usuario.id}" class="modal">
            <div class="modal-content">

              <div class="card">
                <div class="row">
                  <h5 class="col s6 m6 l6">
                    <fmt:message key="formaListadoUsuarios.etiqueta.claveAcceso" />
                  </h5>
                  <p class="col s6 m6 l6">
                    ${usuario.credencial.claveAcceso}
                  </p>
                </div>
              </div>

            </div>
          </div>
        </div>
      </div>
      </div>

      </c:forEach>

      <script type="text/javascript">
        $(document).ready(function(){
          // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
          $('.modal').modal();
        });
      </script>
