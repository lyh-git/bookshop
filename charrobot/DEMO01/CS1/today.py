import requests
import json


def toDay(keyword):
    res = requests.get("https://api.apishop.net/common/disease/queryDiseaseListByKeyword?apiKey=YSs5jjub4a018d7adcad9af604bb809cc5709358db49cc8&page=1&pageSize=15&keyword="+keyword).json()
    alias=("病的种类:"+",".join(res['result']['diseaseList'][0]['alias'])+"\n病的症状:"+"".join(res['result']['diseaseList'][0]["typicalSymptom"]))

    return alias
