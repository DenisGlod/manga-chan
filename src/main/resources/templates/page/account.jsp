<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <form action="user.do" method="get">
                <button type="submit" class="btn btn-outline-success btn-sm" value="account" name="action">Account
                </button>
                <button type="submit" class="btn btn-outline-danger btn-sm" value="logOut" name="action">Log Out
                </button>
            </form>
        </div>
    </div>
</header>
<main>
    <div class="album py-5 bg-light">
        <div class="container">
            <div class="row row-cols-1 g-3">
                <h4 class="mb-3">Account settings</h4>
                <form class="needs-validation" action="/freebook/page/user.do" method="post">
                    <div class="row g-3">
                        <div class="col-sm-3">
                            <label for="lastName" class="form-label">Last name</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" placeholder=""
                                   value="${sessionScope.authentication.userData.lastName}" required>
                            <div class="invalid-feedback">Valid last name is required.</div>
                        </div>
                        <div class="col-sm-3">
                            <label for="firstName" class="form-label">First name</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder=""
                                   value="${sessionScope.authentication.userData.firstName}" required>
                            <div class="invalid-feedback">Valid first name is required.</div>
                        </div>
                        <div class="col-sm-3">
                            <label for="middleName" class="form-label">Middle name</label>
                            <input type="text" class="form-control" id="middleName" name="middleName" placeholder=""
                                   value="${sessionScope.authentication.userData.middleName}">
                        </div>
                        <div class="col-sm-3">
                            <label for="age" class="form-label">Age</label>
                            <input type="date" class="form-control" id="age" name="age" placeholder=""
                                   value="<fmt:formatDate pattern="yyyy-MM-dd" value="${sessionScope.authentication.userData.age}" />">
                        </div>
                        <div class="col-12">
                            <label for="email" class="form-label"> Email </label>
                            <input type="email" class="form-control" id="email" name="email"
                                   placeholder="you@example.com" value="${sessionScope.authentication.email}">
                            <div class="invalid-feedback">Please enter a valid email address for shipping updates.</div>
                        </div>
                        <div class="col-12">
                            <label for="password" class="form-label"> Password </label>
                            <input type="password" class="form-control" id="password" name="password" placeholder=""
                                   value="${sessionScope.authentication.password}">
                            <div class="invalid-feedback">Please enter password.</div>
                        </div>
                    </div>
                    <hr class="my-4">
                    <button class="w-100 btn btn-primary btn-lg" type="submit" name="action"
                            value="saveAccountSettings">Save
                    </button>
                </form>
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