from collections import defaultdict

N, K = map(int, input().split(" "))
numbers = list(map(int, input().split(" ")))

sum_list = [0] * (len(numbers))
sum_list[0] = numbers[0]

for i in range(1, len(sum_list)):
    sum_list[i] = sum_list[i - 1] + numbers[i]

count = defaultdict(lambda: 0)
answer = 0

for i in range(N):
    find = sum_list[i] - K

    if sum_list[i] == K:
        answer += 1
    if find in count:
        answer += count[find]

    count[sum_list[i]] += 1

print(answer)
