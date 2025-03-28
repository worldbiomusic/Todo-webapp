INSERT INTO todos (todo, detail, created_at, updated_at)
VALUES
('쇼핑', '삽겹살 사기', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO todos (todo, detail, created_at, updated_at)
VALUES
('도서관', '책빌리기', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO todos (todo, detail, created_at, updated_at)
VALUES
('헬스장', '운동하기', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

--password: adminpass
INSERT INTO authentications (username, password, authority)
VALUES
('admin', '$2a$10$qmTCt5Vc4Vn50PV0shYqBOUkimjCMqjt/NTG8g.ojuosYsQpB15Ee', 'ADMIN');

-- password: userpass
INSERT INTO authentications (username, password, authority)
VALUES
('user', '$2a$10$x.02fwjr3G0lzOK.GbTcGO3INiotH2kWYDQ96o4r90gGMhjChXZ2e', 'USER');
