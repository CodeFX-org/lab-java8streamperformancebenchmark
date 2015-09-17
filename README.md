# Java 8 Stream Performance Benchmark

The benchmark code for the posts [Stream Performance](http://blog.codefx.org/java/stream-performance/) and [Stream Performance - Your Ideas](http://blog.codefx.org/java/stream-performance-your-ideas/). Read them for details on the setup. The results are gathered in [this Google Spreadsheet](https://docs.google.com/spreadsheets/d/1K-y44zFrBWpZXkdaBI80-g_MqJiuphmuZAP6gg6zz_4/edit#gid=1205798000).

## Code

For the first post, benchmarks are split into three classes that cover operations of different complexity:

* [`SimpleOperationsBenchmark`](https://github.com/CodeFX-org/lab-java8streamperformancebenchmark/blob/master/src/main/java/org/codefx/lab/streamperformance/SimpleOperationsBenchmark.java): integer comparison and addition
* [`MediumOperationsBenchmark`](https://github.com/CodeFX-org/lab-java8streamperformancebenchmark/blob/master/src/main/java/org/codefx/lab/streamperformance/MediumOperationsBenchmark.java): a handful of multiplications
* [`ComplexOperationsBenchmark`](https://github.com/CodeFX-org/lab-java8streamperformancebenchmark/blob/master/src/main/java/org/codefx/lab/streamperformance/ComplexOperationsBenchmark.java): object creation and string manipulation

And for the second post:

* [`CommentOperationsBenchmark`](https://github.com/CodeFX-org/lab-java8streamperformancebenchmark/blob/master/src/main/java/org/codefx/lab/streamperformance/CommentOperationsBenchmark.java): benchmarks according to your ideas

To tweak how the benchmarks are executed take a look into their superclass [`AbstractIterationBenchmark`](https://github.com/CodeFX-org/lab-java8streamperformancebenchmark/blob/master/src/main/java/org/codefx/lab/streamperformance/AbstractIterationBenchmark.java).
