import sys
from PyQt5.QtCore import *
from PyQt5.QtGui import *
from PyQt5.QtWidgets import *
from PyQt5.QtWebEngineWidgets import *

class Mainwindow(QMainWindow):
    def _init_(self):
        super(MainWindow,self).init()
        self.setwindowTitle('加载外部网顶的例子')
        self.setGeometry(5,30,1355,730)
        self.browser=QWebEngineview()
        #加载外部的web界面
        self.browser.load(QUrl('http://html5test.com'))
        self.setCentralwidget (self.browser)
if __name__=='__main__':
    app=QApplication(sys.argv)
    win=Mainwindow()
    win.show()
    app.exit(app.exec_())