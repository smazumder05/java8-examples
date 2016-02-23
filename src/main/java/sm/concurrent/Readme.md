#Java 8 Concurrency Features

##### 1. New CompletionExecutor Service 
Unlike the normal executor, the CompletionExecutor Service follows a producer/consumer paradigm therefore as soon as a Thread is done, it puts the result into a non-blocking queue so that the consumer can take it. Whereas in a normal executor, a consumer has to wait until a bunch of threads return all together.
