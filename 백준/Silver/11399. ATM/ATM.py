import sys

N = int(sys.stdin.readline().strip())
numbers = list(map(int,sys.stdin.readline().strip().split()))

for i in range(1,N):
    cur = numbers[i]
    insert_point = i
    for j in range(i):
        if numbers[j] > cur:
            insert_point = j
            break

    for k in range(i,insert_point,-1):
        numbers[k] = numbers[k-1]

    numbers[insert_point] = cur

ans = [0] * N
ans[0] = numbers[0]
for i in range(1,N):
    ans[i] = ans[i-1] + numbers[i]

print(sum(ans))