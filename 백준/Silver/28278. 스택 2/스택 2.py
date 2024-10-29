import sys
from collections import deque

d = deque()
N = int(sys.stdin.readline())

commands = {
    '1': lambda x: d.append(int(x)),
    '2': lambda: print(-1 if len(d) == 0 else d.pop()),
    '3': lambda: print(len(d)),
    '4': lambda: print(1 if len(d) == 0 else 0),
    '5': lambda: print(-1 if len(d) == 0 else d[-1])
}

for _ in range(N):
    split = sys.stdin.readline().split()
    commands[split[0]](split[1]) if split[0] == '1' else commands[split[0]]()

