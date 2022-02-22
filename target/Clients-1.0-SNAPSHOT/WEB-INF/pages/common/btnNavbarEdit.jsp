<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-lg btn-block">
                    <i class="fas fa-arrow-left"></i> Return
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-lg btn-block">
                    <i class="fas fa-check"></i> Save Client
                </button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletController?action=delete&idClient=${client.idClient}"
                   class="btn btn-primary btn-danger btn-lg"><li class="fas fa-trash"></li>
                    Delete</a>
            </div>
        </div>
    </div>
</section>