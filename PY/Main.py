

def qpow(x, y, M):
    res = 1
    while y:
        if y%2 == 1: res = res*x%M
        x = x*x%M
        y >>= 1
    return res

def solve(): 
    n, p = list(map(int, input().split()))
    a = list(map(int, input().split()))
    a.sort()
    for i in range(1, n): a[i] += a[i-1]
    l, r, M = 0 , n-1, 1000000007
    while l <= r:
        m = l+r >> 1
        if a[m] <= a[n-1]-a[m]: l = m+1
        else: r = m-1
    ans = (qpow(p, a[n-1]-a[m], M)-qpow(p, a[m], M)+M)%M
    # if m < n-1 : ans = min(ans, (qpow(p, a[n-1]-a[m+1], M)-qpow(p, a[m+1], M)+M)%M)
    print(ans)

test = int(input())
while test:
    solve()
    test -= 1
