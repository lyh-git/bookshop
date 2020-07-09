import jieba, jieba.analyse
def fc(str_text):
    keywords_top = jieba.lcut(str_text)
    return ( "/".join(keywords_top))

