basically, our search algorithm takes sometime to complete its search and give us an answer, 
the time it takes for the search algorithm increases if we give it a much longer array.

You can think of the equation ( 6n^2 + 100n + 300 ) as an equation that calculates for the time ( the equations does not calculate for time, but in a way, it makes no difference if we look at it as time ) it takes for the algorithm to search through an array of any length , and the length is represented by n, so if the array length is 60, n = 60, ok then.

you can see that, as "n" becomes bigger and bigger, _if you put the value of "n" in the equation, you get greater and greater values of time spent on the array just to finally get an answer_. 

We want to make algorithms faster, so clearly, this increase in time is not good.

- So, imagine you have a task to complete, and you have a team of 3 people(lets say your names are p1, p2 and p3), In this team, p1 and p2 are always working hard and finishing their part of the job quickly, but p3 is not the same, he is lazy.
- p3 will slow your entire team down, causing your team to take a longer time to complete the task. which means that, _whether a task will be completed quickly will all depend on p3_, if he is being lazy, your team is screwed, if he is being fast, then great.
- So who on this team decides how fast work is done ? .............. p3 of course, and because of that, if we instantly want to know, how fast a particular work will be done, we just have to go to p3 and ask him, **"Will you be lazy today ?"** if he says yes, then you know, the team will be slow.
- So clearly p3 is the deciding factor of how fast your team works. Since p3, is the deciding factor, if we are analyzing the speed of the team, since we know that p3 is the deciding factor, we just have to analyze his speed and that's it. Now lets look at the equation:

6n^2 + 100n + 300
when:
n=100 ___ 6n^2 = 60000 ___100n = 10000_____300 = 300____total = 70300

n=200 ____ 6n^2 = 240000 ___100n = 20000___ 300 = 300____total = 260300

n=300 ___ 6n^2 = 540000 ____100n = 30000____300 = 300____total = 570300

look at the above, which calculates for total time taken for each n, which part of the equation, is bringing in the biggest values? Who is contributing a lot, to total value of time ? ...............6n^2, since this part of the equation contributes the most to the total, **6n^2 becomes the deciding factor for how big the total time gets**. Hence if we are analyzing the time taken for any array of any length( which is n) and we dont have to be accurate or exact, we can just analyze the deciding factor, which is 6n^2, hence the reason why, in the above lesson, we focus on 6n^2.

The 6 is removed, because 6 will never change in the equation, meanwhile n^2 changes depending on the value of n, so why bother with the 6. We can just analyze n^2.

6 * ( n^2 )
       ^_____ this part is the one that's changing, and slowing down the algo from a broad perspective. Hence, this is the part that matters.
