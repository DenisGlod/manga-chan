<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <c:import url="/WEB-INF/part/head.jsp"></c:import>
</head>
<body>
<header>
    <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container">
            <a href="/freebook/page/user" class="navbar-brand d-flex align-items-center">
                <i class="bi bi-book me-2"></i>
                <strong> Free Book</strong>
            </a>
            <div class="md-flex justify-content-md-end">
                <a class="btn btn-outline-success btn-sm" href="user/account" role="button">Account</a>
                <a class="btn btn-outline-danger btn-sm" href="user.do?action=logOut" role="button">Log Out</a>
            </div>
            <!-- <form action="user.do" method="get">
                <button type="submit" class="btn btn-outline-danger btn-sm" value="logOut" name="action">Log Out</button>
            </form> -->
            <!-- <button type="submit" class="btn btn-outline-success btn-sm" value="account" name="action">Account</button> -->
        </div>
    </div>
</header>
<main>
    <div class="album py-5 bg-light">
        <div class="container">
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-md-4 g-3">
                <c:forEach var="book" items="${sessionScope.listBook}">
                    <div class="col">
                        <div class="card h-100 shadow-sm">
                            <div class="bd-placeholder-img card-img-top d-flex align-items-center justify-content-center"
                                 style="background-color: #454545; width: 100%; height: 225px">
                                <i class="bi bi-card-image" style="font-size: 3rem; color: white;"></i>
                            </div>
                            <div class="card-header">
                                <h5 class="card-title">${book.name}</h5>
                            </div>
                            <div class="card-body">
                                <div class="card-text">
                                    <p>id: ${book.id}<br>
                                        author: ${book.author}<br>
                                        publisher: ${book.publisher}<br>
                                        binding: ${book.binding}<br>
                                        ageRestrictions: ${book.ageRestrictions}<br>
                                        isbn: ${book.isbn}<br>
                                        publishingYear: ${book.publishingYear}</p>
                                    <p class="text-truncate" style="max-height: 150px;">
                                        description: ${book.description}</p>
                                </div>
                            </div>
                            <div class="card-footer text-end">
                                <button type="button" class="btn btn-outline-success">
                                    <i class="bi bi-bookmark-fill" style="font-size: 1rem;"></i>
                                    <span class="visually-hidden">Button</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</main>
<footer class="text-muted py-5">
    <div class="container">
        <p class="float-end mb-1">
            <a href="#">Back to top</a>
        </p>
        <p class="mb-1">Free Book &copy; 2020</p>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%-- <c:forEach var="book" items="${sessionScope.listBook}">
		<p>book.id -> ${book.id}</p>
		<p>book.name -> ${book.name}</p>
		<p>book.publisher -> ${book.publisher}</p>
		<p>book.binding -> ${book.binding}</p>
		<p>book.ageRestrictions -> ${book.ageRestrictions}</p>
		<p>book.isbn -> ${book.isbn}</p>
		<p>book.description -> ${book.description}</p>
		<p>book.publishingYear -> ${book.publishingYear}</p>
		<p>book.name -> ${book.name}</p>
	</c:forEach> --%>
