import sys
import heapq

N = int(sys.stdin.readline().strip())
heap = []

for _ in range(N):
    num = int(sys.stdin.readline().strip())

    if num == 0:
        print(heapq.heappop(heap)[1] if heap else 0)
    else:
        heapq.heappush(heap, (abs(num), num))