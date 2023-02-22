
def solve():
    s = input()
    cnt = [0]*26
    for i in s: cnt[ord(i)-97] += 1
    odd, even = 0, 0
    for i in cnt:
        if i%2==0: even += 1
        else: odd += 1
    for i in range(26):
        if cnt[i]%2 == 1:
            for j in range(25, i, -1):
                if cnt[j]%2 == 1:
                    cnt[i] += 1
                    cnt[j] -= 1
                    break
    ans, ex = "", -1
    for i in range(26):
        ans += chr(i+97)*(cnt[i]//2)
        if cnt[i]%2 == 1: ex = i
    print(ans+('' if ex==-1 else chr(ex+97))+ans[::-1])
    
test = 1
# test = int(input())
while test:
    solve()
    test -= 1
