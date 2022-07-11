
<%
    ui.decorateWith("appui", "standardEmrPage");
    ui.includeJavascript("appui", "bootstrap.min.js")
    ui.includeCss("patientSeat", "dataTables.css")
    ui.includeCss("uicommons", "datetimepicker.css")
%>
<script type="text/javascript">
  
</script>
<br/>

<div class="info-body">
   <div>
        <h3>
            <strong>${ ui.message("PATIENT SEAT MANAGEMENT") }</strong>
        </h3>
    <div>      
</div>
<div class="row">
    <div class="col">
          <ul class="nav nav-pills mb-3 shadow-sm" id="pills-tab" role="tablist">
           <li class="nav-item">
                  <li class="nav-item">
                </li>
                </li>
                <li class="nav-item">
                    <a  class="nav-link" id="pills-payment-methods-tab"
                            <img src="${ui.resourceLink('patientSeat', 'images/seat32.png')}" /> Assigned to Doctor in Triage
                    </a>
                </li>
          </ul>
    </div>

    <div class="table-responsive">
    <table  class="table table-sm table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date Created</th>
            <th>Created by</th>
            <th>Actions</th>
        </tr>
        </thead>
    </table>
</div>

</div>