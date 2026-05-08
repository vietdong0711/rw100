CREATE DATABASE rw100_testing_system; 

-- Làm việc với database
USE rw100_testing_system;

-- ==================================================
-- EXERCISE 1
-- Tạo database và 11 bảng theo coding convention
-- ==================================================

CREATE TABLE `department` (
    department_id        INT AUTO_INCREMENT PRIMARY KEY,
    department_name      VARCHAR(100) NOT NULL UNIQUE
);



CREATE TABLE `position` (
    position_id          INT AUTO_INCREMENT PRIMARY KEY,
    position_name        ENUM('DEV', 'TEST', 'SCRUM_MASTER', 'PM') NOT NULL
);



CREATE TABLE `account` (
    account_id           INT AUTO_INCREMENT PRIMARY KEY,
    email                VARCHAR(100) NOT NULL UNIQUE,
    username             VARCHAR(100) NOT NULL UNIQUE,
    full_name            VARCHAR(100) NOT NULL,
    department_id        INT,
    position_id          INT,
    create_date          DATETIME DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (department_id) REFERENCES `department`(department_id),
    FOREIGN KEY (position_id) REFERENCES `position`(position_id)
);


INSERT INTO `department` (department_name)
VALUES
    ('Marketing'),
    ('Sale'),
    ('Bảo vệ'),
    ('Nhân sự'),
    ('Kỹ thuật'),
    ('Tài chính'),
    ('Phó giám đốc'),
    ('Giám đốc'),
    ('Thư ký'),
    ('Chờ việc');

INSERT INTO `position` (position_name)
VALUES
    ('DEV'),
    ('TEST'),
    ('SCRUM_MASTER'),
    ('PM');

INSERT INTO `account` (
    email,
    username,
    full_name,
    department_id,
    position_id
)
VALUES
    ('an.nguyen@vti.com.vn', 'annguyen', 'Nguyễn Văn An', 1, 1),
    ('binh.tran@vti.com.vn', 'binhtran', 'Trần Bình', 2, 2),
    ('cuong.le@vti.com.vn', 'cuongle', 'Lê Văn Cường', 3, 1),
    ('dungdo@vti.com.vn', 'dungdo', 'Dung Do', 2, 3),
    ('hoa.pham@vti.com.vn', 'hoapham', 'Phạm Thị Hoa', 4, 4),
    ('khanh.vo@vti.com.vn', 'khanhvo', 'Võ Hoàng Khánh', 5, 1),
    ('linh.ngo@vti.com.vn', 'linhngo', 'Ngô Thùy Linh', 6, 2),
    ('minh.bui@vti.com.vn', 'minhbui', 'Bùi Quang Minh', 7, 3),
    ('nam.phan@vti.com.vn', 'namphan', 'Phan Hoài Nam', 8, 4),
    ('dao@vti.com.vn', 'daoo', 'Dao', 2, 1);