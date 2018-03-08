# test
spring cloud test

由于服务链追踪 和  消息驱动 都写在一起了  所以首先要再本地安装rabbitMQ 确保运行后  在去运行项目

server-zipkin 是zipkin的服务端 首先启动
访问 httplocalhost9411   会看到zipkin提供的可视化页面


1.测试服务链追踪
将service-miya  trace1-client两个服务启动   
访问httplocalhost8989miya   就可以看到调用了   然后去zipkin页面查看两个服务之间的调用关系等等

2.消息驱动--Spring Cloud Stream（RabbitMq）

启动trace1-client的时候  就会发送一条消息   
service-miya端 控制台就会监听到此消息 
由于使用到了rabbitMq  消息不会因为一方服务挂掉就消失

为了看到效果  建议先启动trace1-client端   消息发出 控制台没有因为service-miya服务没起来而报错

然后启动service-miya  可以看到控制台监听到了trace1-client发来的消息