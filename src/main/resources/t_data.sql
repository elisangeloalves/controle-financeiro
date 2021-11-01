INSERT INTO users(firstname, lastname, email, password)
VALUES ('ELISA', 'FERREIRA', 'elisa@gmail.com', '$2a$10$haJSXjyW//7bnEp0QWyiMu8acfWWcP4p35Il9/JPAyXZsdOVBk5GW');

INSERT INTO users(firstname, lastname, email, password)
VALUES ('EDVALDO', 'FERREIRA', 'edvaldo@gmail.com', '$2a$10$haJSXjyW//7bnEp0QWyiMu8acfWWcP4p35Il9/JPAyXZsdOVBk5GW');

INSERT INTO users(firstname, lastname, email, password)
VALUES ('JOSE', 'ALVES', 'jose@gmail.com', '$2a$10$haJSXjyW//7bnEp0QWyiMu8acfWWcP4p35Il9/JPAyXZsdOVBk5GW');

INSERT INTO users(firstname, lastname, email, password)
VALUES ('JOAO', 'FERREIRA', 'joao@gmail.com', '$2a$10$haJSXjyW//7bnEp0QWyiMu8acfWWcP4p35Il9/JPAyXZsdOVBk5GW');

INSERT INTO users(firstname, lastname, email, password)
VALUES ('PEDRO', 'ALVES', 'pedro@gmail.com', '$2a$10$haJSXjyW//7bnEp0QWyiMu8acfWWcP4p35Il9/JPAyXZsdOVBk5GW');

INSERT INTO users(firstname, lastname, email, password)
VALUES ('MARIA', 'ALVES', 'maria@gmail.com', '$2a$10$haJSXjyW//7bnEp0QWyiMu8acfWWcP4p35Il9/JPAyXZsdOVBk5GW');

INSERT INTO users(firstname, lastname, email, password)
VALUES ('ADMIN', 'SUPER USER', 'admin@admin.com', '$2a$10$haJSXjyW//7bnEp0QWyiMu8acfWWcP4p35Il9/JPAyXZsdOVBk5GW');

insert into authorities(name)
values('READ_PRIVILEGE');

insert into authorities(name)
values('WRITE_PRIVILEGE');

insert into roles(name)
values('ROLE_ADMIN');

insert into roles(name)
values('ROLE_USER');

insert into roles_authorities(role_id, authority_id)
values(1, 1);

insert into roles_authorities(role_id, authority_id)
values(1, 2);

insert into roles_authorities(role_id, authority_id)
values(2, 1);

insert into users_roles(user_id, role_id)
values(7, 1);
