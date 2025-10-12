from queue import PriorityQueue

N = int(input())

queue = PriorityQueue()
for i in range(N):
    queue.put(int(input()))

if N == 1:
    print(0)
else:
    ans = 0

    while queue.qsize() > 1:
        card1 = queue.get()
        card2 = queue.get()

        card_sum = card1 + card2
        ans += card_sum
        queue.put(card_sum)

    print(ans)