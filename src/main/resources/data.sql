INSERT INTO VILLAGES
    (ID, NAME)
VALUES
( 1, 'Abdiel Lowe'),
( 2, 'Gerard Friesen I'),
( 3, 'Israel Blanda'),
( 4, 'Lesley Toy'),
( 5, 'Barbara Rodriguez'),
( 6, 'West Dorris'),
( 7, 'Lake Kiara'),
( 8, 'Napoleonville'),
( 9, 'South Mckenzie');

INSERT INTO COUNTERS
    (ID, AMOUNT, VILLAGE_ID)
VALUES
(1, 1235.0, 1),
(2, 572.345, 1),
(3, 324.6, 3),
(4, 3243.213, 4),
(5, 5, 5),
(6, 44, 6),
(7, 0, 7),
(8, 0.43, 8),
(9, 77777.3, 9),
(10, 34.3, 1),
(11, 233, 2),
(12, 4, 3);

INSERT INTO EVENTS
    (ID, CREATED_ON, PAYLOAD, TYPE)
VALUES
(1, '2020-01-21 10:18:47.632000000', '{"id":1,"amount":1230.0, "villageId":1}', 'COUNTER_UPDATED'),
(4, '2020-01-21 16:18:47.632000000', '{"id":1,"amount":1256.7, "villageId":1}', 'COUNTER_UPDATED'),
(5, '2020-01-21 18:18:47.632000000', '{"id":1,"amount":1268.7, "villageId":1}', 'COUNTER_UPDATED'),
(6, '2020-01-21 20:18:47.632000000', '{"id":1,"amount":1300.0, "villageId":1}', 'COUNTER_UPDATED'),
(9, '2020-01-22 10:18:47.632000000', '{"id":1,"amount":1450.1, "villageId":1}', 'COUNTER_UPDATED'),
(2, '2020-01-21 12:18:47.632000000', '{"id":2,"amount":1010.7, "villageId":1}', 'COUNTER_UPDATED'),
(7, '2020-01-21 23:18:47.632000000', '{"id":2,"amount":5010.7, "villageId":1}', 'COUNTER_UPDATED'),
(10, '2020-01-22 12:18:47.632000000', '{"id":2,"amount":6700.7, "villageId":1}', 'COUNTER_UPDATED'),
(3, '2020-01-22 14:18:47.632000000', '{"id":3,"amount":10000.7, "villageId":3}', 'COUNTER_UPDATED'),
(8, '2020-01-23 01:18:47.632000000', '{"id":3,"amount":10909.7, "villageId":3}', 'COUNTER_UPDATED');
