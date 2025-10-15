import re
formula = input()

split = re.split(r'-', formula)

if len(split) == 1:
    print(sum(map(int,re.split(r'\+', formula))))
else:
    ans = sum(map(int, re.split(r'\+', split[0])))
    for i in range(1, len(split)):
        ans -= sum(map(int, re.split(r'\+', split[i])))
    print(ans)

