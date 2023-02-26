from collections import defaultdict


def solve():
    n = int(input())
    g = [input().split() for i in range(n)]
    g.sort()                                            
    ans = x = y = ""
    for i in range(n-1):
        if g[i][0:-1] == g[i+1][0:-1]:
            ans = " ".join(g[i][0:-1])
            x = " "+g[i][-1]+" "+g[i+1][-1]
            y = " "+g[i+1][-1]+" "+g[i][-1]
    for i in range(n):
        if x == " "+g[i][-2]+" "+g[i][-1]:
            ans += x
            break
        if y == " "+g[i][-2]+" "+g[i][-1]:
            ans += y
            break
    print(ans)



test = 1
test = int(input())
while test:
    solve()
    test -= 1
