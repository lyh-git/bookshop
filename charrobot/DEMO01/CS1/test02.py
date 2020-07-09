from chatterbot import ChatBot
from chatterbot.trainers import ChatterBotCorpusTrainer
from chatterbot.trainers import Trainer

from chatterbot.trainers import ListTrainer
chatbot = ChatBot("ChineseChatBot")
def train(chatbot):
    trainer = ListTrainer(chatbot)
    trainer.train(["快递", "默认顺非快递哦亲"])
    trainer.train(["发什么快递", "默认顺非快递哦亲"])
    trainer.train(["发货时间", "默认付款后24小时内发货哦亲"])
    trainer.train(["发货", "默认付款后24小时内发货哦亲"])
    trainer.train(["什么时候发货","默认付款后24小时内发货哦亲"])
    with open(r"../data/xiaohuangji50w_nofenci.conv", "r", encoding="utf-8", errors="ignore") as f:
        lists=[]
        line=f.readlines(50000)
        for i in line:
            if i.strip("E").strip("M").strip()!="":
                lists.append(i.strip("E").strip("M").strip("\n"))

            else:
                trainer.train(lists)
                lists=[]


# 开始对话
def res(chatbot,content):
    trainer = ListTrainer(chatbot)
    trainer.train(["推荐", "人性的弱点,围城,活着"])
    trainer.train(["好书推荐", "人性的弱点,围城,活着"])
    trainer.train(["推荐基本书", "人性的弱点,围城,活着"])
    trainer.train(["好书", "人性的弱点,围城,活着"])
    return str(chatbot.get_response(content))

# train(chatbot)
