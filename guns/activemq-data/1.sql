
create table user_sms
(
  id int(11) auto_increment,
  user_id int(11) not null comment '用户ID',
  _id varchar (255) comment '短信序号',
  thread_id varchar (255) comment '对话的序号，如100，与同一个手机号互发的短信，其序号是相同的',
  address varchar(255) comment '发件人号码',
  person varchar(255) comment '发件人',
  date integer comment '日期',
  protocol varchar (255) comment '协议0SMS_RPOTO短信，1MMS_PROTO彩信',
  `read` int(2) comment '是否阅读0未读，1已读',
  status int(2) comment '短信状态-1接收，0complete,64pending,128failed',
  type int(2) comment '短信类型1是接收到的，2是已发出',
  body varchar (512) comment '短信具体内容',
service_center varchar (255) comment '短信服务中心号码编号',
primary key(id)
)comment '用户短信';