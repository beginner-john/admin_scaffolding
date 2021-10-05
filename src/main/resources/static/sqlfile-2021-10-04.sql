CREATE TABLE admin_scaffolding.t_feedback
(
    id           BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键id',
    content      TEXT NULL COMMENT '反馈内容',
    contact      varchar(100) NULL COMMENT '联系方式',
    status       TINYINT NULL COMMENT '状态，是否处理,0:未处理，1:已处理',
    img_url      varchar(512) NULL COMMENT '图片url',
    dispose      varchar(512) NULL COMMENT '处理描述',
    create_time  DATETIME NULL COMMENT '创建时间',
    create_by   BIGINT NULL COMMENT '创建人id',
    update_time DATETIME NULL COMMENT '处理时间',
    update_by BIGINT NULL COMMENT '更新人id',
    CONSTRAINT t_feedback_PK PRIMARY KEY (id)
) ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='反馈意见记录表';