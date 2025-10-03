N = int(input())
M = int(input())
things = list(map(int,input().split()))
things.sort()

ans = 0
left ,right = 0,N-1

while left < right:
    if things[left] + things[right] == M:
        ans += 1
        left += 1
        right -=1
    elif things[left] + things[right] < M:
        left += 1
    else:
        right -= 1
print(ans)