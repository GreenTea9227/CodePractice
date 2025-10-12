N = int(input())
numbers = [int(input()) for _ in range(N)]

zero = numbers.count(0)
one = numbers.count(1)
minus = [i for i in numbers if i < 0]
minus.sort()
plus = [i for i in numbers if i > 1]
plus.sort(reverse=True)

ans = 0
for i in range(0,len(minus)-1,2):
    ans += minus[i] * minus[i+1]
if zero == 0 and len(minus) % 2 == 1:
    ans += minus[-1]

for i in range(0,len(plus)-1,2):
    ans += plus[i] * plus[i+1]
if len(plus) % 2 == 1:
    ans += plus[-1]

print(ans + one)