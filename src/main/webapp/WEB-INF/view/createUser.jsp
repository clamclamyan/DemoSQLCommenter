<jsp:include page="index.jsp"/>
<body>
<div class="jumbotron vertical-center">
    <div class="container">
        <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-people-fill"
             viewBox="0 0 16 16">
            <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
            <path fill-rule="evenodd"
                  d="M5.216 14A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216z"/>
            <path d="M4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z"/>
        </svg>

        <h3>Create a user</h3>
        <form action="/add" method="POST" id="userForm">
            <div class="mb-3">
                <input name="nameInput" type="text" class="form-control" id="nameInput" placeholder="Name"
                       required="true">
                <input name="emailInput" type="email" class="form-control" id="emailInput" placeholder="Email">
            </div>
            <input type="image" src="/resources/ocicon.png" class="iconSubmit" name="opencensus" title="Create with OpenCensus tracing">
            <input type="image" src="/resources/oticon.png" class="iconSubmit" name="opentelemetry" title="Create with OpenTelemetry tracing">
        </form>
    </div>
</div>
</body>
