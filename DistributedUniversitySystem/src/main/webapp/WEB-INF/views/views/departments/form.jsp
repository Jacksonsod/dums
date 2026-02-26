<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${isEdit ? 'Edit' : 'Add'} Department - University Management System</title>
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
            <h1>${isEdit ? 'Edit Department' : 'Add New Department'}</h1>

            <!-- Department Form -->
            <form action="<c:url value='/departments/save'/>" method="POST" class="mt-3">
                <!-- Hidden ID field for updates -->
                <c:if test="${isEdit}">
                    <input type="hidden" name="id" value="${department.id}">
                </c:if>

                <!-- Department Name -->
                <div class="form-group">
                    <label for="deptName">Department Name <span class="text-danger">*</span></label>
                    <input type="text" id="deptName" name="deptName" value="${department.deptName}" required
                           placeholder="Enter department name (e.g., Computer Science)" maxlength="100">
                </div>

                <!-- Office Location -->
                <div class="form-group">
                    <label for="officeLocation">Office Location <span class="text-danger">*</span></label>
                    <input type="text" id="officeLocation" name="officeLocation" value="${department.officeLocation}" required
                           placeholder="Enter office location or building (e.g., Building A, Room 101)" maxlength="100">
                </div>

                <!-- Buttons -->
                <div class="btn-group">
                    <button type="submit" class="btn btn-success">
                        ${isEdit ? '✓ Update Department' : '✓ Add Department'}
                    </button>
                    <button type="reset" class="btn btn-secondary">Reset Form</button>
                    <a href="<c:url value='/departments/list'/>" class="btn btn-secondary">Cancel</a>
                </div>
            </form>

            <!-- Form Instructions -->
            <div class="alert alert-info mt-3">
                <strong>Instructions:</strong>
                <ul>
                    <li>All fields marked with <span class="text-danger">*</span> are required</li>
                    <li>Enter a unique department name</li>
                    <li>Examples: Computer Science, Business Administration, Engineering, etc.</li>
                </ul>
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

