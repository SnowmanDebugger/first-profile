#!/usr/bin/env python
#-*- coding: utf-8 -*-
import re
import io

def process_letter(str):
    str_out = ''.join(re.findall(r'[A-Za-z]',str))
    return str_out

def judge(s):
    f=0
    if s.startswith(('1','2','3','4','5','6','7','8','9')):
        f=1
    return f


res=""
section=""
# add_text=""
p1=re.compile(r'[(](.*?)[)]',re.S)
org_answer=""
final_answer=""
flag=0
f = open("/Users/mac/Desktop/文档/毛概2021/machine.txt","r")
for line in f:
    if judge(line):
        section=section+"答案:"+final_answer+"\n"
        res=res+section
        section=""
        flag=0
        if flag==0:
            if "(" in line:
                org_answer=''.join(re.findall(p1,line))
                final_answer=process_letter(org_answer)
                line=re.sub(u"\\(.*?\\)","(  )",line)
                flag=1
        section=section+line

    else:
        if flag==0:
            if "(" in line:
                org_answer=''.join(re.findall(p1,line))
                final_answer=process_letter(org_answer)
                line=re.sub(u"\\(.*?\\)"," ",line)
                flag=1
        section=section+line

f.close()

with io.open ("/Users/mac/Desktop/文档/毛概2021/machine_out.txt","w",encoding="utf-8") as outfile:
    outfile.write(res.decode('utf-8'))
    outfile.close()
