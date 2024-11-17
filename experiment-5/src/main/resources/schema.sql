/*
    使用idea `ctrl+/`创建的`#`注释是错误的
    应使用类似Java的注解。`ctrl+shift+/`
*/
create table if not exists `user`
(
    id          char(19)  primary key,
    name        varchar(45) not null,
    account varchar (16) not null,
    password varchar(70) not null,
    role char(4) not null ,
    create_time datetime default current_timestamp,
    update_time datetime default current_timestamp on update current_timestamp,
    unique(account)
);
