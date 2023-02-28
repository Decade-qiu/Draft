from collections import defaultdict


def solve():
    n = int(input())
    st = input().split()
    num = ["s"]*len(st)
    dx = 0
    for x in range(len(num)-1, -1, -1):
        i = num[x]
        if i=="pair":
            if dx <= 1:
                print("Error occurred")
                return
            x, y = num[dx-1], num[dx-2]
            num[dx-2] = "pair<"+x+","+y+">"
            dx -= 1
        else:
            num[dx] = i
            dx += 1
    if dx==1: print(num[0])
    else: print("Error occurred")

test = 1
# test = int(input())
while test:
    solve()
    test -= 1
