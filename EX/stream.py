from threading import *
import cv2
from time import time, sleep
import logging
import subprocess

def cmd(cmd_string):
    """
    执行cmd命令，并得到执行后的返回值，python调试界面输出返回值
    :param cmd_string: cmd命令，如：'adb devices'
    :return:
    """
    print('COMMAND：{}'.format(cmd_string))
    subprocess.Popen(cmd_string, shell=True)

# 日志信息
logging.basicConfig(level=logging.INFO,
                    format="%(asctime)s [%(levelname)s] %(message)s",
                    datefmt="%Y/%m/%d %H:%M:%S")

# 打开直播流

# stream = 'ffmpeg -f dshow -i video="@device_pnp_\\?\usb#vid_04f2&pid_b67c&mi_00#6&26fcf372&1&0000#{65e8773d-8f56-11d0-a3b9-00a0c9223196}\global" -vcodec libx264 -preset:v ultrafast -tune:v zerolatency -rtsp_transport tcp -f rtsp rtsp://127.0.0.1:8554/test'

# sp = "E:\\DeskTop\\RSTP\\a.mp4"
# cmd("E:\\DeskTop\\RSTP\\rtsp-simple-server.exe")
# cmd(stream)

cap = cv2.VideoCapture("rtsp://127.0.0.1:8554/test")

fps = 30  # 直播流帧率
maxDelay = 0.5  # 最大容许延时
startTime = time()  # 开始时间
frames = 0
logging.info("已连接")
while True:
    frames += 1
    ret, frame = cap.read()
    # 延时小于最大容许延时才进行识别
    # if frames > (time()-startTime-maxDelay)*fps:
    cv2.imshow("frame", frame)
    # else:
    #     logging.info(f"已跳过一帧，当前{frames}，期望{int((time()-startTime-maxDelay)*fps)}")
    # 按q退出
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break
cv2.destroyAllWindows()
cap.release()

# ffmpeg -re -i E://DeskTop//RSTP//a.mp4 -c copy -f rtsp rtsp://127.0.0.1:8554/stream

# ffmpeg -f dshow -i video="Integrated Camera" -vcodec libx264 -preset:v ultrafast -tune:v zerolatency -rtsp_transport tcp -f rtsp rtsp://127.0.0.1:8554/test

# rtsp-simple-server.exe