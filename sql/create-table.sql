# 공지사항
CREATE TABLE `myworkout`.`notice` (
                                      `id` INT NOT NULL AUTO_INCREMENT,
                                      `nt_title` VARCHAR(100) NOT NULL,
                                      `nt_content` VARCHAR(300) NOT NULL,
                                      PRIMARY KEY (`id`));

# 자유게시판
CREATE TABLE `myworkout`.`freeboard` (
                                         `id` INT NOT NULL AUTO_INCREMENT,
                                         `fr_title` VARCHAR(100) NOT NULL,
                                         `fr_content` VARCHAR(300) NULL,
                                         PRIMARY KEY (`id`));

