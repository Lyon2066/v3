

-- DDL
-- DDL
-- DDL
username,
password,
salt,
phone,
email,
gender,
avatar,
is_delete,
create_user,
create_time,
modified_user,
modified_time
-- 在lyon数据库中 创建一个table： t_user
show databases;
use lyon;
create table if not exists t_user
(
    uid int(100) auto_increment,
    username varchar(255),
    password varchar(255),
    salt varchar(255),
    phone varchar(255),
    email varchar(255),
    gender int(10),
    avatar varchar(255),
    is_delete int(10),
    create_user varchar(100),
    create_time varchar (100),
    modified_user varchar(100),
    modified_time varchar (100),
    primary key(uid)
);