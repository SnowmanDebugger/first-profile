import re

s="ada \n ff(dsd gg)afa dgg"
a= re.sub(u"\\(.*?\\)"," ",s)
print(a)