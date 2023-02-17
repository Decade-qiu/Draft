
def solve():
    n, m = list(map(int, input().split()))
    a = []
    for i in range(m): a.append(input())
    for i in range(n-m): x = input()
    a.sort()
    for i in a: print(i)

    

test = 1 #int(input())
while test:
    solve()
    test -= 1
