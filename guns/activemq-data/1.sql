create table user_call_log
(
  id int(11) auto_increment,
  user_id int(11) not null comment '用户ID',
  call_number varchar(20) comment '通话人号码',
  call_name varchar(36) comment '通话人备注',
  duration int(11) comment '通话时长 秒',
  date DATETIME comment '通话时间 YYYY-MM-DD HH:MM:SS',
  status varchar(20) comment '状态  1,打出out 2,收入in 3未接来电',
  primary key(id)
)comment '用户通话记录';




create table user
(
  id              int auto_increment
    primary key,
  username        varchar(64)                         null
  comment '用户名',
  avatar          varchar(512)                        null
  comment '头像',
  full_name       varchar(64)                         null
  comment '真实姓名',
  push_id         varchar(256)                        null
  comment '第三方消息推送ID, 目前是google',
  mobile          varchar(24)                         not null
  comment '手机号码',
  country_id      int(5)                              not null
  comment '国家ID',
  country         varchar(16)                         not null
  comment '国家标准编码，ID=印尼等',
  create_time     timestamp default CURRENT_TIMESTAMP not null,
  update_time     timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP,
  email           varchar(64)                         null
  comment '邮件地址',
  email_status    tinyint(1)                          null
  comment '邮件激活状态(0:未激活/1:已激活)',
  type            varchar(16)                         null,
  open_id         varchar(36)                         null
  comment '提供给第三方的ID，买断后生成',
  last_active     timestamp                           null
  comment '最近一次打开APP的时间',
  black_list      tinyint default '0'                 null
  comment '是否进了黑名单',
  repeat_borrower tinyint default '0'                 null
  comment '是否重复借款人',
  `from`          varchar(64)                         null
  comment '最新包来源'
)
  comment '借款人';




create table user_personal_info
(
  id int(11) auto_increment,
  lender_id int(11) not null comment '出借人ID',
  attr_name
  create_time     timestamp default CURRENT_TIMESTAMP not null,
  update_time     timestamp default CURRENT_TIMESTAMP not null,
  primary (id)
) comment '出借人提交信息表'
  charset = utf8mb4;



