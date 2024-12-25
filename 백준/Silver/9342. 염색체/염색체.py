alpha: list[str] = ['A', 'B', 'C', 'D', 'E', 'F']

def check(data: str):
    # 시작과 끝 검사
    if data[0] not in alpha:
        print('Good')
        return
    if data[-1] not in alpha:
        print('Good')
        return

    if data[0] != 'A':
        data = data[1:]
    if data[-1] != 'C':
        data = data[:-1]

    cur = data[0]
    for i in range(1, len(data)):
        if cur[-1] != data[i]:
            cur += data[i]
    print('Infected!' if cur == 'AFC' else 'Good')


T = int(input())
for _ in range(T):
    check(input())
