import sys

N,K = map(int,sys.stdin.readline().strip().split())
coins  = [int(sys.stdin.readline()) for _ in range(N)]

ans = 0
for coin in coins[::-1]:
    if coin == 0:
        break

    if coin <= K:
        ans += K // coin
        K %= coin
print(ans)