JVM has five types of GC implementations:

Serial Garbage Collector - single thread

Parallel Garbage Collector - multiple threads for m

CMS Garbage Collector - GC respond slower on average, but don't stop responding to perform garbage collection.
dropped

G1 Garbage (Garbage First) Collector - will replace the CMS collector,


Z Garbage Collector - ZGC performs all expensive work concurrently, without stopping the execution of application threads for more than 10 ms, which makes it suitable for applications that require low latency. It u



PUT is idempotent (pozwala na wielokrotne stosowanie operacji bez zmiany wyniku; PATCH can be idempotent but isn't required to be




Kolekcje:

# Lista




* Avoid Unnecessary Locks: We should use locks only for those members on which it is required. Unnecessary use of locks leads to a deadlock situation. We recommend you to use a lock-free data structure. If possible, keep your code free form locks. For example, instead of using synchronized ArrayList use the ConcurrentLinkedQueue.
* Avoid Nested Locks: Another way to avoid deadlock is to avoid giving a lock to multiple threads if we have already provided a lock to one thread. Since we must avoid allocating a lock to multiple threads.
* Using Thread.join() Method: You can get a deadlock if two threads are waiting for each other to finish indefinitely using thread join. If your thread has to wait for another thread to finish, it's always best to use join with the maximum time you want to wait for the thread to finish.
* Use Lock Ordering: Always assign a numeric value to each lock. Before acquiring the lock with a higher numeric value, acquire the locks with a lower numeric value.
* Lock Time-out: We can also specify the time for a thread to acquire a lock. If a thread does not acquire a lock, the thread must wait for a specific time before retrying to acquire a lock.