# 监控报警定时任务程序
## 项目简介
该项目基于 Springboot, 批处理调度使用 Quartz, 邮件发送与接收使用 Javamail
## 基本功能
1. 定时任务配置
2. 邮件读取
3. 邮件发送
## 使用方式
在 CheckAlarmImpl 中编写具体的校验业务逻辑，所有的配置都在 application.yml 中。

