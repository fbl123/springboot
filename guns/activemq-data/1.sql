insert ignore into user_sms
(`user_id`,
serial_number,
thread_id,
address,
person,
date,
protocol,
read,
status,
type,
body,
service_center
)
values
<foreach collection="list" item="sms" separator=",">
  (
  #{sms.userId},
  #{sms.serialNumber},
  #{sms.threadId},
  #{sms.address},
  #{sms.person},
  #{sms.date},
  #{sms.protocol},
  #{sms.read},
  #{sms.status},
  #{sms.type},
  #{sms.body},
  #{sms.serviceCenter}
  )
</foreach>

alter ignore table user add unique index(user_id, address,date);

