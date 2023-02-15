
def solve():
    n, m = list(map(int, input().split()))
    a, b, c = [], [], []
    for i in range(n):
        t, x, y = list(map(int, input().split()))
        if x and y: c.append(t)
        elif x: a.append(t)
        elif y: b.append(t)
    a.sort()
    b.sort()
    for i in range(min(len(a), len(b))): c.append(a[i]+b[i])
    if len(c) < m:
        print(-1)
        return
    ans = 0
    c.sort()
    for i in range(m): ans += c[i]
    print(ans)

test = 1 #int(input())
while test:
    solve()
    test -= 1
