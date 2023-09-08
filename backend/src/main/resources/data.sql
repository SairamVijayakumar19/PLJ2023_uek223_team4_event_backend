
--USERS
insert into users (id, email,first_name,last_name, password)
values ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'admin@example.com', 'James','Bond', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6' ), -- Password: 1234
('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'user@example.com', 'Tyler','Durden', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6') -- Password: 1234
 ON CONFLICT DO NOTHING;


--ROLES
INSERT INTO role(id, name)
VALUES ('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', 'DEFAULT'),
('ab505c92-7280-49fd-a7de-258e618df074', 'ADMIN'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'USER')
ON CONFLICT DO NOTHING;

--AUTHORITIES
INSERT INTO authority(id, name)
VALUES ('2ebf301e-6c61-4076-98e3-2a38b31daf86', 'DEFAULT'),
('76d2cbf6-5845-470e-ad5f-2edb9e09a868', 'USER_MODIFY'),
('21c942db-a275-43f8-bdd6-d048c21bf5ab', 'USER_DELETE'),
('07e848fa-4d62-11ee-be56-0242ac120002', 'EVENT_POST'),
('07e85052-4d62-11ee-be56-0242ac120002', 'EVENT_DELETE'),
('07e851ba-4d62-11ee-be56-0242ac120002', 'EVENT_MODIFY'),
('efb7b108-4e38-11ee-be56-0242ac120002', 'EVENT_JOIN'),
('6b30a440-4e37-11ee-be56-0242ac120002', 'EVENT_READ'),
('6b30a896-4e37-11ee-be56-0242ac120002', 'EVENT_READ_PARTICIPANTS')
ON CONFLICT DO NOTHING;

--assign roles to users
insert into users_role (users_id, role_id)
values
       ('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'c6aee32d-8c35-4481-8b3e-a876a39b0c02'),
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'ab505c92-7280-49fd-a7de-258e618df074')
 ON CONFLICT DO NOTHING;

-- USER Role hat Authorities "EVENT_CREATE", "EVENT_MODIFY", "EVENT_DELETE", "EVENT_READ_PARTICIPANTS", "EVENT_READ" und EVENT_JOIN
INSERT INTO role_authority(role_id, authority_id)
VALUES
    ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', '76d2cbf6-5845-470e-ad5f-2edb9e09a868'),
    ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', '21c942db-a275-43f8-bdd6-d048c21bf5ab'),
    ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', '07e848fa-4d62-11ee-be56-0242ac120002'),
    ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', '6b30a896-4e37-11ee-be56-0242ac120002'),
    ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', '6b30a440-4e37-11ee-be56-0242ac120002'),
    ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'efb7b108-4e38-11ee-be56-0242ac120002')
 ON CONFLICT DO NOTHING;

-- ADMIN hat "EVENT_READ",
INSERT INTO role_authority(role_id, authority_id)
VALUES
    ('ab505c92-7280-49fd-a7de-258e618df074', '6b30a440-4e37-11ee-be56-0242ac120002'),
    ('ab505c92-7280-49fd-a7de-258e618df074', '6b30a896-4e37-11ee-be56-0242ac120002'),
    ('ab505c92-7280-49fd-a7de-258e618df074', '07e848fa-4d62-11ee-be56-0242ac120002')
ON CONFLICT DO NOTHING;

INSERT INTO event (event_name, date, location)
VALUES ('Summer Party', '2023-06-15', 'Beach Club'),
       ('Tech Conference', '2023-07-20', 'Convention Center'),
       ('New Year Bash', '2023-12-31', 'Downtown Plaza');

INSERT  INTO event_users(event_id, users_id)
VALUES ('1','ba804cb9-fa14-42a5-afaf-be488742fc54');
