# test
spring cloud test

���ڷ�����׷�� ��  ��Ϣ���� ��д��һ����  ��������Ҫ�ٱ��ذ�װrabbitMQ ȷ�����к�  ��ȥ������Ŀ

server-zipkin ��zipkin�ķ���� ��������
���� httplocalhost9411   �ῴ��zipkin�ṩ�Ŀ��ӻ�ҳ��


1.���Է�����׷��
��service-miya  trace1-client������������   
����httplocalhost8989miya   �Ϳ��Կ���������   Ȼ��ȥzipkinҳ��鿴��������֮��ĵ��ù�ϵ�ȵ�

2.��Ϣ����--Spring Cloud Stream��RabbitMq��

����trace1-client��ʱ��  �ͻᷢ��һ����Ϣ   
service-miya�� ����̨�ͻ����������Ϣ 
����ʹ�õ���rabbitMq  ��Ϣ������Ϊһ������ҵ�����ʧ

Ϊ�˿���Ч��  ����������trace1-client��   ��Ϣ���� ����̨û����Ϊservice-miya����û����������

Ȼ������service-miya  ���Կ�������̨��������trace1-client��������Ϣ