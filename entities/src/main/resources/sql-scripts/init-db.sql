INSERT INTO id_auth_token_pairs (id, auth_token) VALUES ('test1', 'test1.2');
INSERT INTO id_auth_token_pairs (id, auth_token) VALUES ('test2', 'test2.2') ON CONFLICT (id) DO UPDATE SET auth_token = 'test2.5';
INSERT INTO id_auth_token_pairs (id, auth_token) VALUES ('test1', 'test1.3') ON CONFLICT (id) DO UPDATE SET auth_token = 'test1.5';

