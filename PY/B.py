import tornado.web
import tornado.ioloop
import tornado.httpserver
import tornado.options # 新导入的options模块
 
tornado.options.define("port", default=8000, type=int, help="服务器监听端口号")
tornado.options.define("content", default=[], type=str, multiple=True, help="控制台输出内容")
 
class IndexHandler(tornado.web.RequestHandler):
    """主路由处理类"""
    def get(self):
        self.write("Hello World!")
        self.write("\n-------method:\n")
        self.write(self.request.method)
        self.write("\n-------uri:\n")
        self.write(self.request.uri)
        self.write("\n-------path:\n")
        self.write(self.request.path)
        self.write("\n-------query:\n")
        self.write(self.request.query)
        self.write("\n-------version:\n")
        self.write(self.request.version)
        self.write("\n-------headers['Accept-Language']:\n")
        self.write(self.request.headers["Accept-Language"])
        self.write("\n-------body:\n")
        self.write(self.request.body)
        self.write("\n-------remote_ip:\n")
        self.write(self.request.remote_ip)
        self.write("\n-------protocol:\n")
        self.write(self.request.protocol)
        self.write("\n-------host:\n")
        self.write(self.request.host)
        self.write("\n-------arguments:\n")
        self.write(self.request.arguments)
        self.write("\n-------query_arguments:\n")
        self.write(self.request.query_arguments)
        self.write("\n-------body_arguments:\n")
        self.write(self.request.body_arguments)
        self.write("\n-------files:\n")
        self.write(self.request.files)
        self.write("\n-------cookies:\n")
        self.write(self.request.cookies)
        self.write("\n")
 
    #自定义settings
settings = {
    "template_path":"templates",
    "static_path":"statics",
}
 
if __name__ == "__main__":

    print(tornado.options.options.content)  # 控制台输出内容
 
    app = tornado.web.Application([
        (r"/", IndexHandler),
    ],debug=True,**settings)
 
    http_server = tornado.httpserver.HTTPServer(app)
    http_server.listen(tornado.options.options.port)
    tornado.ioloop.IOLoop.current().start()