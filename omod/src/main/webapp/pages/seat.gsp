<div class="card px-0">
    <div class="row">
        <div class="col col-sm-12 col-md-12 col-lg-3 pl-3">
            <span class="text-primary">
                <i class="fa fa-user"></i> NAME:
                    ${patient.person.personName.givenName}&nbsp;${patient.person.personName.familyName}
            </span>
        </div>
        <div class="col col-sm-12 col-md-12 col-lg-2 pl-0">
            <span class="text-success">
                <i class="fa fa-id-badge"></i> PIN: ${pin}
            </span>
        </div>
        <div class="col col-sm-12 col-md-12 col-lg-3 pl-0">
            <span>
                ${identifierType}:&nbsp;<span class="text-danger">${identifierValue}</span>
            </span>
        </div>
        <div class="col col-sm-12 col-md-12 col-lg-3">
            <% if(activePatientVisit) {%>
                <span class="badge badge-pill badge-success">
                    <i class="fa fa-h-square"></i>
                    Active Visit
                    <i class="fa fa fa-clock-o"></i>
                    ${activePatientVisit.startDatetime}
                </span>
            <% } %>
        </div>
    </div>
</div>