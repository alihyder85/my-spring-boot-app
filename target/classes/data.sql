CREATE TABLE data_model (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);

INSERT INTO data_model (id, name, description) VALUES (1, 'Sample Data 1', 'This is a sample description for data 1');
INSERT INTO data_model (id, name, description) VALUES (2, 'Sample Data 2', 'This is a sample description for data 2');
INSERT INTO data_model (id, name, description) VALUES (3, 'Sample Data 3', 'This is a sample description for data 3');

CREATE TABLE Usertable (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100),
    role VARCHAR(50)
);

-- Add a user with a BCrypt-encoded password
INSERT INTO Usertable (username, password, role) VALUES ('user1', '$2a$10$a76VY2iHlZQCQ845XXcqZ.QVecGQQN9lX/rwOk75BSxuSGV2RZKbq', 'USER');