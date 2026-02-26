<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course List - University Management System</title>
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
            <li><a href="<c:url value='/courses/list'/>" class="active">Courses</a></li>
            <li><a href="<c:url value='/departments/list'/>">Departments</a></li>
        </ul>
    </nav>

    <!-- Main Content -->
    <main class="container">
        <div class="content-wrapper slide-in">
            <div class="flex-between">
                <h1>📚 Course Management</h1>
                <a href="<c:url value='/courses/form'/>" class="btn btn-success">+ Add New Course</a>
            </div>

            <!-- Course Count -->
            <div class="alert alert-info mt-2 mb-3">
                <strong>Total Courses:</strong> ${courses.size()}
            </div>

            <!-- Courses Table -->
            <c:if test="${not empty courses}">
                <div class="table-responsive">
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Course Code</th>
                                <th>Title</th>
                                <th>Credits</th>
                                <th>Department</th>
                                <th>Lecturer</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="course" items="${courses}">
                                <tr class="fade-in">
                                    <td><strong>${course.id}</strong></td>
                                    <td>${course.courseCode}</td>
                                    <td>${course.title}</td>
                                    <td><span class="badge badge-primary">${course.credits} credits</span></td>
                                    <td><span class="badge badge-info">${course.departmentName}</span></td>
                                    <td>${course.lecturerName}</td>
                                    <td>
                                        <div class="action-buttons">
                                            <a href="<c:url value='/courses/edit?id=${course.id}'/>" class="btn btn-warning">Edit</a>
                                            <a href="<c:url value='/courses/delete?id=${course.id}'/>" class="btn btn-danger" onclick="return confirm('Are you sure?');">Delete</a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

            <!-- Empty State -->
            <c:if test="${empty courses}">
                <div class="alert alert-warning mt-3">
                    <strong>No Courses Found</strong>
                    <p>Click the "Add New Course" button to create the first course record.</p>
                </div>
            </c:if>

            <!-- Action Buttons -->
            <div class="btn-group">
                <a href="<c:url value='/courses/form'/>" class="btn btn-primary">Add Course</a>
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

