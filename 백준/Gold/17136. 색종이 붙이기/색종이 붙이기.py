import math

square = [list(map(int, input().split())) for i in range(10)]
paper = [0] + [5] * 5  # 인덱스 1~5 사용
ans = math.inf


def dfs(x, y):
    global ans

    if y == 10:
        ans = min(ans, 25 - sum(paper[1:]))
        return

    # 다음 위치 계산
    nx, ny = (x + 1, y) if x + 1 < 10 else (0, y + 1)

    # 현재 칸이 0이면 다음으로
    if square[x][y] == 0:
        dfs(nx, ny)
        return

    # 현재 칸이 1이면 색종이로 덮기 시도
    for size in range(5, 0, -1):  # 큰 것부터 시도 (최적화)
        if paper[size] > 0 and check(x, y, size):
            paint(x, y, size, 0)
            paper[size] -= 1
            dfs(nx, ny)
            paper[size] += 1
            paint(x, y, size, 1)


def check(x, y, size):
    if x + size > 10 or y + size > 10:
        return False
    for i in range(x, x + size):
        for j in range(y, y + size):
            if square[i][j] == 0:
                return False
    return True


def paint(x, y, size, number):
    for i in range(x, x + size):
        for j in range(y, y + size):
            square[i][j] = number


dfs(0, 0)
print(ans if ans != math.inf else -1)