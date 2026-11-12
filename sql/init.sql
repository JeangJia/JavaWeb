-- ============================================================
-- JavaWeb 学习项目统一初始化脚本
-- 用法（Mac / Windows 通用，只需执行一次）：
--   Mac:     /usr/local/mysql/bin/mysql -uroot -p < sql/init.sql
--   Windows: mysql -uroot -p < sql\init.sql
-- 脚本可重复执行，不会删除已有数据
-- ============================================================

-- 1. 创建专用数据库账号，避免各机器 root 密码不同导致代码跑不起来
CREATE USER IF NOT EXISTS 'jeang'@'localhost' IDENTIFIED BY 'jeang';
ALTER USER 'jeang'@'localhost' IDENTIFIED BY 'jeang';

-- 2. 创建各示例使用的数据库
CREATE DATABASE IF NOT EXISTS `school` DEFAULT CHARACTER SET utf8mb4;
CREATE DATABASE IF NOT EXISTS `school_db` DEFAULT CHARACTER SET utf8mb4;
CREATE DATABASE IF NOT EXISTS `mybatis_practice1` DEFAULT CHARACTER SET utf8mb4;
CREATE DATABASE IF NOT EXISTS `mybatis` DEFAULT CHARACTER SET utf8mb4;

GRANT ALL PRIVILEGES ON `school`.* TO 'jeang'@'localhost';
GRANT ALL PRIVILEGES ON `school_db`.* TO 'jeang'@'localhost';
GRANT ALL PRIVILEGES ON `mybatis_practice1`.* TO 'jeang'@'localhost';
GRANT ALL PRIVILEGES ON `mybatis`.* TO 'jeang'@'localhost';
FLUSH PRIVILEGES;

-- ============================================================
-- 3. JDBC/jdbcDemo：demo1 查 jiayihang，demo2 操作 student
-- ============================================================
USE `school`;
CREATE TABLE IF NOT EXISTS `jiayihang` (
    `id`   INT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
INSERT IGNORE INTO `jiayihang` (`id`, `name`) VALUES (1, 'jia'), (2, 'yi'), (3, 'hang');

CREATE TABLE IF NOT EXISTS `student` (
    `id`   INT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `age`  INT NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
INSERT IGNORE INTO `student` (`id`, `name`, `age`) VALUES (1, '张三', 20), (2, '李四', 21);

-- ============================================================
-- 4. MyBatis/MybatisDemo：school_db.student
-- ============================================================
USE `school_db`;
CREATE TABLE IF NOT EXISTS `student` (
    `student_id`   INT PRIMARY KEY,
    `student_name` VARCHAR(50) NOT NULL,
    `age`          INT NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
INSERT IGNORE INTO `student` (`student_id`, `student_name`, `age`)
VALUES (1, '张三', 20), (2, '李四', 21), (3, '王五', 22);

-- ============================================================
-- 5. MyBatis/practiceDemo1：mybatis_practice1.user
-- ============================================================
USE `mybatis_practice1`;
CREATE TABLE IF NOT EXISTS `user` (
    `id`    INT AUTO_INCREMENT PRIMARY KEY,
    `name`  VARCHAR(50) NOT NULL,
    `age`   INT         NOT NULL,
    `phone` VARCHAR(20)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
INSERT IGNORE INTO `user` (`id`, `name`, `age`, `phone`) VALUES
    (1, 'jeang', 20, '12345678901'),
    (2, 'zhangsan', 21, '12345678902'),
    (3, 'lisi', 22, '12345678903'),
    (4, 'wangwu', 23, '12345678904'),
    (5, 'zhaoliu', 24, '12345678905'),
    (6, 'sunqi', 25, '12345678906'),
    (7, 'zhouba', 26, '12345678907');

-- ============================================================
-- 6. Spring/03_spring_mybatis、Servlet 示例：mybatis.user
-- ============================================================
USE `mybatis`;
CREATE TABLE IF NOT EXISTS `user` (
    `id`       INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(20) NOT NULL,
    `password` VARCHAR(20) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4;
INSERT IGNORE INTO `user` (`id`, `username`, `password`) VALUES
    (1, 'jeang', 'jeangjia'),
    (2, 'zhangsan', 'zhangsan'),
    (3, 'JeangJia', 'JeangJia'),
    (4, 'jia', '123');
