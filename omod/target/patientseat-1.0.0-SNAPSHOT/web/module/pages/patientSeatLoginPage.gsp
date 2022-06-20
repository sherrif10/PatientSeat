<%
    ui.includeFragment("appui", "standardEmrIncludes")
    ui.includeCss("appui", "bootstrap.min.css")
    ui.includeJavascript("appui", "jquery-3.4.1.min.js")
    ui.includeJavascript("appui", "bootstrap.min.js")
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${ui.message("referenceapplication.login.title")}</title>
    <link rel="shortcut icon" type="image/ico" href="/${ui.contextPath()}/images/openmrs-favicon.ico"/>
    <link rel="icon" type="image/png\" href="/${ui.contextPath()}/images/openmrs-favicon.png"/>
    ${ui.resourceLinks()}
</head>

<body>
<script type="text/javascript">
  var OPENMRS_CONTEXT_PATH = '${ ui.contextPath() }';
</script>
<script type="text/javascript">
  jQuery(function () {
    updateSelectedOption = function () {
      jQuery('#sessionLocation li').removeClass('selected');
      var sessionLocationVal = jQuery('#sessionLocationInput').val();
    };
    updateSelectedOption();
    jQuery('#sessionLocation li').click(function () {
      jQuery('#sessionLocationInput').val(jQuery(this).attr("value"));
      updateSelectedOption();
    });
    jQuery('#username').focus();
    var cannotLoginController = emr.setupConfirmationDialog({
      selector: '#cannotLoginPopup',
      actions: {
        confirm: function () {
          cannotLoginController.close();
        }
      }
    });
    jQuery('a#cantLogin').click(function () {
      cannotLoginController.show();
    });
    pageReady = true;
  });
</script>

<div class="container px-1 shadow-sm mb-1 bg-white rounded">
    <div class="row">
        <div class="col text-center justify-content-center">
            <img
                    src="${ui.resourceLink("patientseat", "images/loginseat.png")}"
                    class="img-thumbnail rounded mx-auto d-block mt-2"
                    alt=""/>

            <h4 class="text-center lead">PatientSeat - Hospital Services Medical Examination</h4>

            <form id="login-form" class="login-form" method="post" autocomplete="off">
                ${ui.includeFragment("referenceapplication", "infoAndErrorMessages")}
                <div class="form-group">
                    <label for="username">
                        ${ui.message("referenceapplication.login.username")}
                    </label>

                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">
                                <i class="icon-user"></i>
                            </span>
                        </div>
                        <input id="username"
                               type="text"
                               name="username"
                               class="form-control icon-user"
                               placeholder="${ui.message("referenceapplication.login.username.placeholder")}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="password">
                        ${ui.message("referenceapplication.login.password")}:
                    </label>

                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">
                                <i class="icon-key"></i>
                            </span>
                        </div>
                        <input id="password"
                               type="password"
                               name="password"
                               class="form-control icon-key"
                               placeholder="${ui.message("referenceapplication.login.password.placeholder")}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="selectLocation">Select Location:</label>
                    <select class="custom-select" name="sessionLocation" id="sessionLocationInput">
                        <option value="">Select Location</option>
                        <% locations.sort { ui.format(it) }.each { %>
                        <option value="${it.id}">${it.name}</option>
                        <% } %>
                    </select>
                </div>

                <div class="form-group row">
                    <div class="col text-left">
                        <label class="checkbox-inline">
                            <input class="form-check-input" type="checkbox"/>
                            <small class="text-primary">
                                Remember me
                            </small>
                        </label>
                    </div>

                    <div class="col text-right">
                        <a id="cantLogin" class="text-primary" href="javascript:void(0)">
                            <i class="icon-question-sign small"></i>
                            <small class="text-primary">
                                ${ui.message("Forgot password?")}
                            </small>
                        </a>
                    </div>
                </div>

                <div class="form-group">
                    <button
                            type="submit"
                            class="btn btn-primary btn-block">
                        ${ui.message("Sign in")}
                    </button>
                </div>

                <div class="form-group">
                    <input type="hidden" name="redirectUrl" value="${redirectUrl}"/>
                </div>
            </form>
        </div>

        <div class="col-8 d-none d-lg-block px-0">
            <img
                    class="img-fluid"
                    src="${ui.resourceLink("patientseat", "images/seat2.png")}"
                    width="100%"
                    height="100%"
                    alt=""/>
        </div>

        <div id="cannotLoginPopup" class="alert alert-info" style="display: none">
            <div class="dialog-header">
                <i class="icon-info-sign"></i>

                <h3>${ui.message("referenceapplication.login.cannotLogin")}</h3>
            </div>

            <div class="dialog-content">
                <p class="dialog-instructions">${ui.message("referenceapplication.login.cannotLoginInstructions")}</p>
                <button class="btn btn-success btn-block">${ui.message("referenceapplication.okay")}</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>