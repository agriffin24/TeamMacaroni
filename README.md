# Macaroni(Aidan Griffin, Ahnaf Hasan, Colin Hosking)
###### APCS2
###### Lab#00 -- But What Does the Data Say?
###### 2018-02-09

#### Our Hypothesis:
The algorithm, finding an item in a n x n matrix, runs on linear runtime O(n).
This means as n increases, the runtime of the algorithm will increase in direct proportion.

#### Background:
Preconditions:
* items in the n x n matrix ascend left to right
* items in the n x n matrix ascend top to bottom
* if the target item is found, return its coordinates (row #,column #)
* if the target item is not found, return (-1,-1)

 Our Algorithm: 
 Starting from the bottom left corner, the finder goes
 through by checking the number and moving
 right or up if the desired number is
 smaller or larger than the array number,
 respectively. Breaks if column or row is too big.

Worst Case:
Our algorithm's worst case occurs when the target item is in the top right corner of the matrix.
This is because our algorithm starts its search from the bottom left corner, and the farthest item will take the longest to reach.



Our experiment tested the runtime in nanoseconds of large n * n Matrix data sets. We had three trials for each value of n and averaged the results of the three trials to collect more accurate data. In order to collect the data, we storeda temporary long variable that calculate the nanoTime before running the code and compute the nanoTime after running the code subtractd by the previous nanoTime value. The value of n increases at a constant rate of 50 per loop so that we can test whether our data runs in O(n) time or not. While we generally got the linear increase as the data set grows larger, there were surprises in the results. We got repeating spikes in the data whose peaks are at 2700, 4150, 5500, 6650, 7850, 8650, 9150, 9600, 10000. The interesting thing about these peaks is that the difference between peaks is always decreasing from 1450 to 1350 to 1150 and so on. It was especially surprising to see that the peaks at which the average time was the highest were not in any form of an arithmetic/linear progression. However, this is still a linear regression as seen by the general trend line we did on the graph which means that our function definitely runs in O(n) time.
