create table user_call_log
(
  id int(11) auto_increment,
  user_id int(11) not null comment '用户ID',
  phone_number varchar(20) comment '通话人号码',
  call_name varchar(36) comment '通话人备注',
  duration int(11) comment '通话时长 秒',
  date DATETIME comment '通话时间 YYYY-MM-DD HH:MM:SS',
  status varchar(20) comment '状态  打出out 收入in',
  primary key(id)
)comment '用户通话记录';
