ReadMe file for Programming Assignment 1 of Recommender Systems.

Steps to run the program:
1.The program has been written in Java and you need a Java Runtime Environment to run it.
2.Place the Training and Testing data inside the same folder as the Pa1debug.java file.
3.In the Java file, edit the place where the file has been taken as input to match the name of the training(At [line 22]) and testing data file names(At [line263]).
4.On command prompt, go to the folder in which the program is unzipped and stored and type "javac Pa1debug.java".
5.The program will compile and then after it is done type "java Pa1debug".
6.It will show the output and also input the TOP K and TOP N values.

Timing for the program steps:(Note for the debugging set of train1.txt and test1.txt)
1.[Lines 21, 253-258]Step a takes an average of roughly 48956.08 ms
2.[Lines 260, 455-460]Step b takes an average of roughly 418430.91 ms

Sorting Algorithm:
1.I have used the sorting algorithm of merge sort.
2.Merge sort has the time complexity of O(nlog(n)) for best, average and worst cases and hence as it was fast I selected it.
2.It is placed at sort()[Line 464] and sort1()[Line 519]
3.I have named the functions sort() and sort1() and then passed the object array to them to be sorted and it returns the sorted results.

Description of how the program runs and what algorithms I have used:
Step 1:
1.[Lines 22-63]In order to read the text file and store its contents as CSR representation I have used 3 one dimensional arrays called val,row_ptr and col_ind.
The val array stores the ratings, the col_ind array stroes the items ID and the users are stored as row_ptr index and its values shows the items purchased 
by each user.The val and col_ind arrays get updated for each alternate value and the row_ptr array gets updated for each new line when detected. Thus, I have 
successfully completed the CSR representation of the matrix as taught in class because the data set has many zero values if represented as a two dimensional array 
and hence it would be a sparse matrix.While outputting the results I have taken care that the users' ID start from 1 as in Java it starts from zero in arrays.

2.[Lines 84-126]For calculating the item-item similarity, I first transposed the CSR matrix. For transposing the matrix directly from CSR representation store the 
transpose in CSR form as the items in the text file were not sorted I had to create a class called row_ptrT which has the parameters value and notimes. 
These parameters will help in taking the CSR matrix storing the item ID as value and the notimes which will count as to how many users have rated that 
particular item. So, the next cell of the row_ptrT which has the notimeswill contain that incremented. Eg:If in the CSR matrix we come across item 314 for 
2 users and the next item 513 for 1 user then the 3 cells of the row_ptrT array will have values like first cell:value=314, notimes=0; second cell:value=513, 
notimes=2; third cell:value=0, notimes=3. The last one value 0 is included to count the appearence of the last element.

3.[Lines 151-245]To calculate the item-item similarity after transpose, as the CSR is a row majored representation the items are stored in row_ptrT, users who rated each items 
are stored in col_ind and the val array shows the corresponding rating for each item by a particular user. I have used one counter in which if for two items if 
they are rated by the same user then the counter is increased and to calculate the total number of users who rated each item, I have placed two counters and then 
applied in the formula. I have stored the similarity value in double for better precision.

4.[Lines 151-245] After storing the similarity value between two items in an array of cosine objects called cosinestr and then called the sort1 function in which I have passed 
the cosinestr array and sorted it using merge sort and then have obtained the sorted set with respect to cosine values. It is still stored in cosinestr array 
and then I have stored it in the two dimensional array called cosinetable. 

5.[Lines 151-245]The item is compared with each other item in the set and then after the next item is compared with all other items and stored in the next row of cosinetable. 
The cosinetable 2D array contains all the item item similarities. Thus, I have used the data structure of array of objects to store the results.

6. The K input provided by the user is now used to calculate the users top K most similar unpurchased items with respect to purchased items in the set. For each user 
the rated items are placed in temp1 array and for each item in temp1 array it is compared with its corresponding item1val as the starting value and for that row of 
cosinetable a search is done for every item2val to check if it was purchased already by the user. If not then its value is taken and stored in cosinestr1 array of cosine 
objects. Note that it will come out as sorted as we have already stored the sorted items as per their cosine values. The top K items are only stored.

Step2:[Lines 261-450]
7.Now the cosinestr1 array contents are stored for each corresponding item in the cosinetable1 two dimensional array of cosine objects. Eg: So if there are 3 items rated 
by the user the Top K unpurchased items for each of the 3 items is stored in this table row by row. The cosinestr1 array stores each items' Top K unpurchased items in a 
sorted manner each time refreshing itself for memory efficency and then stored onto cosinetable1 for each item row by row.

8.[Lines 310-372]The candidate set for a user is generated by considering that each unpurchased item is compared in the cosinetable1 for each purchased item in each row to see if 
it is present. If present then it will add the cosine value and go to next row as long as next row is not equal to zero. Also each item in the cosinetable1 set is checked 
for duplicate values. If the candidate item has been considered once then it will not be taken again. Eg: If items 314 and 516 have an unpurchased item 11 in cosinetable1 
then the candidate set will display the sum of the cosine value of 11 with respect to both 314 and 516 items. Then it will sequentially go to the next item of 314 and so 
on. Then it will go to the next row of cosinetable1 after it finishes the first row and when it encounters item 11 it will check if 11 is present in the candidate set. 
As it is present, it will skip this item and go to the next unpurchased similar item of item 516 and so on.

9.[Lines 416-426]The ranking score is thus the sum of the cosine values of that particular cosine item with respect to all the users' purcahsed items. The Top N input can be taken from the 
user and then only the Top N items are copied onto another cand2 array of candidate objects.

10.[Lines 440-454]The HR is calculated by considering that when the test data is read for each user the if that item is present in the cand2 array then the hits counter is incremented 
by one. After coming out of calculation of all the users in the user loop the hits is divided by the number of users and the HR is outputted for a particular K and N set. 
The ARHR is calculated by finding out where the index of the unpurchased item for the hit in test data in the cand2 array was and then applying the formula for ARHR.

11.[Line 449]I have called System.gc() to to garbage collection in Java and to free up all memories.

12.[Lines 282-286]&[Lines 427-431]I have also obtained the output the Top N recommendations into an output file.

Note:
1.It was taking too long to run my program on the train_rating1.txt data set. Hence, I tried on my own dataset and then the debugging data set train1.txt and test1.txt 
and it is working and takes around 6 minutes to run the from start to end.
2.I am zipping all the contents in a zipped file including the README.txt, my Program Pa1debug.java, results.txt which contains the ARHR and HR values and also the 
TOP N recommendations of the candidate set based on Top K items similarity.
3.The files 35debug.txt,310debug.txt.....2020debug.txt I have named as input from command line while running the program. They are named as the values of K and N were
to be taken like K=3,N=3,debug data; K=10,N=10,debug data......,K=20,N=20,debug data.
4.The output on command line shows the time of execution and the ARHR and HR and also takes the inputs of K, N and Filename from the user of his choice.
5.The filename must end in .txt extension and it will get generated in the same folder as that of the program after execution. Just refresh the folder.
 

   