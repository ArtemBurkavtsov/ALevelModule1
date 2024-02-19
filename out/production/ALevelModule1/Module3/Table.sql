CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255)
);

CREATE TABLE accounts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    balance DECIMAL(10, 2),
    name VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE operations (
    id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT,
    category ENUM('INCOME', 'EXPENSE'),
    amount DECIMAL(10, 2),
    createAt TIMESTAMP,
    name VARCHAR(255),
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);