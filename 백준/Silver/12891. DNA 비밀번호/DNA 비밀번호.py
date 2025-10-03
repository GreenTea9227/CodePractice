S, P = map(int, input().split())
password = input()

alpha = dict(zip('ACGT', [0, 0, 0, 0]))
check_alpha = dict(zip('ACGT', map(int, input().split())))

start = 0
end = P
ans = 0

for k in password[:P]:
    alpha[k] += 1


while end <= S:
    if all([alpha[key] >= value for key,value in check_alpha.items()]):
        ans+=1

    if end == S:
        break

    alpha[password[start]] -= 1
    start += 1
    alpha[password[end]] += 1
    end += 1

print(ans)

