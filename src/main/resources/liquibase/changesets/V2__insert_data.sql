insert into users(name, username, password)
values ('John Wick', 'johnwick@mail.com', '$2a$10$sLPI9zXaYUusmjHHK.5h6O5jT3RYvBwG3fERGwvcWM/4ZLglMlvyS'),
       ('Stive Ostin', 'stiveostin@mail.com', '$2a$10$sLPI9zXaYUusmjHHK.5h6O5jT3RYvBwG3fERGwvcWM/4ZLglMlvyS');

insert into tasks(title, description, status, expiration_date)
values ('Kill all enemy', null, 'TODO', '2023-02-27 12:00:00'),
       ('Do something', 'please', 'IN_PROGRESS', '2023-02-28 00:00:00'),
       ('Congratulate your father', null, 'DONE', null),
       ('Eat something', 'soup', 'TODO', '2023-03-02 18:00:00');

insert into users_tasks(task_id, user_id)
values (1, 2),
       (2, 2),
       (3, 2),
       (4, 1);

insert into users_roles(user_id, role)
values (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER');