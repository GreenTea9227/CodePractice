N = int(input())
numbers = list(map(int, input().split()))
numbers.sort()
ans = 0

for i in range(N):
    target = numbers[i]
    left,right  = 0, N - 1

    while left < right:
        if left == i:
            left += 1
            continue
        if right == i:
            right -= 1
            continue

        if numbers[left] + numbers[right] == target:
            ans += 1
            break
        elif numbers[left] + numbers[right] < target:
            left += 1
        else:
            right -= 1

print(ans)