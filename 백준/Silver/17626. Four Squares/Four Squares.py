import math

num: int = int(input())

dp = [i for i in range(num+1)]
dp[0] = 0

# dp 배열 채우기
for i in range(1, num+1):
    if math.isqrt(i) ** 2 == i:
        dp[i] = 1
    else:
        for j in range(1, math.isqrt(i) + 1):
            dp[i] = min(dp[i], dp[i - j**2] + 1)

print(dp[-1])


