INSERT INTO users(user_id, name, login, password) VALUES
(1, 'Ivan', 'i1', '123'),
(2, 'Andrey', 'dr0n', '321');

INSERT INTO roles(role_id, name) VALUES
(1, 'admin'),
(2, 'operator'),
(3, 'statistic'),
(4, 'user');

INSERT INTO users_roles(user_id, role_id) VALUES
(1, 2),
(1, 3),
(2, 1),
(2, 4);