<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${isEdit ? 'Edit' : 'Add'} Lecturer - University Management System</title>
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
            <li><a href="<c:url value='/lecturers/list'/>" class="active">Lecturers</a></li>
            <li><a href="<c:url value='/courses/list'/>">Courses</a></li>
            <li><a href="<c:url value='/departments/list'/>">Departments</a></li>
        </ul>
    </nav>

    <!-- Main Content -->
    <main class="container">
        <div class="content-wrapper slide-in">
            <h1>${isEdit ? 'Edit Lecturer' : 'Add New Lecturer'}</h1>

            <!-- Lecturer Form -->
            <form action="<c:url value='/lecturers/save'/>" method="POST" class="mt-3">
                <!-- Hidden ID field for updates -->
                <c:if test="${isEdit}">
                    <input type="hidden" name="id" value="${lecturer.id}">
                </c:if>

                <!-- Lecturer Name -->
                <div class="form-group">
                    <label for="name">Lecturer Name <span class="text-danger">*</span></label>
                    <input type="text" id="name" name="name" value="${lecturer.name}" required
                           placeholder="Enter lecturer's full name" maxlength="100">
                </div>

                <!-- Email -->
                <div class="form-group">
                    <label for="email">Email Address <span class="text-danger">*</span></label>
                    <input type="email" id="email" name="email" value="${lecturer.email}" required
                           placeholder="Enter lecturer's email address" maxlength="100">
                </div>

                <!-- Specialization -->
                <div class="form-group">
                    <label for="specialization">Specialization <span class="text-danger">*</span></label>
                    <input type="text" id="specialization" name="specialization" value="${lecturer.specialization}" required
                           placeholder="Enter field of specialization (e.g., Data Science)" maxlength="100">
                </div>

                <!-- Department Selection Dropdown -->
                <div class="form-group">
                    <label for="departmentId">Department <span class="text-danger">*</span></label>
                    <select id="departmentId" name="departmentId" required>
                        <option value="">-- Select a Department --</option>
                        <c:forEach var="department" items="${departments}">
                            <option value="${department.id}" <c:if test="${department.id == lecturer.departmentId}">selected</c:if>>
                                ${department.deptName}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <!-- Buttons -->
                <div class="btn-group">
                    <button type="submit" class="btn btn-success">
                        ${isEdit ? '✓ Update Lecturer' : '✓ Add Lecturer'}
                    </button>
                    <button type="reset" class="btn btn-secondary">Reset Form</button>
                    <a href="<c:url value='/lecturers/list'/>" class="btn btn-secondary">Cancel</a>
                </div>
            </form>

            <!-- Form Instructions -->
            <div class="alert alert-info mt-3">
                <strong>Instructions:</strong>
                <ul>
                    <li>All fields marked with <span class="text-danger">*</span> are required</li>
                    <li>Enter the lecturer's full name and their field of specialization</li>
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

