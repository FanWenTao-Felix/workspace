# 项目说明
以springboot 2.1.8为中心，集成了常用的中间件，并有部分示例。
可以从这个项目为模板，二次开发成其它的业务系统。

这是一个单体架构的项目，如果需要微服务架构，请自行更改。
## 路线图
* 增加测试用例。增强主程序的稳定性。
* 收集常用的业务模块，进行集成。
* 丰富tool包下的常用工具。

## 工程结构
``` 
SpringBootDev
├── develop -- 开发辅助工具
├── common -- 常用工具封装包
├── core -- 核心包
├── modules - 业务系统相关示例
├    ├── auth -- 授权模块 
├    ├── desk -- 工作台模块 
├    ├── log -- 日志模块 
├    ├── system -- 系统模块 
├    └── user -- 用户模块 

```