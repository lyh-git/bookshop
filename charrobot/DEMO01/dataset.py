
with open(r"H:\编程\charrobot\DEMO01\data\xiaohuangji50w_nofenci.conv","r",encoding="utf-8",errors="ignore") as f:
    lists=[]
    count=0
    line=f.readlines(500)
    for i in line:
        if i.strip("E").strip("M").strip()!="":
            lists.append(i.strip("E").strip("M").strip("\n"))
            count=count+1
        else:
            print(lists,count)
            lists=[]

