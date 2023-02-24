
def solve():
    n, d, k = list(map(int, input().split()))
    g = gcd(n, d)
    loop = n//g
    k -= 1
    ans = (k//loop+(k%loop)*d)%n
    print(int(ans))

def gcd(a, b):
    if a == 0: return b
    return gcd(b%a, a)

# test = 1
test = int(input())
while test:
    solve()
    test -= 1
