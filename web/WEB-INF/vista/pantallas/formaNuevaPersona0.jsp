    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>


    <br>
    <h1><fmt:message key="formaNuevaPersona.titulo" /></h1>

    <form id="forma" action="procesarRegistro.do" method="post">
      <div class="card horizontal">
      <div class="card-stacked">
      <div class="card-content">

            <tr>
                <td colspan="2">
                   <html:errors />
                </td>
            </tr>
            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="text"
                     name="prefijo"
                     size="12"
                     maxlength="12"
                     value="${formaNuevaPersona.prefijo}" />
              <label for="icon_prefix">
                <fmt:message key="formaNuevaPersona.etiqueta.prefijo" />
              </label>
            </div>
            <%-- <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.prefijo" />
                </td>
                <td align="left">
                    <input type="text"
                           name="prefijo"
                           size="12"
                           maxlength="12"
                           value="${formaNuevaPersona.prefijo}" />
                </td>
            </tr> --%>
            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="text"
                     name="nombre"
                     size="50"
                     maxlength="100"
                      value="${formaNuevaPersona.nombre}" />
              <label for="icon_prefix">
              <fmt:message key="formaNuevaPersona.etiqueta.nombre" />
              </label>
            </div>
            <%-- <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.nombre" />
                </td>
                <td align="left">
                    <input type="text"
                           name="nombre"
                           size="50"
                           maxlength="100"
                           value="${formaNuevaPersona.nombre}" />
                </td>
            </tr> --%>
            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="text"
                    name="apellidoPaterno"
                    size="50"
                    maxlength="100"
                     value="${formaNuevaPersona.apellidoPaterno}" />
              <label for="icon_prefix">
                <fmt:message key="formaNuevaPersona.etiqueta.apellidoPaterno" />
              </label>
            </div>
            <%-- <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.apellidoPaterno" />
                </td>
                <td align="left">
                    <input type="text"
                           name="apellidoPaterno"
                           size="50"
                           maxlength="100"
                           value="${formaNuevaPersona.apellidoPaterno}" />
                </td>
            </tr> --%>
            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="text"
                      name="apellidoMaterno"
                      size="50"
                      maxlength="100"
                     value="${formaNuevaPersona.apellidoMaterno}">
              <label for="icon_prefix">
                <fmt:message key="formaNuevaPersona.etiqueta.apellidoMaterno" />
              </label>
            </div>
            <%-- <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.apellidoMaterno" />
                </td>
                <td align="left">
                    <input type="text"
                           name="apellidoMaterno"
                           size="50"
                           maxlength="100"
                           value="${formaNuevaPersona.apellidoMaterno}" />
                </td>
            </tr> --%>
      <!---    /cidades --->
            <%-- <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.ciudades" />
                </td>
                <td align="left">
       				<select name="ciudad">
                        <c:forEach var="rol" items="${formaNuevaPersona.ciudades}">
    		            <option value="${rol.nombre}">"${rol.descripcion}"</option>
            			</c:forEach>
                     </select>
                </td>
            </tr> --%>

            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="text"
                      name="nombreUsuario"
                      size="50"
                      maxlength="100"
                      value="${formaNuevaPersona.nombreUsuario}" />
              <label for="icon_prefix">
                <fmt:message key="formaNuevaPersona.etiqueta.nombreUsuario" />
              </label>
            </div>


            <%-- <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.nombreUsuario" />
                </td>
                <td align="left">
                    <input type="text"
                           name="nombreUsuario"
                           size="50"
                           maxlength="100"
                           value="${formaNuevaPersona.nombreUsuario}" />
                </td>
            </tr> --%>

            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="password"
                      name="claveAcceso"
                      size="50"
                      maxlength="100"
                      value="${formaNuevaPersona.claveAcceso}" />
              <label for="icon_prefix">
                <fmt:message key="formaNuevaPersona.etiqueta.claveAcceso" />
              </label>
            </div>
            <%-- <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.claveAcceso" />
                </td>
                <td align="left">
                    <input type="text"
                           name="claveAcceso"
                           size="50"
                           maxlength="100"
                           value="${formaNuevaPersona.claveAcceso}" />
                </td>
            </tr> --%>
            <div class="input-field">
              <i class="material-icons prefix">view_headline</i>
              <input type="password"
                      name="claveAccesoConfirmacion"
                      size="50"
                      maxlength="100"
                      value="${formaNuevaPersona.claveAccesoConfirmacion}" />
              <label for="icon_prefix">
                <fmt:message key="formaNuevaPersona.etiqueta.claveAccesoConfirmacion" />
              </label>
            </div>
            <%-- <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.claveAccesoConfirmacion" />
                </td>
                <td align="left">
                    <input type="text"
                           name="claveAccesoConfirmacion"
                           size="50"
                           maxlength="100"
                           value="${formaNuevaPersona.claveAccesoConfirmacion}" />
                </td>
            </tr> --%>

            <input value="${formaNuevaPersona.id}" name="id" style="display: none"/>

            <input class="waves-effect waves-light btn" type="submit"
            name="submit"
            value="Agregar" onclick="eliminarPersonaID(${formaNuevaPersona.id});"/>
            <%-- <tr>
                <td colspan="2" align="center">
                    <input type="submit"
                           name="submit"
                           value="Agregar y terminar"/>
                    <input type="submit"
                           name="submit"
                           value="Agregar y volver"
                           onclick="forma.action='procesarRegistro.do?volver=si'"/>
                    <input type="button"
                           value="Reset"
                           onclick="location.href='solicitarRegistro.do'" />
                    <input type="submit"
                           name="org.apache.struts.taglib.html.CANCEL"
                           value="Cancelar"
                           onclick="bCancel=true;">
                </td>
            </tr> --%>
          </div>
          </div>
          </div>

    </form>

<script type="text/javascript">
  function eliminarPersonaID( id ) {
    $.ajax({
      url : 'procesarEliminarUsuario.do',
      type: "GET",
      data : {
        id: id
      }
    });
    return true;
  }
</script>
