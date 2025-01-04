import sys
N = int(sys.stdin.readline())

numbers = []
ans=[]
seq=1
for i in range(N):
    cur = int(sys.stdin.readline())
    while seq <= cur:
        numbers.append(seq)
        seq+=1
        ans.append("+")

    if len(numbers) > 0 and numbers[-1] == cur:
        numbers.pop()
        ans.append("-")

if len(numbers) > 0:
    print("NO")
else:
    for i in ans:
        print(i)
