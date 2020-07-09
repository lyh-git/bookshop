import socket  # 导入 socket 模块

# 客户端
def client():
    s = socket.socket()  # 创建 socket 对象
    s.connect(('127.0.0.1', 8715))
    print("成功连接服务端,请选择服务")

    while True:
        print("1,聊天机器人,2.中文分词，3.情感分析,4.退出")
        target=input()
        if target=="4":
            return
        if target=="1":
            while True:
                print("请输一句话,输入quit结束聊天")
                city=input()
                if city=="quit":
                    break
                target=target+"==="+city
                s.send(target.encode('utf8'))
                print(s.recv(1024).decode(encoding='utf8'))
                target="1"
        if target == "2":
                print("请输入一句话")
                data = input()
                target = target + "===" + data
                s.send(target.encode('utf8'))
                print(s.recv(2048).decode(encoding='utf8'))
        if target == "3":
            s.send(target.encode('utf8'))
            print(s.recv(1024).decode(encoding='utf8'))
if __name__ == '__main__':
    client()