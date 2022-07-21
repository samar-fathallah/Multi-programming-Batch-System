# Multi-programming-Batch-System
this project is a simulation of a multi-programming batch system using JAVA.


2.1 System Calls
A system call is the programmatic way in which a process requests a service from
the kernel of the operating system it is executed on. You are required to implement
system calls of your simulated OS using the built-in functions of Java.
Types of system calls required:
1. Read the data of any file from the disk.
2. Write text input to a file in the disk.
3. Print data on the screen.
4. Take text input from the user.

Our simulated OS can create different processes and switch between them in the
memory. In order to switch between processes, the OS must have information
about each process such as its state (running, ready ,etc..), and ID. The Operating
system chooses one process between all active processes to run first. Therefore,
the OS needs to keep track of all the created processes.
We have 5 main processes:
Process 1:
It should take input from the user: a filename. Then print the content of this file
on the screen.
Process 2:
It should take two inputs from the user: a filename, and some data. Then write
the data to the file.
Process 3:
It should count and display to the user the numbers from 0 to 300.
Process 4:
It should count and display to the user the numbers from 500 to 1000.
Process 5:
It should take two inputs from the user: a lower number and a larger number.
Then count from the lower number to the upper number and write the count to a
new file.
