import random
import tornado.ioloop
import tornado.web

# 参与人员名单
participants = []

# 中奖者列表
first_prize_winners = []
second_prize_winners = []
third_prize_winners = []

class MainHandler(tornado.web.RequestHandler):
    def get(self):
        self.render("index.html",
            first_prize=len(first_prize_winners),
            second_prize=len(second_prize_winners),
            third_prize=len(third_prize_winners),
            participants="\n".join(participants),
            first_prize_winners="\n".join(first_prize_winners),
            second_prize_winners="\n".join(second_prize_winners),
            third_prize_winners="\n".join(third_prize_winners))

class DrawHandler(tornado.web.RequestHandler):
    def post(self):
        global participants, first_prize_winners, second_prize_winners, third_prize_winners

        # 获取奖项和中奖人数
        first_prize = int(self.get_argument("first_prize"))
        second_prize = int(self.get_argument("second_prize"))
        third_prize = int(self.get_argument("third_prize"))

        # 获取参与人员名单
        participants = self.get_argument("participants").strip().split("\n")

        # 抽取中奖者
        random.shuffle(participants)
        first_prize_winners = participants[:first_prize]
        participants = participants[first_prize:]
        random.shuffle(participants)
        second_prize_winners = participants[:second_prize]
        participants = participants[second_prize:]
        random.shuffle(participants)
        third_prize_winners = participants[:third_prize]

        self.redirect("/")

def make_app():
    return tornado.web.Application([
        (r"/", MainHandler),
        (r"/draw", DrawHandler),
    ], static_path="static", debug=True)

if __name__ == "__main__":
    app = make_app()
    app.listen(8888)
    tornado.ioloop.IOLoop.current().start()