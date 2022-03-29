INSERT INTO "PUBLIC"."CLIENT" VALUES
    (nextval('CLIENT_SEQ'), '1992-03-11', 'Inesemilymertens@gmail.com', 'F', 21, 'Mertens', 'Ines ', 488435049, 2800, 'keistraat');
INSERT INTO "PUBLIC"."CLIENT" VALUES
    (nextval('CLIENT_SEQ'), '2002-04-11', 'seppeTeugels@gmail.com', 'M',24,'Teugels', 'Seppe', 0478435059,2800,'Brusselsestraat');
INSERT INTO "PUBLIC"."CLIENT" VALUES
(nextval('CLIENT_SEQ'), '1994-06-11', 'Dries@gmail.com', 'M', 11, 'Dubois', 'Dries', 477885122, 2800, 'zandstraat');
INSERT INTO "PUBLIC"."CLIENT" VALUES
(nextval('CLIENT_SEQ'), '1992-04-25', 'niels@gmail.com', 'M', 21, 'Oerlemans', 'Niels', 485469137, 2800, 'keistraat');
INSERT INTO "PUBLIC"."CLIENT" VALUES
(nextval('CLIENT_SEQ'), '1993-07-11', 'jennifer@gmail.com', 'F', 19, 'Ida', 'Jennifer', 475123456, 3000, 'vogelstraat');
INSERT INTO "PUBLIC"."CLIENT" VALUES
(nextval('CLIENT_SEQ'), '2005-11-09', 'claes@gmail.com', 'F', 57, 'Claes', 'Chloë', 487912658, 3000, 'zaadstraat');
INSERT INTO "PUBLIC"."CLIENT" VALUES
(nextval('CLIENT_SEQ'), '2002-05-27', 'vera@gmail.com', 'F', 84, 'Peeters', 'Vera', 499251384, 3000, 'melkstraat');
INSERT INTO "PUBLIC"."CLIENT" VALUES
(nextval('CLIENT_SEQ'), '1998-10-24', 'smith@gmail.com', 'F', 24, 'Smith', 'Mieke', 487662211, 3070, 'glasstraat');
INSERT INTO "PUBLIC"."CLIENT" VALUES
(nextval('CLIENT_SEQ'), '1997-02-15', 'lan@gmail.com', 'M', 84, 'Lan', 'Otto', 485641928, 3000, 'keistraat');
INSERT INTO "PUBLIC"."CLIENT" VALUES
(nextval('CLIENT_SEQ'), '2001-08-24', 'smets@gmail.com', 'F', 58, 'Smets', 'Sarah', 489576134, 2800, 'blikstraat');


INSERT INTO "PUBLIC"."ROOM" VALUES
    (1, 20, 'Kom tot rust in het stijlvolle interieur van de Mozaïk sauna. De veelvuldige waterstralen van zwembad en jacuzzi zorgen voor een totale ontspanning.', 'Mozaïk room');
INSERT INTO "PUBLIC"."ROOM" VALUES
    (2, 15, '“Mens sana in corpore sano!”Het interieur van de Greek sauna doet met zijn zuilen en borstbeelden de klassieke Oudheid herleven.', 'Greek room');
INSERT INTO "PUBLIC"."ROOM" VALUES
    (3, 4, 'Geniet van een glaasje champagne voor de open haard of van de sauna, hammam, jacuzzi en verwarmd zwembad die gezellig binnen zijn gelegen,', 'White room');

INSERT INTO "PUBLIC"."PERSONNEL" VALUES
                                     (1, DATE '1992-06-25', 'Bachelor Health Sciences', 'senna@gmail.com', 'F', 22, 'Verberg', 'Lara', 'Yoga instructor', 0478365189, 2800, 'keistraat'),
                                     (2, DATE '1994-08-24', 'Master  physiotherapy ', 'bruno@gmail.com', 'M', 34, 'Nagels', 'Bruno', 'Chiropractic', 0488997755, 3000, 'leistraat'),
                                     (3, DATE '1995-01-12', 'Bachelor Health Sciences', 'zoe@gmail.com', 'F', 11, 'Martens', 'zoe', 'Yoga instructor', 0481264967, 2800, 'zeestraat'),
                                     (4,DATE '1995-01-12','High school diploma','dennis@gmail.com','M',5,'Verzand','Dennis','Massage Therapist',0472514326,3000,'zandstraat'),
                                    (5,DATE '1995-08-12','High school diploma','caroline@gmail.com','F',9,'Venzuela','Caroline','Massage Therapist',0472484326,3000,'sterstraat');

INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (1,1);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (2,1);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (4,1);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (3,2);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (5,2);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (2,2);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (1,3);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (4,3);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (5,3);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (1,4);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (2,4);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (3,4);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (1,5);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (5,5);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (4,5);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (1,6);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (3,6);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (5,6);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (2,7);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (3,7);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (4,7);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (2,8);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (4,8);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (1,8);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (2,9);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (3,9);
INSERT INTO PERSONNEL_CLIENTS(PERSONNELS_ID, CLIENTS_ID) values (5,10);

INSERT INTO "PUBLIC"."BOOKING" VALUES
                                   (1, DATE '2022-03-19', TIME '22:00:00', 1, 1),
                                   (2, DATE '2022-03-18', TIME '20:00:00', 2, 3),
                                   (3, DATE '2022-03-20', TIME '18:00:00', 3, 2),
                                   (4, DATE '2022-03-19', TIME '20:00:00', 4, 1),
                                   (5, DATE '2022-03-18', TIME '22:00:00', 5, 3),
                                   (6, DATE '2022-03-20', TIME '20:00:00', 6, 2),
                                   (7, DATE '2022-03-21', TIME '18:00:00', 7, 1),
                                   (8, DATE '2022-03-21', TIME '20:00:00', 8, 1),
                                   (9, DATE '2022-03-21', TIME '22:00:00', 9, 1),
                                   (10, DATE '2022-03-22', TIME '18:00:00', 10, 3),
                                   (11, DATE '2022-03-22', TIME '20:00:00', 1, 3),
                                   (12, DATE '2022-03-22', TIME '22:00:00', 2, 3),
                                   (13, DATE '2022-03-23', TIME '18:00:00', 3, 3),
                                   (14, DATE '2022-03-23', TIME '20:00:00', 4, 2),
                                   (15, DATE '2022-03-24', TIME '18:00:00', 5, 2),
                                   (16, DATE '2022-03-24', TIME '20:00:00', 6, 2),
                                   (17, DATE '2022-03-24', TIME '22:00:00', 7, 1),
                                   (18, DATE '2022-03-25', TIME '18:00:00', 8, 1),
                                   (19, DATE '2022-03-25', TIME '22:00:00', 9, 2),
                                   (20, DATE '2022-03-25', TIME '20:00:00', 10, 2),
                                   (21, DATE '2022-03-26', TIME '18:00:00', 3, 1),
                                   (22, DATE '2022-03-26', TIME '22:00:00', 7, 3),
                                   (23, DATE '2022-03-27', TIME '22:00:00', 5, 2),
                                   (24, DATE '2022-03-27', TIME '18:00:00', 1, 2);
INSERT INTO "PUBLIC"."USER" VALUES
    (nextval('USER_SEQ'), 'admin', 'admin', 'admin');


