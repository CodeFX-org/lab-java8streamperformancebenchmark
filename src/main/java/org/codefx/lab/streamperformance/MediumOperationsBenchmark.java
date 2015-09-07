package org.codefx.lab.streamperformance;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.Arrays;

/**
 * Defines benchmarks that execute an arithmetic computation consisting of a handful of operations.
 */
public class MediumOperationsBenchmark extends AbstractIterationBenchmark {

	// array

	@Benchmark
	public int array_for() {
		int result = 0;
		for (int i = 0; i < intArray.length; i++)
			result = arithmeticOperation(result, intArray[i]);
		return result;
	}

	@Benchmark
	public int array_forEach() {
		int result = 0;
		for (int intValue : intArray)
			result = arithmeticOperation(result, intValue);
		return result;
	}

	@Benchmark
	public int array_stream() {
		return Arrays
				.stream(intArray)
				.reduce(0, this::arithmeticOperation);
	}

	@Benchmark
	public int array_stream_boxed() {
		return Arrays
				.stream(intArray)
				// artificially box the ints
				// even though the next step would be fine with Integers
				.boxed()
				.reduce(0, this::arithmeticOperation);
	}

	@Benchmark
	public int array_stream_parallel() {
		return Arrays
				.stream(intArray)
				.parallel()
				.reduce(0, this::arithmeticOperation);
	}

	@Benchmark
	public int array_stream_parallel_boxed() {
		return Arrays
				.stream(intArray)
				// artificially box the ints
				// even though the next step would be fine with Integers
				.boxed()
				.parallel()
				.reduce(0, this::arithmeticOperation);
	}

	// list

	@Benchmark
	public int list_for() {
		int result = 0;
		for (int i = 0; i < intList.size(); i++)
			result = arithmeticOperation(result, intArray[i]);
		return result;
	}

	@Benchmark
	public int list_forEach() {
		int result = 0;
		for (int intValue : intList)
			result = arithmeticOperation(result, intValue);
		return result;
	}

	@Benchmark
	public int list_stream() {
		return intList
				.stream()
				.reduce(0, this::arithmeticOperation);
	}

	@Benchmark
	public int list_stream_unbox() {
		return intList
				.stream()
				// try to naively unbox the Integer into ints
				.mapToInt(Integer::intValue)
				.reduce(0, this::arithmeticOperation);
	}

	@Benchmark
	public int list_stream_parallel() {
		return intList
				.stream()
				.parallel()
				.reduce(0, this::arithmeticOperation);
	}

	@Benchmark
	public int list_stream_parallel_unbox() {
		return intList
				.stream()
				// try to naively unbox the Integer into ints
				.mapToInt(Integer::intValue)
				.parallel()
				.reduce(0, this::arithmeticOperation);
	}

}
