import sys
from collections import defaultdict, deque

N: int = int(sys.stdin.readline())

node = [0] * (N + 1)
node[1] = 1

node_map = defaultdict(list)
visited = [False] * len(node)
visited[1]=True

for i in range(N-1):
    n1, n2 = map(int, sys.stdin.readline().split())
    node_map[n1].append(n2)
    node_map[n2].append(n1)

queue = deque()
queue.append(1)

while queue:
    parent = queue.popleft()
    child = node_map[parent]
    for k in child:
        if visited[k]:
            continue
        node[k] = parent
        visited[k] = True
        queue.append(k)

for a in range(2, len(node)):
    print(node[a])
