CREATE TABLE IF NOT EXISTS schedule (
    id INT(20) AUTO_INCREMENT PRIMARY KEY,
    year INT(4) not null,
    month INT(2) not null,
    day INT(2) not null,
    title VARCHAR(256) not null,
    start_time time not null,
    end_time time not null,
    writer VARCHAR(16) not null,
    alarm INT(1),
    comment VARCHAR(2048)
) DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS participant (
    id INT(20) AUTO_INCREMENT PRIMARY KEY,
    schedule_id INT(20) not null,
    email VARCHAR(256) not null,
    name VARCHAR(256),
    INDEX (schedule_id),
    FOREIGN KEY (schedule_id) REFERENCES schedule (id) ON DELETE CASCADE
) DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE participant;
TRUNCATE schedule;
SET FOREIGN_KEY_CHECKS = 1;

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

INSERT INTO participant(schedule_id, name, email) VALUES (18, '김응주', 'dmdwn3979@naver.com');
INSERT INTO participant(schedule_id, name, email) VALUES (18, '박찬준', 'slolee@naver.com');
INSERT INTO participant(schedule_id, name, email) VALUES (18, '김민주', 'alswn123@naver.com');
INSERT INTO participant(schedule_id, name, email) VALUES (18, '박혜원', 'gPdnjs123@naver.com');
INSERT INTO participant(schedule_id, name, email) VALUES (18, '임재창', 'wockd123@naver.com');
INSERT INTO participant(schedule_id, name, email) VALUES (16, '박찬준', 'slolee@naver.com');
INSERT INTO participant(schedule_id, name, email) VALUES (16, '김민주', 'alswn123@naver.com');
INSERT INTO participant(schedule_id, name, email) VALUES (15, '박찬준', 'slolee@naver.com');
INSERT INTO participant(schedule_id, name, email) VALUES (15, '김민주', 'alswn123@naver.com');
INSERT INTO participant(schedule_id, name, email) VALUES (15, '박혜원', 'gPdnjs123@naver.com');
