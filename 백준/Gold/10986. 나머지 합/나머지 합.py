N,M = map(int,input().split())

numbers = list(map(int, input().split()))
sum_arr = [0]

for i in range(1,len(numbers)+1):
    sum_arr.append((sum_arr[i-1] + numbers[i-1]) % M)

op = [0] * (M+1)
op[0] = 1
for i in sum_arr[1:]:
    op[i % M] += 1

ans = sum(count * (count - 1) // 2 for count in op)
print(ans)


