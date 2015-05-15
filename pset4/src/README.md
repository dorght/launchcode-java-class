pset 4 - Strategy Design Pattern
======

Here are some resources to help you with this pset:

* [Mike Menne's Strategy Pattern video](http://tv.launchcode.us/#/videos/java_strategy?lesson=Java)
* [CS50 study contains information about various sorting algorithms](https://study.cs50.net/)
* [Timing execution in Java](http://www.tutorialspoint.com/java/lang/system_nanotime.htm)

For this problem set, you will be using the Strategy Design Pattern as well as getting a feel for various sorting algorithms.

First, create a `SortStrategy` interface. This interface should be very simple!

Then, create an `ArraySorter` class. This class should also be fairly simple - it needs to include a method that accepts a `SortStrategy` object.

You should then write a few classes that implement the `SortStrategy` interface. Recall that you worked on [sorting in CS50](http://cdn.cs50.net/2015/spring/psets/3/pset3/pset3.html#sorting), so you can adapt those examples to suit your needs.

Try to incorporate at least one sorting algorithm that is O(n^2) (like bubble, insertion, or selection sort), and one that is O(n log n) (like mergesort). Write tests for your sorting algorithms to ensure that they work properly.

Finally, it is time to put your sorting strategy to work. Create a few example arrays, then sort them using all of your strategies. You should [time your sorts](http://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java) and print out the execution times once the sorting is finished.

Which sorting algorithm is the most efficient? How does the starting point of the array affect the amount of time it takes to sort? Which array takes the shortest amount of time to sort? The most amount of time?

#If you have time

Incorporate the OutputStrategy from lecture to allow the user to output the results to the console or to a file.
 
