INSERT INTO employees(user_id,encrypted_password,email, last_name, first_name, role_id)
VALUES ('xNEXVPuCBJI7ThORRSLXDgtv51i0B1',
'$2a$10$7jXftcfyrr1AJnt2izZtB.F/41GIvdsPOOmiNdLnHd0bN9yuwrSOG',
'wert2020@Gmail.com','Reva','Vlad',2);
INSERT INTO files( file_id ,date_of_signing, company_name, content, employee_id, due_date)
VALUES ('oLDGRaCLtlY3QDkVdyLnfqh9sn87c1','2021-11-09', 'Disney',
 'Content of the file',
 (SELECT id FROM employees WHERE last_name = 'Reva'), '2022-02-18'),
 ('oLDGRaCLtlY3QDkVdyLnfqh9sn87c2','2021-11-09', 'Amazon',
 'Content of the file',
 (SELECT id FROM employees WHERE last_name = 'Reva'), '2022-02-18');
