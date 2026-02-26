<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${isEdit ? 'Edit' : 'Add'} Course - University Management System</title>
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
            <h1>${isEdit ? 'Edit Course' : 'Add New Course'}</h1>

            <!-- Course Form -->
            <form action="<c:url value='/courses/save'/>" method="POST" class="mt-3">
                <!-- Hidden ID field for updates -->
                <c:if test="${isEdit}">
                    <input type="hidden" name="id" value="${course.id}">
                </c:if>

                <!-- Course Code -->
                <div class="form-group">
                    <label for="courseCode">Course Code <span class="text-danger">*</span></label>
                    <input type="text" id="courseCode" name="courseCode" value="${course.courseCode}" required
                           placeholder="Enter unique course code (e.g., CS101)" maxlength="50">
                </div>

                <!-- Course Title -->
                <div class="form-group">
                    <label for="title">Course Title <span class="text-danger">*</span></label>
                    <input type="text" id="title" name="title" value="${course.title}" required
                           placeholder="Enter course title" maxlength="100">
                </div>

                <!-- Credits -->
                <div class="form-group">
                    <label for="credits">Credits <span class="text-danger">*</span></label>
                    <input type="number" id="credits" name="credits" value="${course.credits}" required
                           placeholder="Enter number of credits" min="1" max="12">
                </div>

                <!-- Department Selection Dropdown -->
                <div class="form-group">
                    <label for="departmentId">Department <span class="text-danger">*</span></label>
                    <select id="departmentId" name="departmentId" required>
                        <option value="">-- Select a Department --</option>
                        <c:forEach var="department" items="${departments}">
                            <option value="${department.id}" <c:if test="${department.id == course.departmentId}">selected</c:if>>
                                ${department.deptName}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <!-- Lecturer Selection -->
                <div class="form-group">
                    <label for="lecturerId">Lecturer <span class="text-danger">*</span></label>
                    <select id="lecturerId" name="lecturerId" required>
                        <option value="">-- Select a Lecturer --</option>
                        <c:forEach var="lecturer" items="${lecturers}">
                            <option value="${lecturer.id}" <c:if test="${lecturer.id == course.lecturerId}">selected</c:if>>
                                ${lecturer.name} (${lecturer.specialization})
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <!-- Buttons -->
                <div class="btn-group">
                    <button type="submit" class="btn btn-success">
                        ${isEdit ? '✓ Update Course' : '✓ Add Course'}
                    </button>
                    <button type="reset" class="btn btn-secondary">Reset Form</button>
                    <a href="<c:url value='/courses/list'/>" class="btn btn-secondary">Cancel</a>
                </div>
            </form>

            <!-- Form Instructions -->
            <div class="alert alert-info mt-3">
                <strong>Instructions:</strong>
                <ul>
                    <li>All fields marked with <span class="text-danger">*</span> are required</li>
                    <li>Credits should be between 1 and 12</li>
                    <li>Select a lecturer from the available list</li>
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

