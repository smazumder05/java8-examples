#Java Concurrency Features

##### 1. New [ExecutorCompletionService](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorCompletionService.html)
Unlike the normal executor, the CompletionExecutor Service follows a producer/consumer paradigm therefore as soon as a Thread is done, it puts the result into a non-blocking queue so that the consumer can take it. Whereas in a normal executor, a consumer has to wait until a bunch of threads return all together.
