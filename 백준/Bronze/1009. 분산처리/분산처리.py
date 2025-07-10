T = int(input())
for i in range(T):
    a,b = map(int, input().split(" "))

    cur = 1
    for j in range(b):
        cur = (cur * a) % 10
    print(cur if cur != 0 else 10)

