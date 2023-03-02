from collections import defaultdict


def solve():
    a = [input() for i in range(5)]
    ans = 0
    for i in a:
        if i[0]==i[2] and i[1]+1==i[3]: ans += 1
    print(ans)
    

test = 1
# test = int(input())
while test:
    solve()
    test -= 1
