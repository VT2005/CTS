-- Create the database
CREATE DATABASE EventPortal;
USE EventPortal;

-- Create Users table
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(100) NOT NULL,
    registration_date DATE NOT NULL
);

-- Create Events table
CREATE TABLE Events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    city VARCHAR(100) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    status ENUM('upcoming','completed','cancelled'),
    organizer_id INT,
    FOREIGN KEY (organizer_id) REFERENCES Users(user_id)
);

-- Create Sessions table
CREATE TABLE Sessions (
    session_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    title VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Create Registrations table
CREATE TABLE Registrations (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    registration_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Create Feedback table
CREATE TABLE Feedback (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comments TEXT,
    feedback_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Create Resources table
CREATE TABLE Resources (
    resource_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    resource_type ENUM('pdf','image','link'),
    resource_url VARCHAR(255) NOT NULL,
    uploaded_at DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);
-- Insert into Users
INSERT INTO Users (user_id, full_name, email, city, registration_date) VALUES
(1, 'Alice Johnson', 'alice@example.com', 'New York', '2024-12-01'),
(2, 'Bob Smith', 'bob@example.com', 'Los Angeles', '2024-12-05'),
(3, 'Charlie Lee', 'charlie@example.com', 'Chicago', '2024-12-10'),
(4, 'Diana King', 'diana@example.com', 'New York', '2025-01-15'),
(5, 'Ethan Hunt', 'ethan@example.com', 'Los Angeles', '2025-02-01');

-- Insert into Events
INSERT INTO Events (event_id, title, description, city, start_date, end_date, status, organizer_id) VALUES
(1, 'Tech Innovators Meetup', 'A meetup for tech enthusiasts.', 'New York', '2025-06-10 10:00:00', '2025-06-10 16:00:00', 'upcoming', 1),
(2, 'AI & ML Conference', 'Conference on AI and ML advancements.', 'Chicago', '2025-05-15 09:00:00', '2025-05-15 17:00:00', 'completed', 3),
(3, 'Frontend Development Bootcamp', 'Hands-on training on frontend tech.', 'Los Angeles', '2025-07-01 10:00:00', '2025-07-03 16:00:00', 'upcoming', 2);

-- Insert into Sessions
INSERT INTO Sessions (session_id, event_id, title, speaker_name, start_time, end_time) VALUES
(1, 1, 'Opening Keynote', 'Dr. Tech', '2025-06-10 10:00:00', '2025-06-10 11:00:00'),
(2, 1, 'Future of Web Dev', 'Alice Johnson', '2025-06-10 11:15:00', '2025-06-10 12:30:00'),
(3, 2, 'AI in Healthcare', 'Charlie Lee', '2025-05-15 09:30:00', '2025-05-15 11:00:00'),
(4, 3, 'Intro to HTML5', 'Bob Smith', '2025-07-01 10:00:00', '2025-07-01 12:00:00');

-- Insert into Registrations
INSERT INTO Registrations (registration_id, user_id, event_id, registration_date) VALUES
(1, 1, 1, '2025-05-01'),
(2, 2, 1, '2025-05-02'),
(3, 3, 2, '2025-04-30'),
(4, 4, 2, '2025-04-28'),
(5, 5, 3, '2025-06-15');

-- Insert into Feedback
INSERT INTO Feedback (feedback_id, user_id, event_id, rating, comments, feedback_date) VALUES
(1, 3, 2, 4, 'Great insights!', '2025-05-16'),
(2, 4, 2, 5, 'Very informative.', '2025-05-16'),
(3, 2, 1, 3, 'Could be better.', '2025-06-11');

-- Insert into Resources
INSERT INTO Resources (resource_id, event_id, resource_type, resource_url, uploaded_at) VALUES
(1, 1, 'pdf', 'https://portal.com/resources/tech_meetup_agenda.pdf', '2025-05-01 10:00:00'),
(2, 2, 'image', 'https://portal.com/resources/ai_poster.jpg', '2025-04-20 09:00:00'),
(3, 3, 'link', 'https://portal.com/resources/html5_docs', '2025-06-25 15:00:00');

-- TASK 1
SELECT 
    u.full_name,
    e.title AS event_title,
    e.city,
    e.start_date
FROM 
    Users u
JOIN 
    Registrations r ON u.user_id = r.user_id
JOIN 
    Events e ON r.event_id = e.event_id
WHERE 
    e.status = 'upcoming' 
    AND u.city = e.city
ORDER BY 
    e.start_date;
    
    
    
-- TASK 2
SELECT 
    e.title AS event_title,
    COUNT(f.feedback_id) AS feedback_count,
    ROUND(AVG(f.rating), 2) AS average_rating
FROM 
    Feedback f
JOIN 
    Events e ON f.event_id = e.event_id
GROUP BY 
    f.event_id
HAVING 
    COUNT(f.feedback_id) >= 10
ORDER BY 
    average_rating DESC;




-- TASK 3
SELECT 
    u.user_id,
    u.full_name,
    u.email,
    u.city,
    u.registration_date
FROM 
    Users u
WHERE 
    u.user_id NOT IN (
        SELECT 
            r.user_id
        FROM 
            Registrations r
        WHERE 
            r.registration_date >= DATE_SUB(CURDATE(), INTERVAL 90 DAY)
    );
    
    
    
-- TASK 4
    SELECT 
    e.title AS event_title,
    COUNT(s.session_id) AS session_count
FROM 
    Sessions s
JOIN 
    Events e ON s.event_id = e.event_id
WHERE 
    TIME(s.start_time) BETWEEN '10:00:00' AND '12:00:00'
GROUP BY 
    s.event_id;



-- TASK 5
SELECT 
    u.city,
    COUNT(DISTINCT r.user_id) AS user_count
FROM 
    Registrations r
JOIN 
    Users u ON r.user_id = u.user_id
GROUP BY 
    u.city
ORDER BY 
    user_count DESC
LIMIT 5;


-- TASK 6
SELECT 
    e.title AS event_title,
    r.resource_type,
    COUNT(r.resource_id) AS resource_count
FROM 
    Resources r
JOIN 
    Events e ON r.event_id = e.event_id
GROUP BY 
    r.event_id, r.resource_type;
    
    
-- TASK 7
SELECT 
    u.full_name,
    e.title AS event_title,
    f.rating,
    f.comments
FROM 
    Feedback f
JOIN 
    Users u ON f.user_id = u.user_id
JOIN 
    Events e ON f.event_id = e.event_id
WHERE 
    f.rating < 3;
    
    
-- TASK 8
SELECT 
    e.title AS event_title,
    COUNT(s.session_id) AS session_count
FROM 
    Events e
LEFT JOIN 
    Sessions s ON e.event_id = s.event_id
WHERE 
    e.status = 'upcoming'
GROUP BY 
    e.event_id;
    
    
-- TASK 9
SELECT 
    u.full_name AS organizer_name,
    COUNT(e.event_id) AS total_events,
    SUM(e.status = 'upcoming') AS upcoming_events,
    SUM(e.status = 'completed') AS completed_events,
    SUM(e.status = 'cancelled') AS cancelled_events
FROM 
    Events e
JOIN 
    Users u ON e.organizer_id = u.user_id
GROUP BY 
    e.organizer_id;
    
    
-- TASK 10
SELECT DISTINCT e.event_id, e.title
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
LEFT JOIN Feedback f ON e.event_id = f.event_id
WHERE f.event_id IS NULL;


-- TASK 11
SELECT 
    registration_date, 
    COUNT(*) AS new_user_count
FROM 
    Users
WHERE 
    registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY 
    registration_date
ORDER BY 
    registration_date;



-- TASK 12
SELECT event_id, COUNT(*) AS session_count
FROM Sessions
GROUP BY event_id;
SELECT e.event_id, e.title, COUNT(s.session_id) AS session_count
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(s.session_id) = (
    SELECT MAX(session_total)
    FROM (
        SELECT COUNT(*) AS session_total
        FROM Sessions
        GROUP BY event_id
    ) AS session_counts
);



-- TASK 13
SELECT 
    e.city, 
    ROUND(AVG(f.rating), 2) AS average_rating
FROM 
    Events e
JOIN 
    Feedback f ON e.event_id = f.event_id
GROUP BY 
    e.city
ORDER BY 
    average_rating DESC;
    

-- TASK 14
SELECT 
    e.event_id,
    e.title,
    COUNT(r.registration_id) AS total_registrations
FROM 
    Events e
JOIN 
    Registrations r ON e.event_id = r.event_id
GROUP BY 
    e.event_id, e.title
ORDER BY 
    total_registrations DESC
LIMIT 3;


-- TASK 15
SELECT 
    s1.event_id,
    s1.session_id AS session1_id,
    s1.title AS session1_title,
    s2.session_id AS session2_id,
    s2.title AS session2_title
FROM 
    Sessions s1
JOIN 
    Sessions s2 
    ON s1.event_id = s2.event_id
    AND s1.session_id < s2.session_id
    AND s1.start_time < s2.end_time
    AND s1.end_time > s2.start_time
ORDER BY 
    s1.event_id, s1.session_id;
    
  
-- TASK 16
SELECT u.user_id, u.full_name, u.email, u.registration_date
FROM Users u
WHERE u.registration_date >= CURDATE() - INTERVAL 30 DAY
  AND NOT EXISTS (
    SELECT 1 
    FROM Registrations r 
    WHERE r.user_id = u.user_id
);

-- TASK 17
SELECT 
    speaker_name, 
    COUNT(*) AS session_count
FROM 
    Sessions
GROUP BY 
    speaker_name
HAVING 
    COUNT(*) > 1
ORDER BY 
    session_count DESC;
    
 
-- TASK 18
SELECT e.event_id, e.title
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
WHERE r.event_id IS NULL;


-- TASK 19
SELECT 
    e.event_id,
    e.title,
    COUNT(DISTINCT r.registration_id) AS total_registrations,
    ROUND(AVG(f.rating), 2) AS average_rating
FROM 
    Events e
LEFT JOIN 
    Registrations r ON e.event_id = r.event_id
LEFT JOIN 
    Feedback f ON e.event_id = f.event_id
WHERE 
    e.status = 'completed'
GROUP BY 
    e.event_id, e.title;
    
    

-- TASK 20
SELECT 
    u.user_id,
    u.full_name,
    COUNT(DISTINCT r.event_id) AS events_attended,
    COUNT(DISTINCT f.feedback_id) AS feedbacks_given
FROM 
    Users u
LEFT JOIN 
    Registrations r ON u.user_id = r.user_id
LEFT JOIN 
    Feedback f ON u.user_id = f.user_id
GROUP BY 
    u.user_id, u.full_name
ORDER BY 
    events_attended DESC, feedbacks_given DESC;
    

-- Task 21
SELECT 
    u.user_id,
    u.full_name,
    COUNT(f.feedback_id) AS total_feedbacks
FROM 
    Users u
JOIN 
    Feedback f ON u.user_id = f.user_id
GROUP BY 
    u.user_id, u.full_name
ORDER BY 
    total_feedbacks DESC
LIMIT 5;


-- Task 22
SELECT 
    user_id,
    event_id,
    COUNT(*) AS registration_count
FROM 
    Registrations
GROUP BY 
    user_id, event_id
HAVING 
    COUNT(*) > 1;
    
    
-- Task 23
SELECT DATE_FORMAT(registration_date, '%Y-%m') FROM Registrations
WHERE 
    registration_date >= CURDATE() - INTERVAL 12 MONTH
GROUP BY 
    DATE_FORMAT(registration_date, '%Y-%m')
ORDER BY 
    DATE_FORMAT(registration_date, '%Y-%m');


-- Task 24
SELECT 
    event_id,
    ROUND(AVG(TIMESTAMPDIFF(MINUTE, start_time, end_time)), 2) AS avg_session_duration_minutes
FROM 
    Sessions
GROUP BY 
    event_id
ORDER BY 
    event_id;
    
    
-- Task 25
SELECT 
    e.event_id, 
    e.title
FROM 
    Events e
LEFT JOIN 
    Sessions s ON e.event_id = s.event_id
WHERE 
    s.session_id IS NULL;


























