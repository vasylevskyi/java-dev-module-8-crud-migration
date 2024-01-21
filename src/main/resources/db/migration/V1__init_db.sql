CREATE TABLE worker (
    id INT PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK ( LENGTH (name) >= 2 ),
    birthday DATE CHECK ( YEAR (birthday) > 1900 ),
    level VARCHAR(7) NOT NULL CHECK ( level = 'Trainee' OR level = 'Junior' OR level = 'Middle' OR level = 'Senior' ),
    salary INT NOT NULL CHECK ( salary >= 100 AND salary <=100000 )
);

CREATE TABLE client (
    id INT PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK ( LENGTH (name) >= 2 )
);

CREATE TABLE project (
    id INT PRIMARY KEY,
    client_id INT,
    start_date DATE,
    finish_date DATE,
    FOREIGN KEY(client_id) REFERENCES client(id)
);

CREATE TABLE project_worker (
    project_id INT,
    worker_id INT,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY(project_id) REFERENCES project(id),
    FOREIGN KEY(worker_id) REFERENCES worker(id)
);