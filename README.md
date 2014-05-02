java8-examples
==============

> ### A project to try out new java 8 features listed below

<b> 1. Lambda expressions </b>

Even if we really didn’t want to go mainstream here, there’s little doubt that from a developer’s perspective, the most dominant feature of Java 8 is the new support for Lambda expressions. This addition to the language brings Java to the forefront of functional programming, right there with other functional JVM-based languages such as Scala and Clojure.

We’ve previously looked into how Java implemented Lambda expressions, and how it compared to the approach taken by Scala. From Java’s perspective this is by far one of the biggest additions to the language in the past decade.


At minimum, it’s recommended you become familiar with the Lambda syntax, especially as it relates to array and collection operations, where Lambdas have been tightly integrated into the core language libraries. It is highly likely that you’ll start seeing more and more code like the snippet below in both 3rd party and within your organization’s code.

```java
     Map<Person.Sex, List<Person>> byGender =
         roster.stream().collect(Collectors.groupingBy(Person::getGender));
```

* A pretty efficient way of grouping a collection by the value of a specific class field.


<b> 2. Parallel operations </b>

With the addition of Lambda expressions to arrays operations, Java introduced a key concept into the language of internal iteration. Essentially as developers we’re used to use loop operations as one of the most basic programming idioms, right up there with if and else.

The introduction of Lambda expressions turned that paradigm around, with the actual iteration over a collection on which a Lambda function is applied now carried out by the core library itself (i.e. internal iteration).

You can think of this as an extension of iterators where the actual operation of extracting the next item from a collection on which to operate is carried out by an iterator. An exciting possibility opened by this design pattern is to enable operations carried out on long arrays such as sorting, filtering and mapping to be carried out in parallel by the framework. When dealing with server code that’s processing lengthy collections on a continuous basis, this can lead to major throughput improvements with relatively little work from your end.

Here’s the same snippet as above, but using the framework’s new parallel processing capabilities -

```java
ConcurrentMap<Person.Sex, List<Person>> byGender =
    roster.parallelStream().collect(
        Collectors.groupingByConcurrent(Person::getGender));
```

* It’s a fairly small change that’s required to make this algorithm run on multiple threads.

<b>3. Java + JavaScript = ❤ </b>

Java 8 is looking to right one of its biggest historical wrongs – the ever growing distance between Java and JavaScript, one that has only increased in the past few years. With this new release, Java 8 is introducing a completely new JVM JavaScript engine – Nashorn. This engine makes unique use of some of the new features introduced in Java 7 such as invokeDynamic to provide JVM-level speed to JavaScript execution right there with the likes of V8 and SpiderMonkey.

This means that the next time you’re looking to integrate JS into your backend, instead of setting up a node.js instance, you can simply use the JVM to execute the code. The added bonus here is the ability to have seamless interoperability between your Java and JavaScript code in-process, without having to use various IPC/RPC methods to bridge the gap.

<b> 4. New date / time APIs </b>

The complexity of the current native Java library API has been a cause of pain for Java developers for many years. Joda time has been filling this vacuum for years now, and with Java 8. An immediate question that arose early on was why didn’t Java 8 adopt Joda as its native time framework. Due to what was perceived as a design flaw in Joda, Java 8 implemented its own new date / time API from scratch. The good news is that unlike Calendar.getInstance(), the new APIs were designed with simplicity in mind, and clear operations to operate on manipulated values in both human readable and machine time formats.

<b> 5. Concurrent accumulators </b>

One of the most common scenarios in concurrent programming is updating of numeric counters accessed by multiple threads. There have been many idioms to do this over the years, starting from synchronized blocks (which introduce a high level of contention), to read/write locks to AtomicInteger(s). While the last ones are more efficient, as they rely directly on processor CAS instructions, they require a higher degree of familiarity to implement the required semantics correctly.

With Java 8 this problem is solved at the framework level with new concurrent accumulator classes that enable you to very efficiently increase / decrease the value of a counter in a thread safe manner. This is really a case where it’s not a question of taste, or preference – using these new classes in your code is really a no-brainer.


