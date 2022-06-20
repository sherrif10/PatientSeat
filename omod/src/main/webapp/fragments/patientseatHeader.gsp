<%
    def addContextPath = {
        if (!it)
            return null
        if (it.startsWith("/")) {
            it = "/" + org.openmrs.ui.framework.WebConstants.CONTEXT_PATH + it
        }
        return it
    }
    def logoIconUrl = addContextPath(configSettings?."logo-icon-url") ?: ui.resourceLink("patientseat", "images/loginseat.png")
    def logoLinkUrl = addContextPath(configSettings?."logo-link-url") ?: "/${org.openmrs.ui.framework.WebConstants.CONTEXT_PATH}"
    def multipleServicePoints = (servicePoints.size > 1);
    def enableUserAccountExt = userAccountMenuItems.size > 0;
%>
<script type="text/javascript" xmlns="http://www.w3.org/1999/html">
    jq( document ).ready(function() {
        jq('[data-toggle=search-form]').click(function() {
            jq('.search-form-wrapper').toggleClass('open');
            jq('.search-form-wrapper .search').focus();
            jq('html').toggleClass('search-form-open');
          });
          jq('[data-toggle=search-form-close]').click(function() {
            jq('.search-form-wrapper').removeClass('open');
            jq('html').removeClass('search-form-open');
          });
        jq('.search-form-wrapper .search').keypress(function( event ) {
          if(jq(this).val() == "Search") jq(this).val("");
        });

        jq('.search-close').click(function(event) {
          jq('.search-form-wrapper').removeClass('open');
          jq('html').removeClass('search-form-open');
        });
    });
</script>

<script type="text/javascript">
    var sessionLocationModel = {
      id: ko.observable(),
      text: ko.observable()
    };
    jq(function () {
      ko.applyBindings(sessionLocationModel, jq('.change-location').get(0));
      sessionLocationModel.id(${ servicePointVisited?.locationId });
      sessionLocationModel.text("${ ui.format(servicePointVisited) }");
      // we only want to activate the functionality to change location if there are actually multiple login locations
      <% if (multipleServicePoints) { %>
      jq(".change-location a").click(function () {
        jq('#session-location').show();
        jq(this).addClass('focus');
        jq(".change-location a i:nth-child(3)").removeClass("icon-caret-down");
        jq(".change-location a i:nth-child(3)").addClass("icon-caret-up");
      });
      jq('#session-location').mouseleave(function () {
        jq('#session-location').hide();
        jq(".change-location a").removeClass('focus');
        jq(".change-location a i:nth-child(3)").addClass("icon-caret-down");
        jq(".change-location a i:nth-child(3)").removeClass("icon-caret-up");
      });
      jq("#session-location ul.select li").click(function (event) {
        var element = jq(event.target);
        var locationId = element.attr("locationId");
        var locationUuid = element.attr("locationUuid");
        var locationName = element.attr("locationName");
        var data = {locationId: locationId};
        jq("#spinner").show();
        jq.post(emr.fragmentActionLink("patientseat", "patientseatHeader", "setCurrentServiceDeliveryLocation", data), function (data) {
          sessionLocationModel.id(locationId);
          sessionLocationModel.text(locationName);
          jq('#selected-location').attr("location-uuid", locationUuid);
          jq('#session-location li').removeClass('selected');
          element.addClass('selected');
          jq("#spinner").hide();
          jq(document).trigger("sessionLocationChanged");
            locationUuid = data.locationUuid;
            if (locationUuid === '${artServicesUuid}') {
                // ART Services
                location.href = '${ui.pageLink("patientseat", "art/artDashboard")}';
            } else if (locationUuid === '${registrationPageUuid}') {
                // Registration page
                location.href = '${ui.pageLink("patientseat", "registrationAdminDashboard?appId=patientseat.registrationAdminDashboard")}';
                 location.reload()
            }
        })
        jq('#session-location').hide();
        jq(".change-location a").removeClass('focus');
        jq(".change-location a i:nth-child(3)").addClass("icon-caret-down");
        jq(".change-location a i:nth-child(3)").removeClass("icon-caret-up");
      });
      <% if (enableUserAccountExt) { %>
      jq('.identifier').hover(
          function () {
            jq('.appui-toggle').show();
            jq('.appui-icon-caret-down').hide();
          },
          function () {
            jq('.appui-toggle').hide();
            jq('.appui-icon-caret-down').show();
          }
      );
      jq('.identifier').css('cursor', 'pointer');
      <% } %>
      <% } %>
    });
</script>
<header class="header">
    <nav id="navbar" class="navbar navbar-expand-lg navbar-light bg-primary">
        <div class="container-fluid">
            <div class="col pl-0">
                <button class="btn btn-sm btn-primary px-0 py-0"
                        type="button"
                        id="sidebarCollapse">
                    <i class="fa fa-bars fa-2x"></i>
                </button>
            </div>
            <div class="col">
                <h4 class="lead text-white justify-content-center">
                    ${hospital}
                </h4>
            </div>

            <button class="btn btn-sm btn-primary px-0 py-0 d-lg-none ml-auto"
                   type="button"
                   data-toggle="collapse"
                   data-target="#navbarSupportedContent"
                   aria-controls="navbarSupportedContent"
                   aria-expanded="false"
                   aria-label="Toggle navigation">
               <i class="fas fa fa-bars fa-2x"></i>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <% if (context.authenticated) { %>
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-link">
                            <% if(administrativeActions.size() != 0 &&
                                  context.getAuthenticatedUser().hasRole("Administrator", false)) {%>
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-bell text-white pl-2"></i>
                                    <span class="label label-danger text-white px-1 py-1">${administrativeActions.size()}</span>
                                </a>

                                <ul class="dropdown-menu">
                                    <h4 class="px-4 py-2 text-success">
                                        You have <% (administrativeActions.size() == 1) ? println("1 pending action") : println("${administrativeActions.size()} pending actions") %>
                                    </h4>
                                    <li>
                                        <!-- inner menu: contains the actual data -->
                                        <ul class="menu">
                                            <% administrativeActions.each {%>
                                                <div class="col">
                                                    <li class="list-group-item py-2">
                                                        <a href="${it.getUrl()}" class="py-0">
                                                            <span class="text-primary">
                                                                <i class="fa fa-tasks"></i>&nbsp;${it.getUrl()}
                                                            </span>
                                                        </a>
                                                    </li>
                                                </div>
                                            <% } %>
                                        </ul>
                                    </li>
                                </ul>
                            <% } else if(alertNotifications.size() != 0) {%>
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-bell text-white pl-2"></i>
                                    <span class="label label-danger text-white px-1 py-1">${alertNotifications.size()}</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <h4 class="px-4 py-2 text-success">
                                        You have <% (alertNotifications.size() == 1) ? println("1 notification") : println("${alertNotifications.size()} notifications") %>
                                    </h4>
                                    <li>
                                        <ul class="list-group">
                                            <% alertNotifications.each {%>
                                                <div class="col">
                                                    <li class="list-group-item py-1">
                                                        <span class="text-primary">
                                                            <i class="fa fa-info-circle text-primary"></i>
                                                            <span class="text-muted">
                                                                <span class="text-danger">Message</span> ${it.getText()} sent on
                                                                <span class="text-danger">${it.getDateCreated().format("dd-MMM-yyyy")}</span> at
                                                                <span class="text-danger">${it.getDateCreated().format("HH:mm")}</span> by
                                                            </span> ${it.getCreator()}
                                                        </span>
                                                    </li>
                                                </div>
                                            <% } %>
                                        </ul>
                                    </li>
                                </ul>
                            <% } else { %>
                                <li class="nav-link">
                                    <i class="fa fa-bell text-white"></i>
                                    <span class="label label-danger text-white">0</span>
                                </li>
                            <% } %>
                        </li>
                        <li class="nav-item">
                           <a href="#search"
                              class="search-form-trigger btn btn-primary pl-2"
                              data-toggle="search-form">
                                 <i class="fa fa-search" aria-hidden="true"></i>
                           </a>
                        </li>
                        <li class="identifier">
                            <i class="icon-user small"></i>
                            ${context.authenticatedUser.username ?: context.authenticatedUser.systemId}
                            <% if (enableUserAccountExt) { %>
                            <i class="icon-caret-down appui-icon-caret-down link"></i>
                            <i class="icon-caret-up link appui-toggle" style="display: none;"></i>
                            <ul id="user-account-menu" class="appui-toggle">
                                <% userAccountMenuItems.each { menuItem -> %>
                                <li>
                                    <a id="" href="/${contextPath}/${menuItem.url}">
                                        ${ui.message(menuItem.label)}
                                    </a>
                                </li>
                                <% } %>
                            </ul>
                            <% } %>
                        </li>
                        <li class="change-location">
                            <a href="javascript:void(0);">
                                <i class="icon-map-marker small"></i>
                                <span id="selected-location" data-bind="text: text" location-uuid="${ servicePointVisited ? servicePointVisited.uuid : '' }"></span>
                                <% if (multipleServicePoints) { %>
                                <i class="icon-caret-down link"></i>
                                <% } %>
                            </a>
                        </li>
                        <li class="logout">
                            <a href="/${contextPath}/ms/logout">
                                 <i class="icon-signout small"></i>
                                ${ui.message("emr.logout")}
                            </a>
                        </li>
                    </ul>

                    <div id="session-location">
                        <div id="spinner" style="position:absolute; display:none">
                            <img src="${ui.resourceLink('uicommons', 'images/spinner.gif')}">
                        </div>
                        <ul class="select">
                            <%  servicePoints.sort { ui.format(it) }.each {
                                def selected = (it == servicePointVisited) ? "selected" : ""
                            %>
                            <li class="${selected}" locationId="${it.id}" locationName="${ui.format(it)}">${ui.format(it)}</li>
                            <% } %>
                        </ul>
                    </div>
                <% } %>
            </div>
        </div>
    </nav>
    <div id="search-form-wrapper" class="search-form-wrapper">
        <div class="row justify-content-center">
            <div class="col col-sm-7 col-md-7 col-lg-7">
                ${ ui.includeFragment("patientseat", "findPatient",[isRegistrationPage: isRegistrationPage])}
            </div>
        </div>
    </div>
</header>
