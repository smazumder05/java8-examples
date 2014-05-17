java8-examples
==============

> ### A project to try out new java 8 features listed below

<b> 1. Lambda expressions </b>



```java
     Map<Person.Sex, List<Person>> byGender =
         roster.stream().collect(Collectors.groupingBy(Person::getGender));
```

* A pretty efficient way of grouping a collection by the value of a specific class field.


<b> 2. Parallel operations </b>

With the addition of Lambda expressions to arrays operations, Java introduced a key concept into the language of internal iteration. 

The introduction of Lambda expressions turned that paradigm around, with the actual iteration over a collection on which a Lambda function is applied now carried out by the core library itself (i.e. internal iteration).



```java
ConcurrentMap<Person.Sex, List<Person>> byGender =
    roster.parallelStream().collect(
        Collectors.groupingByConcurrent(Person::getGender));
```

* It’s a fairly small change that’s required to make this algorithm run on multiple threads.

<b>3. Java Traits = ❤ </b>
Java 8 also added the ability to include method implementations in interfaces (which turns them into what is known as “traits”). For
example, the FooBar interface below contains two methods, one abstract (foo) and the other (bar) with a default implementation. The useFooBar method, well, uses a FooBar

```java
/**
 * Even though FooBar has two methods, only one of them (foo) is not implemented, so it
 * is still a functional interface, and can be created with a lambda expression.
 *
 * @author smazumder
 */
public interface JavaTrait {

    /**
     *
     * @param x
     * @return
     */
    int foo(int x);

    /**
     * Default implementation of the method bar is already provided
     *
     * @return
     */
    default boolean bar(int x) {
        return true;
    }

}
 
```

<b>4. Java + JavaScript = ❤ </b>

With this new release, Java 8 is introducing a completely new JVM JavaScript engine – Nashorn. This engine makes unique use of some of the new features introduced in Java 7 such as invokeDynamic to provide JVM-level speed to JavaScript execution right there with the likes of V8 and SpiderMonkey.

This means that the next time we are looking to integrate JS into your backend, instead of setting up a node.js instance, you can simply use the JVM to execute the code. The added bonus here is the ability to have seamless interoperability between your Java and JavaScript code in-process, without having to use various IPC/RPC methods to bridge the gap.

<b> 5. New date / time APIs </b>



<b> 6. Concurrent accumulators </b>

One of the most common scenarios in concurrent programming is updating of numeric counters accessed by multiple threads. There have been many idioms to do this over the years, starting from synchronized blocks (which introduce a high level of contention), to read/write locks to AtomicInteger(s). While the last ones are more efficient, as they rely directly on processor CAS instructions, they require a higher degree of familiarity to implement the required semantics correctly.

With Java 8 this problem is solved at the framework level with new concurrent accumulator classes that enables me to very efficiently increase / decrease the value of a counter in a thread safe manner. This is really a case where it’s not a question of taste, or preference – using these new classes in your code is really a no-brainer.


