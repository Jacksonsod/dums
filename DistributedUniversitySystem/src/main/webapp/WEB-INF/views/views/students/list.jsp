<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List - University Management System</title>
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
            <li><a href="<c:url value='/students/list'/>" class="active">Students</a></li>
            <li><a href="<c:url value='/lecturers/list'/>">Lecturers</a></li>
            <li><a href="<c:url value='/courses/list'/>">Courses</a></li>
            <li><a href="<c:url value='/departments/list'/>">Departments</a></li>
        </ul>
    </nav>

    <!-- Main Content -->
    <main class="container">
        <div class="content-wrapper slide-in">
            <div class="flex-between">
                <h1>👨‍🎓 Student Management</h1>
                <a href="<c:url value='/students/form'/>" class="btn btn-success">+ Add New Student</a>
            </div>

            <!-- Student Count -->
            <div class="alert alert-info mt-2 mb-3">
                <strong>Total Students:</strong> ${students.size()}
            </div>

            <!-- Students Table -->
            <c:if test="${not empty students}">
                <div class="table-responsive">
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Enrollment Date</th>
                                <th>Department</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="student" items="${students}">
                                <tr class="fade-in">
                                    <td><strong>${student.id}</strong></td>
                                    <td>${student.name}</td>
                                    <td><a href="mailto:${student.email}">${student.email}</a></td>
                                    <td>${student.enrollmentDate}</td>
                                    <td><span class="badge badge-primary">${student.departmentName}</span></td>
                                    <td>
                                        <div class="action-buttons">
                                            <a href="<c:url value='/students/edit?id=${student.id}'/>" class="btn btn-warning">Edit</a>
                                            <a href="<c:url value='/students/delete?id=${student.id}'/>" class="btn btn-danger" onclick="return confirm('Are you sure?');">Delete</a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

            <!-- Empty State -->
            <c:if test="${empty students}">
                <div class="alert alert-warning mt-3">
                    <strong>No Students Found</strong>
                    <p>Click the "Add New Student" button to create the first student record.</p>
                </div>
            </c:if>

            <!-- Action Buttons -->
            <div class="btn-group">
                <a href="<c:url value='/students/form'/>" class="btn btn-primary">Add Student</a>
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

