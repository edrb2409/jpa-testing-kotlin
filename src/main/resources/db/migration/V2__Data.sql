INSERT INTO client VALUES (1, 'default client');
select setval('client_id_seq', 2);

INSERT INTO device VALUES (DEFAULT, 1, 'Daniels Mac');
INSERT INTO device VALUES (DEFAULT, 1, 'Abis Mac');

INSERT INTO contact VALUES (DEFAULT, 'Daniel', 'daniel@example.com', 1);
INSERT INTO contact VALUES (DEFAULT, 'Marita', 'marita@example.com', 1);