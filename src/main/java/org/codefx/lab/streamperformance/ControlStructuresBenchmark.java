package org.codefx.lab.streamperformance;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;

/**
 * Uses {@link Blackhole} as a normalized operation to focus on different control benchmarks.
 * <p>
 * At least on my machine the runtimes of these methods were strange (presumably due to {@link Blackhole})
 * so I did not write about them. As for now, they are only left in the project for completeness sake.
 */
public class ControlStructuresBenchmark extends AbstractIterationBenchmark {

	// array

	@Benchmark
	public void array_for(Blackhole hole) {
		for (int i = 0; i < intArray.length; i++)
			hole.consume(intArray[i]);
	}

	@Benchmark
	public void array_forEach(Blackhole hole) {
		for (int intValue : intArray)
			hole.consume(intValue);
	}

	@Benchmark
	public void array_stream(Blackhole hole) {
		Arrays.stream(intArray).forEach(hole::consume);
	}

	@Benchmark
	public void array_stream_boxed(Blackhole hole) {
		Arrays.stream(intArray).boxed().forEach(hole::consume);
	}

	@Benchmark
	public void array_stream_parallel(Blackhole hole) {
		Arrays.stream(intArray).parallel().forEach(hole::consume);
	}

	@Benchmark
	public void array_stream_parallel_boxed(Blackhole hole) {
		Arrays.stream(intArray).boxed().parallel().forEach(hole::consume);
	}

	// list

	@Benchmark
	public void list_for(Blackhole hole) {
		for (int i = 0; i < intList.size(); i++)
			hole.consume(intList.get(i));
	}

	@Benchmark
	public void list_forEach(Blackhole hole) {
		for (int intValue : intList)
			hole.consume(intValue);
	}

	@Benchmark
	public void list_stream(Blackhole hole) {
		intList.stream().forEach(hole::consume);
	}

	@Benchmark
	public void list_stream_unbox(Blackhole hole) {
		intList.stream().mapToInt(Integer::intValue).forEach(hole::consume);
	}

	@Benchmark
	public void list_stream_parallel(Blackhole hole) {
		intList.stream().parallel().forEach(hole::consume);
	}

	@Benchmark
	public void list_stream_parallel_unbox(Blackhole hole) {
		intList.stream().mapToInt(Integer::intValue).parallel().forEach(hole::consume);
	}

}
