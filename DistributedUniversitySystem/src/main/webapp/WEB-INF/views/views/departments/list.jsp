<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Department List - University Management System</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
</head>
<body>
    <!-- Header & Navigation -->
    <header>
        <div class="container">
            <h1>🎓 Distributed University Management System</h1>
            <p>Manage Students, Lecturers, Courses, and Departments</p>
        </div>
    </header>

    <nav class="container">
        <ul>
            <li><a href="<c:url value='/'/>" >Home</a></li>
            <li><a href="<c:url value='/students/list'/>">Students</a></li>
            <li><a href="<c:url value='/lecturers/list'/>">Lecturers</a></li>
            <li><a href="<c:url value='/courses/list'/>">Courses</a></li>
            <li><a href="<c:url value='/departments/list'/>" class="active">Departments</a></li>
        </ul>
    </nav>

    <!-- Main Content -->
    <main class="container">
        <div class="content-wrapper slide-in">
            <div class="flex-between">
                <h1>🏢 Department Management</h1>
                <a href="<c:url value='/departments/form'/>" class="btn btn-success">+ Add New Department</a>
            </div>

            <!-- Department Count -->
            <div class="alert alert-info mt-2 mb-3">
                <strong>Total Departments:</strong> ${departments.size()}
            </div>

            <!-- Departments Table -->
            <c:if test="${not empty departments}">
                <div class="table-responsive">
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Department Name</th>
                                <th>Office Location</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="department" items="${departments}">
                                <tr class="fade-in">
                                    <td><strong>${department.id}</strong></td>
                                    <td>${department.deptName}</td>
                                    <td>${department.officeLocation}</td>
                                    <td>
                                        <div class="action-buttons">
                                            <a href="<c:url value='/departments/edit?id=${department.id}'/>" class="btn btn-warning">Edit</a>
                                            <a href="<c:url value='/departments/delete?id=${department.id}'/>" class="btn btn-danger" onclick="return confirm('Are you sure?');">Delete</a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

            <!-- Empty State -->
            <c:if test="${empty departments}">
                <div class="alert alert-warning mt-3">
                    <strong>No Departments Found</strong>
                    <p>Click the "Add New Department" button to create the first department record.</p>
                </div>
            </c:if>

            <!-- Action Buttons -->
            <div class="btn-group">
                <a href="<c:url value='/departments/form'/>" class="btn btn-primary">Add Department</a>
                <a href="<c:url value='/'/>" class="btn btn-secondary">Back to Home</a>
            </div>
        </div>
    </main>

    <!-- Footer -->
    <footer class="container">
        <p>&copy; 2025 Distributed University Management System. All rights reserved.</p>
        <p>Developed using Spring MVC, PostgreSQL, and JSP</p>
    </footer>
</body>
</html>

