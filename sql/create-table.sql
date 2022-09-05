# 공지사항
CREATE TABLE `myworkout`.`notice` (
                                      `id` INT NOT NULL AUTO_INCREMENT,
                                      `nt_title` VARCHAR(100) NOT NULL,
                                      `nt_content` VARCHAR(300) NOT NULL,
                                      PRIMARY KEY (`id`));
# 가슴 게시판
CREATE TABLE `myworkout`.`chestboard` (
                                         `id` INT NOT NULL AUTO_INCREMENT,
                                         `ch_title` VARCHAR(100) NOT NULL,
                                         `ch_content` VARCHAR(300) NOT NULL,
                                         PRIMARY KEY (`id`));

# 등 게시판
CREATE TABLE `myworkout`.`backboard` (
                                          `id` INT NOT NULL AUTO_INCREMENT,
                                          `ba_title` VARCHAR(100) NOT NULL,
                                          `ba_content` VARCHAR(300) NOT NULL,
                                          PRIMARY KEY (`id`));

# 하체 게시판
CREATE TABLE `myworkout`.`legboard` (
                                         `id` INT NOT NULL AUTO_INCREMENT,
                                         `le_title` VARCHAR(100) NOT NULL,
                                         `le_content` VARCHAR(300) NOT NULL,
                                         PRIMARY KEY (`id`));

# 팔 게시판
CREATE TABLE `myworkout`.`armboard` (
                                         `id` INT NOT NULL AUTO_INCREMENT,
                                         `ar_title` VARCHAR(100) NOT NULL,
                                         `ar_content` VARCHAR(300) NOT NULL,
                                         PRIMARY KEY (`id`));

# 어깨 게시판
CREATE TABLE `myworkout`.`shoulderboard` (
                                         `id` INT NOT NULL AUTO_INCREMENT,
                                         `sh_title` VARCHAR(100) NOT NULL,
                                         `sh_content` VARCHAR(300) NOT NULL,
                                         PRIMARY KEY (`id`));

# 맨몸 게시판
CREATE TABLE `myworkout`.`streetboard` (
                                         `id` INT NOT NULL AUTO_INCREMENT,
                                         `st_title` VARCHAR(100) NOT NULL,
                                         `st_content` VARCHAR(300) NOT NULL,
                                         PRIMARY KEY (`id`));

# 자유게시판
CREATE TABLE `myworkout`.`freeboard` (
                                         `id` INT NOT NULL AUTO_INCREMENT,
                                         `fr_title` VARCHAR(100) NOT NULL,
                                         `fr_content` VARCHAR(300) NULL,
                                         PRIMARY KEY (`id`));

# 유저
CREATE TABLE `myworkout`.`user` (
                                    `id` INT NOT NULL AUTO_INCREMENT,
                                    `user_id` VARCHAR(45) NOT NULL,
                                    `user_pw` VARCHAR(45) NOT NULL,
                                    `user_name` VARCHAR(45) NOT NULL,
                                    `user_phone` VARCHAR(45) NOT NULL,
                                    `admin` INT NOT NULL,
                                    PRIMARY KEY (`id`));


