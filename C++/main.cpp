#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

typedef long long i64;

i64 k;

i64 get(i64 x) {
    i64 res = 0;
    for ( ; x; x /= 5) res += x / 5;
    return res;
}

int main() {
    scanf("%lld", &k);

    i64 l = 1, r = 5e18;
    while (l < r) {
        i64 mid = l + r >> 1;
        if (get(mid) >= k) r = mid;
        else l = mid + 1;
    }

    if (get(r) != k) r = -1;
    printf("%lld\n", r);

    return 0;
}