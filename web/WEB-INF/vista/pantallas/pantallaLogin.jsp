<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    <br>
      <style>
        body {
          display: flex;
          min-height: 100vh;
          flex-direction: column;
        }

        main {
          flex: 1 0 auto;
        }

        body {
          background: #fff;
        }

        .input-field input[type=date]:focus + label,
        .input-field input[type=text]:focus + label,
        .input-field input[type=email]:focus + label,
        .input-field input[type=password]:focus + label {
          color: #e91e63;
        }

        .input-field input[type=date]:focus,
        .input-field input[type=text]:focus,
        .input-field input[type=email]:focus,
        .input-field input[type=password]:focus {
          border-bottom: 2px solid #e91e63;
          box-shadow: none;
        }
      </style>



      <div class="section"></div>
      <main>
        <center>
          <img class="responsive-img" style="width: 250px;" src="http://i.imgur.com/ax0NCsK.gif" />
          <div class="section"></div>

          <h5 class="indigo-text">Por favor, ingresa con tu usuario</h5>
          <div class="section"></div>

          <div class="container">
            <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

              <form id="forma" action="procesarLogin.dd" method="post">
                <div class='row'>
                  <div class='col s12'>
                  </div>
                </div>

                <div class='row'>
                  <div class='input-field col s12'>
                    <input type="text"
                           name="user"
                           size="50"
                           maxlength="100"
                           value="${formaLogin.user}" />

                    <label for='email'><fmt:message key="formaLogin.etiqueta.Usuario" /></label>
                  </div>
                </div>

                <div class='row'>
                  <div class='input-field col s12'>
                    <input type="password"
                           name="password"
                           size="50"
                           maxlength="100"
                           value="${formaLogin.password}" />
                    <label for='password'><fmt:message key="formaLogin.etiqueta.Contrasena" /></label>
                  </div>
                </div>

                <br />
                <center>
                  <div class='row'>
                    <button type='submit' name='submit' class='col s12 btn btn-large waves-effect indigo'>Login</button>
                  </div>
                </center>
              </form>
            </div>
          </div>

        </center>

        <div class="section"></div>
        <div class="section"></div>
      </main>















<!--
    <form id="forma" action="procesarLogin.dd" method="post">

                   <html:errors />

                    <fmt:message key="formaLogin.etiqueta.Usuario" />

                    <input type="text"
                           name="user"
                           size="50"
                           maxlength="100"
                           value="${formaLogin.user}" />

                    <fmt:message key="formaLogin.etiqueta.Contrasena" />

                    <input type="password"
                           name="password"
                           size="50"
                           maxlength="100"
                           value="${formaLogin.password}" />

                    <input type="submit"
                           name="submit"
                           value="Login"/>

    </form> -->
