{\rtf1\ansi\ansicpg1252\cocoartf1265\cocoasubrtf200
{\fonttbl\f0\froman\fcharset0 TimesNewRomanPSMT;}
{\colortbl;\red255\green255\blue255;\red255\green255\blue255;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural

\f0\fs24 \cf0 Aparna Narayan: cs61bl-dg\
Smita Jain: cs61bl-dh\
\
1) \cb2  What is the runtime of the k-ary heap's insert? Write your answer in terms of both k, the branching factor of the tree, and N, the number of elements in the heap.\
Answer: The runtime of the k-ary heap\'92s insert, in terms of k, the branching factor, and N, the number of elements in the heap, is log N to the base k. \
2) What is the runtime of the k-ary heap's removeMax? Again write your answer in terms of k and N.\
Answer: The runtime of removeMax would be k*(log N to the base k). We came to this answer because each time in bubbleDown(), we go through all the children, which is dependent on the branching factor k, as we traverse the height of the max heap. Therefore, we get k*(log N to the base k).\
3) One CS 61B student claims that inserting and removing become faster as you increase k, because the depth of the heap decreases, allowing you to bubble up or bubble down through less distance. For example, this student claims that a trinary heap will be faster than a binary heap. Is this student right? Discuss.\
Answer: We don\'92t believe this student is right. Since insertion happens at log N to the base k, if we increase, k, then yes, insertion will be faster for larger ks. However, when we look at removing from the heap, then the larger the k, removing would take more steps, because it happens at k*(log N to the base k). So, for very big values of k, removing will be taking much more time that the advantages of a quicker insertion may be hidden. Therefore, we believe that increasing k only may not always create a faster heap.\
}