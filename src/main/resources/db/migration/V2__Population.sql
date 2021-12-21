INSERT INTO roles(id,role)
VALUES (1,'ADMIN'),
       (2,'USER');

INSERT INTO employees(user_id,encrypted_password,email, last_name, first_name, role_id)
VALUES ('xNEXVPuCBJI7ThORRSLXDgtv51i0BU', '$2a$10$7jXftcfyrr1AJnt2izZtB.F/41GIvdsPOOmiNdLnHd0bN9yuwrSOG','passwordtest2020@Gmail.com','Ivanov','Ivan',1),
       ('xiG9KVzlczXImEJp6dguW052sKm8eV', '$2a$10$.rMWNSpD4Y7BqE/MysZE7ufdPrIr6dLpAdZRMTub7HvhMzxtLhMKi','svetvconce@ya.ru','Svetikova','Sveta',2),
       ('Kkq9Kl7LNDT1Wx3UPXj5Nzhd4MR4Dg','$2a$10$AvT9v0enyFkQACQojc7tjOHxMIhMsne0q7lWZ82C2tBwmzF2I6mJa','petka2000@mail.ru','Petrov','Petr',2),
       ('sPvJRoRHXOvKA3o6B0hqkv9BfsjGHX','$2a$10$x7vZvXX/aQ7EbwFTmCJDWuSrW.rO/tLaeYHb47JUcVqCQz8n2nbcO','ilyamorozov@gmail.com','Morozov','Ilya',2);

INSERT INTO files( file_id ,date_of_signing, company_name, content, employee_id, due_date)
VALUES ('oLDGRaCLtlY3QDkVdyLnfqh9sn87c0','2021-11-09', 'Boston Scientific Corporation', 'Content of the file',(SELECT id FROM employees WHERE last_name = 'Ivanov'), '2022-02-18'),
       ('x4nMeIzbwnLPNtPRteUSvUHA465HPf','2021-11-11', 'Abbott Laboratories', 'Content of the file',(SELECT id FROM employees WHERE last_name = 'Ivanov'), '2022-01-15'),
       ('7QVqELeJjKJkNzhP9vMlyyerYeUhq7','2021-11-13', 'Baxter International Inc.', 'Content of the file',(SELECT id FROM employees WHERE last_name = 'Ivanov'), '2022-03-12'),
       ('Z4fyjdZ6jP7b02AV0scMkExoCa1fo7','2021-11-14', 'Belk, Inc.', 'Content of the file', (SELECT id FROM employees WHERE last_name = 'Ivanov'),'2022-02-04'),
       ('eknFj1BX7wQbUmo3jVAmg6eqNNU0XX','2021-11-16', 'BMC Software, Inc.', 'Content of the file',(SELECT id FROM employees WHERE last_name = 'Ivanov'), '2022-01-11'),
       ('j97m9IYhHpQekbtCCMsr3HGagQqoAD','2021-11-18', 'Calpine Corp.', 'Content of the file', (SELECT id FROM employees WHERE last_name = 'Ivanov'),'2022-01-08'),
       ('fAtl3qh8SakVRGlEQiHVeSpPhMMegj','2021-11-22', 'Ciena Corp.', 'Content of the file', (SELECT id FROM employees WHERE last_name = 'Ivanov'),'2022-04-16'),
       ('3aipcJHGB6E94jd0nGEvQLftx0qFKH','2021-11-23', 'Zale Corporation', 'Content of the file', (SELECT id FROM employees WHERE last_name = 'Ivanov'),'2022-06-22'),
       ('HTQ7vVgC5RGgtWNSpcUdQA4RMpEu2t','2021-11-23', 'Yum Brands Inc.', 'Content of the file', (SELECT id FROM employees WHERE last_name = 'Ivanov'),'2022-01-08'),
       ('S6ztXpMXg0Ia2AzIXdMZKNGWBlP2tz','2021-11-24', 'Xilinx Inc', 'Content of the file', (SELECT id FROM employees WHERE last_name = 'Ivanov'),'2022-03-18'),
       ('2KvbGozkwpaFtl6rFU93xtfFNKykyQ','2021-11-25', 'Wyeth', 'Content of the file', (SELECT id FROM employees WHERE last_name = 'Ivanov'),'2022-05-15'),
       ('KY398eGu2hUOTVrqVguCguQ6wpMiYY','2021-11-27', 'Williams Sonoma Inc', 'Content of the file',(SELECT id FROM employees WHERE last_name = 'Ivanov'), '2022-09-10');


INSERT INTO files(file_id, date_of_signing, company_name, content, employee_id, due_date)
VALUES
    ('ve4SqblEnCJ95rnZCmmVAPIDDLxv4z','2021-12-18', 'Yellow Corporation', 'Content of the file for Svetikova',(SELECT id FROM employees WHERE last_name = 'Svetikova'), '2022-03-17'),
    ('fvDFxLylY8ova1CmC6UgL2dgdI8nAg','2021-10-07', 'WorldCom Inc', 'Content of the file for Svetikova',(SELECT id FROM employees WHERE last_name = 'Svetikova'), '2022-03-10'),
    ('bYDTOUPkq3tnNoi63zQ8Xk1IpFuR5n','2021-09-09', 'WestPoint Stevens Inc', 'Content of the file for Svetikova',(SELECT id FROM employees WHERE last_name = 'Svetikova'), '2022-03-13'),
    ('kk3U7OzMcRwvScIDmEvjW9iAOnMlaj','2021-02-08', 'Walgreen Co', 'Content of the file for Svetikova',(SELECT id FROM employees WHERE last_name = 'Svetikova'), '2022-03-04'),
    ('MBh26DRqGf7w8Oujc9w7sgDXwZHB8E','2021-05-30', 'Viad Corp', 'Content of the file for Svetikova',(SELECT id FROM employees WHERE last_name = 'Svetikova'), '2022-05-19'),
    ('0nyN45tnBB9q5aMq4GNaLIsujUh6HA','2021-12-25', 'UST Inc', 'Content of the file for Svetikova',(SELECT id FROM employees WHERE last_name = 'Svetikova'), '2022-05-20'),
    ('UzjZ54Nfnp2lK6lMmneJUhoTaaqZu3','2021-10-15', 'Unova Inc', 'Content of the file for Svetikova',(SELECT id FROM employees WHERE last_name = 'Svetikova'), '2022-05-21'),
    ('FszGtxm914AfBS6VN6O5DOZjxnyxZG','2021-03-18', 'UGI Corporation', 'Content of the file for Svetikova',(SELECT id FROM employees WHERE last_name = 'Svetikova'), '2022-05-23'),
    ('QhmlHROL1iJ5WfgyODQviL6zRcoYuN','2021-03-17', 'TRW Inc', 'Content of the file for Svetikova',(SELECT id FROM employees WHERE last_name = 'Svetikova'), '2022-06-21'),
    ('9BEFq2LtlRKUSQO5LnY2Wlt9CWWTvv','2021-03-19', 'Toys R Us Inc', 'Content of the file for Svetikova',(SELECT id FROM employees WHERE last_name = 'Svetikova'), '2022-06-22'),
    ('8BElq2qRlRpUQRO1Vnp4WPt1CZXTbd','2021-04-20', 'Textron', 'Content of the file for Svetikova',(SELECT id FROM employees WHERE last_name = 'Svetikova'), '2022-06-21');


INSERT INTO files(file_id,date_of_signing, company_name, content, employee_id, due_date)
VALUES
    ('WvGG4imQAPvk1mcLWSBMml3zx1795m','2021-11-12', 'Terex Corp ', 'Content of the file for Petrov',(SELECT id FROM employees WHERE last_name = 'Petrov'), '2022-03-17'),
    ('8pxS5LxgcYh0J5v17Dm6ntCS1esI51','2021-11-11', 'Silicon Graphics Inc', 'Content of the file for Petrov',(SELECT id FROM employees WHERE last_name = 'Petrov'), '2022-03-10'),
    ('WFip8xpIMYuv7nh1OrkdsGe73aQeAi','2021-11-05', 'Ruddick Corp', 'Content of the file for Petrov',(SELECT id FROM employees WHERE last_name = 'Petrov'), '2022-03-12'),
    ('JIZfCgafIJLTRBR4eYB3FqpkBPdeaw','2021-11-02', 'Raytheon Company', 'Content of the file for Petrov',(SELECT id FROM employees WHERE last_name = 'Petrov'), '2022-05-01'),
    ('0xpvuN6d1HLoRI0MP6yUT4vyRiIUgJ','2021-11-03', 'Progress Energy Inc', 'Content of the file for Petrov',(SELECT id FROM employees WHERE last_name = 'Petrov'), '2022-05-02'),
    ('vVCuBi3taJY5l5BEyOZo79ifu7RHPG','2021-11-08', 'Pitney Bowes Inc.', 'Content of the file for Petrov',(SELECT id FROM employees WHERE last_name = 'Petrov'), '2022-06-02'),
    ('F2oz8DvKhOFuUwuQV3u5eCA7b6njzj','2021-11-16', 'Pentair Inc', 'Content of the file for Petrov',(SELECT id FROM employees WHERE last_name = 'Petrov'), '2022-06-08'),
    ('5Lk7ofVQL6OHV1dj7gETk86rqhqkIs','2021-11-30', 'Pall Corp', 'Content of the file for Petrov',(SELECT id FROM employees WHERE last_name = 'Petrov'), '2022-07-30');


INSERT INTO files(file_id,date_of_signing, company_name, content, employee_id, due_date)
VALUES
    ('Yr1E5cETdm8wsE9brigeQW2aBnPaeA','2021-01-18', 'Owens Corning', 'Content of the file for Morozov',(SELECT id FROM employees WHERE last_name = 'Morozov'), '2021-12-17'),
    ('IYAg31ayG0TSSvmuKUCKCAo7Hsg2YB','2021-01-19', 'Paccar Inc', 'Content of the file for Morozov',(SELECT id FROM employees WHERE last_name = 'Morozov'), '2021-11-14'),
    ('FVDMrLmgNYsMhX3NSjvXTWrnZzWDPT','2021-01-30', 'Outback Steakhouse Inc.', 'Content of the file for Morozov',(SELECT id FROM employees WHERE last_name = 'Morozov'), '2021-11-20'),
    ('gH07HSg2CRBg8A9aewH8fiwptbjnYr','2021-02-15', 'Omnicom Group', 'Content of the file for Morozov',(SELECT id FROM employees WHERE last_name = 'Morozov'), '2021-10-10'),
    ('34W0wpQIUPhtD0Wa0jk1NTHThNDQFt','2021-02-14', 'Motorola Inc.', 'Content of the file for Morozov',(SELECT id FROM employees WHERE last_name = 'Morozov'), '2021-10-11'),
    ('OiPs9uHKaQtXWfW8GoRybo2haUiWPE','2021-03-02', 'Nicor Inc', 'Content of the file for Morozov',(SELECT id FROM employees WHERE last_name = 'Morozov'), '2021-10-07'),
    ('R2ygX9ccGrDTUobC74l3HVdRpelIsA','2021-03-02', 'Nordstrom Inc', 'Content of the file for Morozov',(SELECT id FROM employees WHERE last_name = 'Morozov'), '2021-09-03'),
    ('iDqyCoWYacMMvDT5r5DnWvzW3DCsps','2021-03-02', 'Milacron Inc.', 'Content of the file for Morozov',(SELECT id FROM employees WHERE last_name = 'Morozov'), '2021-08-01'),
    ('0mXh9p79lJqgOY1G7NCfcPoe6ahY7I','2021-04-18', 'The MONY Group Inc.', 'Content of the file for Morozov',(SELECT id FROM employees WHERE last_name = 'Morozov'), '2021-08-01'),
    ('JBmwzxmCn3HtKBvRw48IxAVUC7X5sX','2021-04-16', 'M.D.C. Holdings Inc.', 'Content of the file for Morozov',(SELECT id FROM employees WHERE last_name = 'Morozov'), '2021-07-30');

DELETE FROM files WHERE due_date < now();
