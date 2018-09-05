-- auto-generated definition
CREATE TABLE tb_config
(
  id            INT AUTO_INCREMENT
    PRIMARY KEY,
  env           VARCHAR(20)  NULL,
  system_name   VARCHAR(20)  NULL,
  con_file_name VARCHAR(255) NULL,
  `key`         VARCHAR(20)  NULL,
  value         VARCHAR(20)  NULL,
  `desc`        VARCHAR(255) NULL,
  status        INT          NULL,
  gmt_create    TIMESTAMP    NULL,
  gmt_modify    TIMESTAMP    NULL,
  CONSTRAINT tb_config_id_uindex
  UNIQUE (id)
)
  COMMENT '配置信息表';

CREATE TABLE tb_user
(
  id         INT         NULL,
  username   VARCHAR(20) NULL,
  password   VARCHAR(20) NULL,
  gmt_create TIMESTAMP   NULL,
  gmt_modify TIMESTAMP   NULL
)
  COMMENT '用户信息表'

CREATE TABLE tb_config_log
(
  id            INT          NULL,
  username      VARCHAR(20)  NULL,
  update_obj_id INT          NULL,
  old_value     VARCHAR(255) NULL,
  new_value     VARCHAR(255) NULL,
  update_desc   VARCHAR(255) NULL,
  gmt_create    TIMESTAMP    NULL,
)
  COMMENT '配置更改记录表'