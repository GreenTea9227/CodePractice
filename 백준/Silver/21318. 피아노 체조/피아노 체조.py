N: int = int(input())
level: list[int] = list(map(int, input().split()))

Q: int = int(input())

levelList: list[int] = [0]

for i in range(1, len(level)):
    levelList.append(1 + levelList[i - 1] if level[i] < level[i - 1] else levelList[i - 1])

for i in range(Q):
    x, y = map(lambda num: int(num) - 1, input().split())
    print(levelList[y] - levelList[x])
