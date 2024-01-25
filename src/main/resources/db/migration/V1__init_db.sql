CREATE TABLE worker (
    id BIGINT PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK ( LENGTH (name) >= 2 ),
    birthday DATE CHECK ( YEAR (birthday) > 1900 ),
    level VARCHAR(7) NOT NULL CHECK ( level = 'Trainee' OR level = 'Junior' OR level = 'Middle' OR level = 'Senior' ),
    salary INT NOT NULL CHECK ( salary >= 100 AND salary <=100000 )
);

CREATE TABLE client (
    id BIGINT PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK ( LENGTH (name) >= 2 )
);

CREATE TABLE project (
    id BIGINT PRIMARY KEY,
    client_id BIGINT,
    start_date DATE,
    finish_date DATE
);

CREATE TABLE project_worker (
    project_id BIGINT,
    worker_id BIGINT,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY(project_id) REFERENCES project(id),
    FOREIGN KEY(worker_id) REFERENCES worker(id)
);