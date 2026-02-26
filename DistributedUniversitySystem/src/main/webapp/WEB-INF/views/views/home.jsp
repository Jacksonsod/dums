<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Distributed University Management System</title>
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
            <li><a href="<c:url value='/'/>" class="active">Home</a></li>
            <li><a href="<c:url value='/students/list'/>">Students</a></li>
            <li><a href="<c:url value='/lecturers/list'/>">Lecturers</a></li>
            <li><a href="<c:url value='/courses/list'/>">Courses</a></li>
            <li><a href="<c:url value='/departments/list'/>">Departments</a></li>
        </ul>
    </nav>

    <!-- Main Content -->
    <main class="container">
        <div class="content-wrapper slide-in">
            <h1>Welcome to University Management System</h1>

            <div class="grid grid-2">
                <!-- Students Card -->
                <div class="card">
                    <div class="card-header">👨‍🎓 Student Management</div>
                    <div class="card-body">
                        <p>Manage student records including personal information, contact details, and department assignments.</p>
                        <p class="text-muted mt-2">Create, read, update, and delete student records efficiently.</p>
                    </div>
                    <div class="card-footer">
                        <a href="<c:url value='/students/list'/>" class="btn btn-primary">Manage Students</a>
                    </div>
                </div>

                <!-- Lecturers Card -->
                <div class="card">
                    <div class="card-header">👨‍🏫 Lecturer Management</div>
                    <div class="card-body">
                        <p>Manage faculty members and their specializations.</p>
                        <p class="text-muted mt-2">View, add, update, and delete lecturer information.</p>
                    </div>
                    <div class="card-footer">
                        <a href="<c:url value='/lecturers/list'/>" class="btn btn-primary">Manage Lecturers</a>
                    </div>
                </div>

                <!-- Courses Card -->
                <div class="card">
                    <div class="card-header">📚 Course Management</div>
                    <div class="card-body">
                        <p>Manage courses, assign lecturers, and set course credits.</p>
                        <p class="text-muted mt-2">Complete course catalog management system.</p>
                    </div>
                    <div class="card-footer">
                        <a href="<c:url value='/courses/list'/>" class="btn btn-primary">Manage Courses</a>
                    </div>
                </div>

                <!-- Departments Card -->
                <div class="card">
                    <div class="card-header">🏢 Department Management</div>
                    <div class="card-body">
                        <p>Manage academic departments and their information.</p>
                        <p class="text-muted mt-2">Organize university structure efficiently.</p>
                    </div>
                    <div class="card-footer">
                        <a href="<c:url value='/departments/list'/>" class="btn btn-primary">Manage Departments</a>
                    </div>
                </div>
            </div>

            <!-- System Features -->
            <div class="card mt-3">
                <div class="card-header">✨ System Features</div>
                <div class="card-body">
                    <ul style="list-style: none; padding: 0;">
                        <li class="mb-2">✓ Complete CRUD operations for all entities</li>
                        <li class="mb-2">✓ Spring MVC architecture with XML configuration</li>
                        <li class="mb-2">✓ PostgreSQL database integration via JdbcTemplate</li>
                        <li class="mb-2">✓ Responsive and modern UI with JSTL</li>
                        <li class="mb-2">✓ Data validation in service layer</li>
                        <li class="mb-2">✓ Professional CSS styling</li>
                        <li class="mb-2">✓ RESTful-style URL patterns</li>
                        <li class="mb-2">✓ Error handling and user feedback</li>
                    </ul>
                </div>
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

