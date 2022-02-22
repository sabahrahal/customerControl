
<div class="modal fade" id="addModalClient">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title">Add Client</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
        <form action="${pageContext.request.contextPath}/ServletController?action=insert"
              method="POST" class="was-validated">
            <div class="modal-body">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" name="name" required/>
                </div>

                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" name="lastName" required/>
                </div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" required/>
                </div>

                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="tel" class="form-control" name="phone" required/>
                </div>

                <div class="form-group">
                    <label for="balance">Balance</label>
                    <input type="number" class="form-control" name="balance" step="any" required/>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary btn-lg bg-dark" type="submit">Save</button>
            </div>
        </form>
        </div>      
    </div>
</div>