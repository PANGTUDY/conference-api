CREATE TABLE schedule (
    id INT(20) AUTO_INCREMENT PRIMARY KEY,
    year NUMBER(4) not null,
    month NUMBER(2) not null,
    day NUMBER(2) not null,
    title VARCHAR(256) not null,
    start_time time not null,
    end_time time not null,
    writer VARCHAR(16) not null,
    alarm INT(1),
    comment VARCHAR(2048)
);

CREATE TABLE user_info (
    id INT(20) AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(10),
    email VARCHAR(32) not null unique
);

CREATE TABLE participant_info (
    id INT(20) AUTO_INCREMENT PRIMARY KEY,
    schedule_id INT(20) not null,
    user_id INT(20) not null,
    FOREIGN KEY (schedule_id) REFERENCES schedule (id),
    FOREIGN KEY (user_id) REFERENCES user_info (id)
);

INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2021, 10, 5, '프로젝트 회의', '20:00:00', '22:00:00', 'ch4njun', 1, 'SAMPLE1');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2020, 12, 5, '스터디 회의', '20:00:00', '22:00:00', 'ch4njun', 0, 'SAMPLE2');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2021, 10, 5, '프론트 회의', '23:00:00', '00:00:00', 'ch4njun', 1, 'SAMPLE3');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2021, 10, 5, '프로젝트 회의', '13:00:00', '15:00:00', 'ch4njun', 1, 'SAMPLE4');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2021, 11, 11, '스터디 회의', '10:00:00', '12:00:00', 'ch4njun', 0, 'SAMPLE5');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2021, 10, 6, '회의장 개발 회의', '23:00:00', '00:00:00', 'ch4njun', 1, 'SAMPLE6');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2021, 11, 5, '회식', '18:00:00', '22:00:00', 'ch4njun', 1, 'SAMPLE7');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2020, 9, 5, '스터디 회의', '20:00:00', '22:00:00', 'ch4njun', 0, 'SAMPLE8');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2020, 7, 10, '프론트 회의', '23:00:00', '01:00:00', 'ch4njun', 1, 'SAMPLE9');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2020, 7, 3, '프로젝트 회의', '15:00:00', '17:00:00', 'ch4njun', 1, 'SAMPLE10');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2021, 10, 20, '스터디 회의', '20:00:00', '22:00:00', 'ch4njun', 0, 'SAMPLE11');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2021, 10, 30, '회의장 개발 회의', '22:00:00', '00:00:00', 'ch4njun', 1, 'SAMPLE12');

INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2022, 1, 5, '회식', '18:00:00', '22:00:00', 'ch4njun', 1, 'SAMPLE7');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2022, 1, 5, '스터디 회의', '20:00:00', '22:00:00', 'ch4njun', 0, 'SAMPLE8');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2022, 1, 10, '프론트 회의', '23:00:00', '01:00:00', 'ch4njun', 1, 'SAMPLE9');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2022, 1, 3, '프로젝트 회의', '15:00:00', '17:00:00', 'ch4njun', 1, 'SAMPLE10');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2022, 1, 20, '스터디 회의', '20:00:00', '22:00:00', 'ch4njun', 0, 'SAMPLE11');
INSERT INTO schedule(year, month, day, title, start_time, end_time, writer, alarm, comment)
VALUES (2022, 1, 30, '회의장 개발 회의', '22:00:00', '00:00:00', 'ch4njun', 1, 'SAMPLE12');

INSERT INTO user_info(name, email)
VALUES ('김응주', 'dmdwn3979@naver.com');
INSERT INTO user_info(name, email)
VALUES ('박찬준', 'slolee@naver.com');
INSERT INTO user_info(name, email)
VALUES ('김민주', 'alswn123@naver.com');
INSERT INTO user_info(name, email)
VALUES ('박혜원', 'gPdnjs123@naver.com');
INSERT INTO user_info(name, email)
VALUES ('서진하', 'wlsgk123@naver.com');
INSERT INTO user_info(name, email)
VALUES ('임재창', 'wockd123@naver.com');
INSERT INTO user_info(name, email)
VALUES ('원철황', 'cjfghkd123@naver.com');

INSERT INTO participant_info(schedule_id, user_id) VALUES (18, 1);
INSERT INTO participant_info(schedule_id, user_id) VALUES (18, 2);
INSERT INTO participant_info(schedule_id, user_id) VALUES (18, 3);
INSERT INTO participant_info(schedule_id, user_id) VALUES (18, 4);
INSERT INTO participant_info(schedule_id, user_id) VALUES (18, 5);
INSERT INTO participant_info(schedule_id, user_id) VALUES (16, 2);
INSERT INTO participant_info(schedule_id, user_id) VALUES (16, 3);
INSERT INTO participant_info(schedule_id, user_id) VALUES (15, 2);
INSERT INTO participant_info(schedule_id, user_id) VALUES (15, 3);
INSERT INTO participant_info(schedule_id, user_id) VALUES (15, 4);
