INSERT INTO files( file_id ,date_of_signing, company_name, content, employee_id, due_date)
VALUES ('oLDGRaCLtlY3QDkVdyLnfqh9sn87c1','2021-11-09', 'Microsoft',
 'Content of the file',
 (SELECT id FROM employees WHERE last_name = 'Ivanov'), '2022-02-18'),
 ('oLDGRaCLtlY3QDkVdyLnfqh9sn87c2','2021-11-09', 'Apple',
 'Content of the file',
 (SELECT id FROM employees WHERE last_name = 'Petrov'), '2022-02-18');

