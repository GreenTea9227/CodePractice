import heapq

N = int(input())
meeting = []

for i in range(N):
    start,end = map(int,input().split())
    heapq.heappush(meeting,(end,start))

ans = 0
current = -1
while meeting:
    end, start = heapq.heappop(meeting)
    if current <= start:
        ans += 1
        current = end

print(ans)
