drop table if exists user;

create table if not exists user
(
    id       int auto_increment comment '主键自增id'
        primary key,
    user_no  varchar(255) not null comment '工号',
    name     varchar(255) null comment '姓名',
    phone    varchar(255) null comment '电话',
    password varchar(255) null comment '密码',
    email    varchar(255) null comment '邮箱',
    role_id  int          not null comment '角色，1、管理员 2、教师',
    constraint user_user_no_uindex
        unique (user_no)
) comment '用户';


drop table if exists login_log;

create table if not exists login_log
(
    id          int not null primary key auto_increment comment '主键自增id',
    user_id     int not null comment '用户id',
    create_time datetime default current_timestamp comment '登录时间'
) comment '登录记录';

drop table if exists school;
create table school
(
    code varchar(20)  not null comment '学院编号' primary key,
    name varchar(255) not null comment '学院名称'
) comment '学院';

drop table if exists import_log;

create table if not exists import_log
(
    id          int            not null primary key auto_increment comment '主键自增id',
    student_no  varchar(20)    not null comment '学号',
    sex         varchar(20)    not null comment '性别',
    school_code varchar(20)    not null comment '学院',
    money       decimal(10, 1) not null comment '消费金额',
    `time`      datetime       not null comment '消费时间',
    create_time datetime default current_timestamp comment '导入时间'
) comment '导入记录';

