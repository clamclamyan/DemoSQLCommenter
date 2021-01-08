<jsp:include page="index.jsp" />
<div class="container">
    <h1 class="display-6">Create a user</h1>
    <form action="/add" method="POST" id="userForm">
        <div class="mb-3">
            <label for="nameInput" class="form-label">Name</label>
            <input name="nameInput" type="text" class="form-control" id="nameInput">
        </div>
        <div class="mb-3">
            <label for="emailInput" class="form-label">Email</label>
            <input name="emailInput" type="email" class="form-control" id="emailInput">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>