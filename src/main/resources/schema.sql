CREATE TABLE schedule (
    id INT(20) AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(256) not null,
    start_time datetime not null,
    end_time datetime not null,
    writer VARCHAR(16) not null,
    alarm INT(1),
    comment VARCHAR(2048)
);

INSERT INTO schedule(title, start_time, end_time, writer, alarm, comment) VALUES ('프로젝트 회의', '2021-10-05 20:00:00', '2021-10-05 22:00:00', '박찬준', 1, 'SAMPLE1');
INSERT INTO schedule(title, start_time, end_time, writer, alarm, comment) VALUES ('스터디 회의', '2020-12-05 20:00:00', '2020-12-05 22:00:00', '박찬준', 0, 'SAMPLE2');
INSERT INTO schedule(title, start_time, end_time, writer, alarm, comment) VALUES ('프론트 회의', '2021-10-05 23:00:00', '2021-10-06 01:00:00', '박혜원', 1, 'SAMPLE3');
INSERT INTO schedule(title, start_time, end_time, writer, alarm, comment) VALUES ('프로젝트 회의', '2021-10-05 20:00:00', '2021-10-05 22:00:00', '박찬준', 1, 'SAMPLE4');
INSERT INTO schedule(title, start_time, end_time, writer, alarm, comment) VALUES ('스터디 회의', '2021-11-11 10:00:00', '2021-11-11 12:00:00', '원철황', 0, 'SAMPLE5');
INSERT INTO schedule(title, start_time, end_time, writer, alarm, comment) VALUES ('회의장 개발 회의', '2021-10-05 23:00:00', '2021-10-06 01:00:00', '박혜원', 1, 'SAMPLE6');
INSERT INTO schedule(title, start_time, end_time, writer, alarm, comment) VALUES ('회식', '2021-11-05 18:00:00', '2021-11-05 22:00:00', '박찬준', 1, 'SAMPLE7');
INSERT INTO schedule(title, start_time, end_time, writer, alarm, comment) VALUES ('스터디 회의', '2020-09-05 20:00:00', '2020-09-05 22:00:00', '원철황', 0, 'SAMPLE8');
INSERT INTO schedule(title, start_time, end_time, writer, alarm, comment) VALUES ('프론트 회의', '2020-07-10 23:00:00', '2020-07-10 01:00:00', '박혜원', 1, 'SAMPLE9');
INSERT INTO schedule(title, start_time, end_time, writer, alarm, comment) VALUES ('프로젝트 회의', '2020-07-03 15:00:00', '2020-07-03 17:00:00', '박찬준', 1, 'SAMPLE10');
INSERT INTO schedule(title, start_time, end_time, writer, alarm, comment) VALUES ('스터디 회의', '2021-10-20 20:00:00', '2021-10-20 22:00:00', '박찬준', 0, 'SAMPLE11');
INSERT INTO schedule(title, start_time, end_time, writer, alarm, comment) VALUES ('회의장 개발 회의', '2021-10-30 22:00:00', '2021-10-31 23:59:59', '박혜원', 1, 'SAMPLE12');