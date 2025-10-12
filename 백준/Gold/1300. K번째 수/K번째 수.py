N = int(input())
K = int(input())

left, right = 1 ,N*N
while left < right:
    mid = (left + right) // 2
    cnt = 0
    for i in range(1,N+1):
        cnt += min(mid // i , N)

    if cnt < K:
        left = mid + 1
    else:
        right = mid
print(left)



