T = int(input())
for i in range(T):
    a, b = map(int, input().split(" "))
    cycle = []  # list 사용
    cur = a % 10

    while cur not in cycle:
        cycle.append(cur)
        cur = (cur * a) % 10

    result = cycle[(b - 1) % len(cycle)]
    print(result if result != 0 else 10)