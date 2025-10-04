import sys

N = int(sys.stdin.readline().strip())
numbers = list(map(int, sys.stdin.readline().strip().split()))


stack = []
ans = [0] * len(numbers)

for i in range(N):
    if len(stack) == 0:
        stack.append((i,numbers[i]))
        continue

    while len(stack) > 0 and stack[-1][1] < numbers[i]:
        pop = stack.pop()
        ans[pop[0]] = numbers[i]

    stack.append((i, numbers[i]))

if stack:
    while stack:
        pop = stack.pop()
        ans[pop[0]] = -1

print(*ans)
