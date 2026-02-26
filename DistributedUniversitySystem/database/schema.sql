-- ============================================================================
-- PostgreSQL Schema for Distributed University Management System
-- 3NF Normalized Database Design
-- ============================================================================

-- Drop existing tables if they exist (for fresh deployment)
DROP TABLE IF EXISTS courses CASCADE;
DROP TABLE IF EXISTS students CASCADE;
DROP TABLE IF EXISTS lecturers CASCADE;
DROP TABLE IF EXISTS departments CASCADE;

-- ============================================================================
-- 1. DEPARTMENTS TABLE (Foundation - Register First)
-- ============================================================================
CREATE TABLE departments (
    id SERIAL PRIMARY KEY,
    dept_name VARCHAR(100) NOT NULL UNIQUE,
    office_location VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create index on dept_name for faster lookups
CREATE INDEX idx_departments_dept_name ON departments(dept_name);

-- ============================================================================
-- 2. LECTURERS TABLE (Second - Depends on Department)
-- ============================================================================
CREATE TABLE lecturers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    specialization VARCHAR(100) NOT NULL,
    department_id INTEGER NOT NULL REFERENCES departments(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes for lecturer searches
CREATE INDEX idx_lecturers_department_id ON lecturers(department_id);
CREATE INDEX idx_lecturers_email ON lecturers(email);
CREATE INDEX idx_lecturers_name ON lecturers(name);

-- ============================================================================
-- 3. STUDENTS TABLE (Second - Depends on Department)
-- ============================================================================
CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    enrollment_date DATE NOT NULL,
    department_id INTEGER NOT NULL REFERENCES departments(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes for student searches
CREATE INDEX idx_students_department_id ON students(department_id);
CREATE INDEX idx_students_email ON students(email);
CREATE INDEX idx_students_enrollment_date ON students(enrollment_date);

-- ============================================================================
-- 4. COURSES TABLE (Third - Depends on Department and Lecturer)
-- ============================================================================
CREATE TABLE courses (
    id SERIAL PRIMARY KEY,
    course_code VARCHAR(50) NOT NULL UNIQUE,
    title VARCHAR(100) NOT NULL,
    credits INTEGER NOT NULL CHECK (credits >= 1 AND credits <= 12),
    department_id INTEGER NOT NULL REFERENCES departments(id) ON DELETE CASCADE,
    lecturer_id INTEGER NOT NULL REFERENCES lecturers(id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes for course searches
CREATE INDEX idx_courses_department_id ON courses(department_id);
CREATE INDEX idx_courses_lecturer_id ON courses(lecturer_id);
CREATE INDEX idx_courses_course_code ON courses(course_code);

-- ============================================================================
-- Sample Data (Optional - for testing purposes)
-- ============================================================================

-- Insert sample departments (Foundation Layer)
INSERT INTO departments (dept_name, office_location) VALUES
    ('Computer Science', 'Building A, Floor 2'),
    ('Business Administration', 'Building B, Floor 3'),
    ('Engineering', 'Building C, Floor 1'),
    ('Arts and Sciences', 'Building D, Floor 4');

-- Insert sample lecturers (Second Layer)
INSERT INTO lecturers (name, email, specialization, department_id) VALUES
    ('Dr. John Smith', 'john.smith@university.edu', 'Database Systems', 1),
    ('Dr. Sarah Johnson', 'sarah.johnson@university.edu', 'Web Development', 1),
    ('Prof. Michael Brown', 'michael.brown@university.edu', 'Finance', 2),
    ('Dr. Emma Wilson', 'emma.wilson@university.edu', 'Civil Engineering', 3);

-- Insert sample students (Second Layer)
INSERT INTO students (name, email, enrollment_date, department_id) VALUES
    ('Alice Cooper', 'alice.cooper@student.edu', '2023-09-01', 1),
    ('Bob Davis', 'bob.davis@student.edu', '2023-09-01', 1),
    ('Charlie Evans', 'charlie.evans@student.edu', '2024-01-15', 2),
    ('Diana Foster', 'diana.foster@student.edu', '2024-01-15', 3);

-- Insert sample courses (Third Layer - depends on departments and lecturers)
INSERT INTO courses (course_code, title, credits, department_id, lecturer_id) VALUES
    ('CS101', 'Introduction to Computer Science', 3, 1, 1),
    ('CS201', 'Advanced Database Systems', 4, 1, 1),
    ('CS301', 'Web Development Fundamentals', 3, 1, 2),
    ('BUS101', 'Financial Accounting', 4, 2, 3),
    ('ENG101', 'Engineering Principles', 4, 3, 4);

-- ============================================================================
-- Database Statistics and Information
-- ============================================================================
-- Total Tables: 4
-- Primary Keys: 4 (id for each table)
-- Foreign Keys: 3 (department_id in lecturers, students, courses; lecturer_id in courses)
-- Unique Constraints: 3 (dept_name, lecturer email, student email, course_code)
-- Check Constraints: 1 (credits between 1-12)
-- Indexes: 13 (for optimized queries)
-- ============================================================================

