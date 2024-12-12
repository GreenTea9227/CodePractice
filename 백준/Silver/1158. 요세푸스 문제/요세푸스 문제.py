class Node:
    def __init__(self, prev: 'Node', next: 'Node', data: int):
        self.prev = prev
        self.next = next
        self.data = data




number,depth =  map(int,input().split())
people = [i for i in range(1,number+1)]

head:Node = Node(None, None,people[0])

prev:Node = head
for person in people[1:]:
    node = Node(None, None, person)
    node.prev = prev
    prev.next = node
    prev = node

tail = head
while tail.next:
    tail = tail.next
tail.next = head
head.prev = tail

ans = []
cur : Node = head
cnt = number
while number>0:
    for _ in range(depth-1):
        cur = cur.next
    ans.append(cur.data)
    cur.prev.next = cur.next
    cur.next.prev = cur.prev
    number -= 1
    cur = cur.next

print("<" + ", ".join(map(str, ans)) + ">")

