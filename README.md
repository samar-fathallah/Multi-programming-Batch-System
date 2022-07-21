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

2.1 Semaphore
A semaphore is a variable used to control access to a common resource by multiple
processes in a concurrent system such as a multi-programming operating system
by using two atomic operations, wait and post that are used for process synchronization
and a variable indicating the availability of this resource.

we have:
1. Reading data
2. Write into file in the disk.
3. Print data on the screen.
4. Take text input from the user.
For an illustration, to print on the screen, there will be 2 methods and a
variable:-
1. semPrintWait: any process calls it whenever it wants to print something
on the screen to acquire the key of the resource.
2. semPrintPost: any process calls it whenever it finishes printing to release
the key of the resource.
Note: ONLY ONE process is allowed to use the resource at a time.

2.2 Scheduling
A scheduling Algorithm is an algorithm used to schedule between processes to
ensure that all processes get to execute. As mentioned in the lecture, there are
many different scheduling algorithms to schedule processes. You are required to
implement ONLY ONE of the following algorithms:
1. Round Robin: Each process is assigned a fixed time slot in a cyclic way.
2. First Come First Serve (FCFS): Processes are executed on first come, first
serve basis.
3. Shortest Job First: Processes are executed depending on the their execution
time, the shortest process being the first to execute. The processor should
know in advance how much time each process will take to execute to order
the processes accordingly.
