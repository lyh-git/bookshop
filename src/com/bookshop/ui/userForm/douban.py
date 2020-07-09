import requests
from lxml import etree
import sys
import pymysql
def main(name):
    try:
        db = pymysql.connect(
            host = 'localhost',
            port = 3306,
            user= 'root',
            password = 'root',
            db = 'bookshop',
            charset = 'utf8'
        )
        #创建游标
        cur = db.cursor()
    except Exception as e:
        print(e)
    else:
        print('连接成功:{}'.format(cur))
        # 豆瓣图书爬取信息的标签以及页数
    url = 'https://book.douban.com/tag/%s?start={}&type=T' % name

    # 请求头信息
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36',
        'Upgrade-Insecure-Requests': '1',
    }

    for i in range(2):
        # 发送请求
        url = url.format(i)
        response = requests.get(url, headers=headers).text

        # xpath的解析
        html = etree.HTML(response)

        # 获取书籍详情页链接
        base_url = html.xpath('//ul[@class="subject-list"]/li/div[@class="info"]/h2/a/@href')

        # 获取书名
        bookname = html.xpath('//ul[@class="subject-list"]/li/div[@class="info"]/h2/a/@title')

        # 获取出版信息
        pub = html.xpath('//ul[@class="subject-list"]/li/div[@class="info"]/div[@class="pub"]')

        # 豆瓣评分
        rating = html.xpath(
            '//ul[@class="subject-list"]/li/div[@class="info"]/div[@class="star clearfix"]/span[@class="rating_nums"]')
        # 评价人数
        nums = html.xpath(
            '//ul[@class="subject-list"]/li/div[@class="info"]/div[@class="star clearfix"]/span[@class="pl"]')

        # 简介
        page = html.xpath('//ul[@class="subject-list"]/li/div[@class="info"]/p/text()')

        # 存储信息

        for cnt in range(20):
            # insert = ("INSERT INTO `booklist` (name,link,publicer,grade,num,content) VALUES ('%s','%s','%s',%s,%s,%s)" % ("1","2","3","4","5","6"))
            try:
                insert = ("INSERT INTO `booklist` (name,link,publicer,grade,num,content) VALUES ('%s','%s','%s','%s','%s','%s')" % (
             "".join(bookname[cnt]),"".join(base_url[cnt]), pub[cnt].text.strip(), "".join(rating[cnt].text), "".join(nums[cnt].text.strip()), "".join(page[cnt][7:].strip())))
                cur.execute(insert)
                db.commit()
            except:
                pass
    db.close()

if __name__ == '__main__':
   result = main(sys.argv[1])





