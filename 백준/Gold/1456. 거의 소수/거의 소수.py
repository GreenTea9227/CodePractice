import math

N, M = map(int, input().split())

limit = int(math.sqrt(M)) + 1
is_prime = [True] * (limit + 1)
is_prime[0] = is_prime[1] = False

for i in range(2, int(math.sqrt(limit)) + 1):
    if is_prime[i]:
        for j in range(i * i, limit + 1, i):
            is_prime[j] = False

primes = [i for i in range(2, limit + 1) if is_prime[i]]

ans = 0
for i in primes:
    cur = i*i
    while cur <= M:
        if N <= cur:
            ans += 1
        cur *= i
print(ans)

