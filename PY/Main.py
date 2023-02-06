
n, m = list(map(int,input().split()))
g = [list(map(int,input().split())) for i in range(n)]
f = [[ii for ii in g[i]] for i in range(n)]
zx = set()
zy = set()
ox = set()
oy = set()
for i in range(n):
    for j in range(m):
        if g[i][j] == 0:
            zx.add(i)
            zy.add(j)
for i in range(n):
    for j in range(m):
        if i in zx or j in zy: f[i][j] = 0
for i in range(n):
    for j in range(m):
        if f[i][j] == 1:
            ox.add(i)
            oy.add(j)
for i in range(n):
    for j in range(m):
        if g[i][j] == 1:
            if not i in ox and not j in oy:
                print("NO")
                exit()
print("YES")
for i in range(n):
    for j in range(m):
        print(f[i][j], end=' ')
    print()