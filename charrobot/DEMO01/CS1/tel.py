import requests
import json


def telSelect(city):
    res = requests.get("http://api.63code.com/tel/api.php?tel=" + city).text.encode('utf-8').decode('unicode_escape')
    return res
