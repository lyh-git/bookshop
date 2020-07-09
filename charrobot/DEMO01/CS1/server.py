import socket  # 导入 socket 模块
import threading
from threading import Thread
import saying
import requests
import tel
import sub
ADDRESS = ('127.0.0.1', 8715)  # 绑定地址

g_socket_server = None  # 负责监听的socket

g_conn_pool = []  # 连接池


def init():
    #     """
    #     初始化服务端
    #     """
    global g_socket_server
    g_socket_server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  # 创建 socket 对象
    g_socket_server.bind(ADDRESS)
    g_socket_server.listen(5)  # 最大等待数（有很多人理解为最大连接数，其实是错误的）
    print("服务端已启动，等待客户端连接...")


def accept_client():
    #     """
    #     接收新连接
    #     """
    while True:
        client, addr = g_socket_server.accept()  # 阻塞，等待客户端连接
        # 加入连接池
        g_conn_pool.append(client)
        # 给每个客户端创建一个独立的线程进行管理
        thread = Thread(target=message_handle, args=(client,addr))
        # 设置成守护线程
        thread.setDaemon(True)
        thread.start()


def message_handle(client,addr):
    #     """
    #     消息处理
    #     """

    while True:
        bytes = client.recv(1024)
        print(str(addr)+"客户端请求数据:", bytes.decode(encoding='utf8'))
        res = "".join(bytes.decode(encoding='utf8')).split("===")
        # print(res[0],res[1])
        if len(bytes) == 0:
            client.close()
            # 删除连接
            g_conn_pool.remove(client)
            print(str(addr)+"客户端下线了。")
            break
        if res[0] == '2':
            print("--------------------------")
            msg = sub.fc(res[1])
            client.sendall(msg.encode(encoding='utf8'))
        if res[0][-1] == '3':
            print("--------------------------")
            msg = saying.say(res[1])
            client.sendall(msg.encode(encoding='utf8'))
        if res[0] == '1':
            print("--------------------------")
            msg = "情感分析功能尚未开放"
            client.sendall(msg.encode(encoding='utf8'))


def main():
    #多线程同时运行两个方法
    t1 = threading.Thread(target=accept_client)
    t1.start()
    t1.join()



if __name__ == '__main__':
    init()
    main()


