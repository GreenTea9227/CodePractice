n = int(input())
left, right = 0, 0


ans = 0
sum_n = 0
while left <= right <= n:
    if sum_n == n:
        right += 1
        ans += 1
        sum_n += right
    elif sum_n < n:
        right += 1
        sum_n += right
    else:
        sum_n -= left
        left += 1




print(ans)
