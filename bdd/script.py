#! /usr/bin/python3

r = open("word.txt", 'r')

t = open("word2.txt", 'w')
for i in r.readlines():
    if len(i) == 7:
        t.write(i)
