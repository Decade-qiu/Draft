
def solve():
    n, m = list(map(int, input().split()))
    for i in range(m):
        n += 2
    print(n)

def ck(g, t, n, m):
    cnt = [0]*n
    for i in range(m):
        hs = set()
        for j in range(n): 
            if g[j][i] >= t:
                hs.add(j)
                cnt[j] += 1
        if len(hs) == 0: return False
    if n < m-1: return True
    for i in cnt:
        if i > 1: return True
    return False

    
# test = 1
test = int(input())
while test:
    solve()
    test -= 1
