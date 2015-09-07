# Java 8 Stream Performance Benchmark

The benchmark code for the post [Stream Performance](http://blog.codefx.org/java/stream-performance/). Read it for details on the setup and where to find the results.

## Code

Benchmarks are split into three classes that cover operations of different complexity:

* [`SimpleOperationsBenchmark`](https://github.com/CodeFX-org/lab-java8streamperformancebenchmark/blob/master/src/main/java/org/codefx/lab/streamperformance/SimpleOperationsBenchmark.java): integer comparison and addition
* [`MediumOperationsBenchmark`](https://github.com/CodeFX-org/lab-java8streamperformancebenchmark/blob/master/src/main/java/org/codefx/lab/streamperformance/MediumOperationsBenchmark.java): a handful of multiplications
* [`ComplexOperationsBenchmark`](https://github.com/CodeFX-org/lab-java8streamperformancebenchmark/blob/master/src/main/java/org/codefx/lab/streamperformance/ComplexOperationsBenchmark.java): object creation and string manipulation

To tweak how the benchmarls are executed take a look into their superclass [`AbstractIterationBenchmark`](https://github.com/CodeFX-org/lab-java8streamperformancebenchmark/blob/master/src/main/java/org/codefx/lab/streamperformance/AbstractIterationBenchmark.java).
