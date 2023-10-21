insert into Manager (id, label) values ('98', 'testManager1');
insert into Manager (id, label) values ('99', 'testManager2');

insert into client(id, order_column, name, manager_id) values (97, 1, 'testClient1', '98');
insert into client_details(client_id, info) VALUES (97, 'info about testClient1');

insert into client(id, order_column, name, manager_id) values (98, 2, 'testClient2', '98');
insert into client_details(client_id, info) VALUES (98, 'info about testClient2');

insert into client(id, order_column, name, manager_id) values (99, 1, 'testClient3', '99');
insert into client_details(client_id, info) VALUES (99, 'info about testClient3');
