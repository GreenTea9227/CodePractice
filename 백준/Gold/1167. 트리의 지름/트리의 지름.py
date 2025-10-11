import sys
from collections import deque

V = int(sys.stdin.readline().strip())
tree = {i:[] for i in range(1,V+1)}

for i in range(V):
    inputs = list(map(int,sys.stdin.readline().strip().split()))
    fnode = inputs[0]
    for j in range(1,len(inputs)-1,2):
        snode,distance = inputs[j],inputs[j+1]
        tree[fnode].append((snode,distance))
        tree[snode].append((fnode,distance))

def bfs(start):
    nodes = [0] * (V+1)
    deq = deque()
    deq.append(start)
    visited = [False] * (V+1)
    visited[start] = True

    while deq:
        node = deq.popleft()
        for snode, s_dis in tree[node]:
            if not visited[snode]:
                deq.append(snode)
                visited[snode] = True
                nodes[snode] = nodes[node] + s_dis

    return nodes

b = bfs(1)
max_index = max(range(1, V+1), key=lambda i: b[i])

second_max = bfs(max_index)
print(max(second_max))