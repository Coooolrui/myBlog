-- 创建数据库
CREATE DATABASE myblog;

USE myblog;


-- 博客用户表
CREATE TABLE blog_user(
	id INT PRIMARY KEY AUTO_INCREMENT,
	pic VARCHAR(255) NOT NULL,
	`create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	qq VARCHAR(25) NOT NULL,  
	`name` VARCHAR(25) NOT NULL,
	username VARCHAR(25) NOT NULL UNIQUE,
	`password` VARCHAR(255) NOT NULL,
	role VARCHAR(30) NOT NULL
)

-- 博客类型表
CREATE TABLE blog_type(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(255)  NOT NULL
);

-- 博客标签表
CREATE TABLE blog_tag(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL
);

-- 博客表
/*
status 1 发表 0 草稿
user_id 查到作者名字
*/
CREATE TABLE blog_blog(
	id VARCHAR(255) PRIMARY KEY, 
	user_id INT NOT NULL,
	
	title VARCHAR(255) NOT NULL,
	content LONGTEXT NOT NULL,
	description VARCHAR(255) NOT NULL,
	first_pic VARCHAR(255) NOT NULL,
	
	
	type_id INT NOT NULL,
	tag_id INT NOT NULL,
	`status` INT NOT NULL,
	views INT NOT NULL DEFAULT 0,
	is_top BOOLEAN NOT NULL,
	
	
	`create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
	`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


-- 归档表
CREATE TABLE blog_timeline(
	id VARCHAR(14) NOT NULL PRIMARY KEY,
	user_id INT NOT NULL,
	`time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
	description VARCHAR(255) NOT NULL
)

-- 插入用户数据 默认密码为：123456
INSERT INTO `blog_user` (pic, qq, `name`, username, `password`, role) VALUES('https://img.ivsky.com/img/tupian/pre/202003/07/yuanyang.jpg', '1436022537', 'MaRui', 'maruiya', '$2a$10$5n2S85qkZKxTSknLAkUuCeCLBlKcHZ9kxo0zQxj.CThyL1qxF4kKO', 'ROLE_ADMIN')

-- 插入 标签表
INSERT INTO `blog_tag`(`name`) VALUES ('springboot'), ('linux'), ('c++'), ('c')

-- 插入 类型表
INSERT INTO `blog_type`(`name`) VALUES ('原创'), ('转载'), ('个人日志')

-- 插入 博客表
INSERT INTO `blog_blog`(id, user_id, title, content, description, first_pic, type_id, tag_id, STATUS, is_top)
VALUES('20200801100956', 1, '测试一', '这是测试一的内容', '这是测试一的描述', 'http://pic.ruiwen.com/allimg/1708/598c8d3752d8939511.jpg?x-oss-process=style/qr.ruiwen', 1, 1, 1, 1),
('20200801100957', 1, '测试二', '这是测试二的内容', '这是测试二的描述', 'http://pic.ruiwen.com/allimg/1708/598c8d3752d8939511.jpg?x-oss-process=style/qr.ruiwen', 1, 2, 0, 1),
('20200801100958', 1, '测试三', '这是测试三的内容', '这是测试三的描述', 'http://pic.ruiwen.com/allimg/1708/598c8d3752d8939511.jpg?x-oss-process=style/qr.ruiwen', 1, 2, 0, 0),
('20200801100959', 1, '测试四', '这是测试四的内容', '这是测试四的描述', 'http://pic.ruiwen.com/allimg/1708/598c8d3752d8939511.jpg?x-oss-process=style/qr.ruiwen', 1, 3, 1, 0),
('20200801100960', 1, '测试五', '这是测试五的内容', '这是测试五的描述', 'http://pic.ruiwen.com/allimg/1708/598c8d3752d8939511.jpg?x-oss-process=style/qr.ruiwen', 1, 1, 1, 1),
('20200801101056', 1, '测试六', '这是测试六的内容', '这是测试六的描述', 'http://pic.ruiwen.com/allimg/1708/598c8d3752d8939511.jpg?x-oss-process=style/qr.ruiwen', 1, 2, 1, 1);