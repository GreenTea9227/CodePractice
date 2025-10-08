import sys

N = int(sys.stdin.readline().strip())
numbers = [(i, int(sys.stdin.readline().strip())) for i in range(N)]

numbers.sort(key=lambda x : x[1])

ans = 0
for i in range(N):
    ans = max(ans, numbers[i][0] - i)

print(ans + 1)
