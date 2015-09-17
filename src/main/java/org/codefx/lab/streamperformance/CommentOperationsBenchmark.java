package org.codefx.lab.streamperformance;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.Arrays;

/**
 * Benchmarks inspired by the comments on the post covering the other benchmarks.
 */
public class CommentOperationsBenchmark extends AbstractIterationBenchmark {

	@Benchmark
	public int array_max_for() {
		int m = Integer.MIN_VALUE;
		for (int i = 0; i < intArray.length; i++)
			if (intArray[i] > m)
				m = intArray[i];
		return m;
	}

	@Benchmark
	public int array_max_forEach() {
		int m = Integer.MIN_VALUE;
		for (int intValue : intArray)
			if (intValue > m)
				m = intValue;
		return m;
	}

	@Benchmark
	public int array_max_forWithException() {
		int m = Integer.MIN_VALUE;
		try {
			for (int i = 0; ; i++)
				if (intArray[i] > m)
					m = intArray[i];
		} catch (ArrayIndexOutOfBoundsException ex) {
			return m;
		}
	}

	@Benchmark
	public int array_min_for() {
		int m = Integer.MAX_VALUE;
		for (int i = 0; i < intArray.length; i++)
			if (intArray[i] < m)
				m = intArray[i];
		return m;
	}

	@Benchmark
	public int boxedArray_max_for() {
		int m = Integer.MIN_VALUE;
		for (int i = 0; i < integerArray.length; i++)
			if (integerArray[i] > m)
				m = integerArray[i];
		return m;
	}

	@Benchmark
	public int boxedArray_max_forEach() {
		int m = Integer.MIN_VALUE;
		for (int intValue : integerArray)
			if (intValue > m)
				m = intValue;
		return m;
	}

	@Benchmark
	public int boxedArray_max_stream() {
		return Arrays.stream(integerArray).max(Math::max).get();
	}

	@Benchmark
	public int boxedArray_max_stream_unboxed() {
		return Arrays.stream(integerArray).mapToInt(x -> x).max().getAsInt();
	}

	@Benchmark
	public int list_max_for() {
		int m = Integer.MIN_VALUE;
		for (int i = 0; i < intList.size(); i++)
			if (intList.get(i) > m)
				m = intList.get(i);
		return m;
	}

	@Benchmark
	public int list_max_forEach() {
		int m = Integer.MIN_VALUE;
		for (int intValue : intList)
			if (intValue > m)
				m = intValue;
		return m;
	}

	@Benchmark
	public int list_max_stream() {
		return intList.stream().max(Math::max).get();
	}

	@Benchmark
	public int list_min_stream() {
		return intList.stream().min(Math::max).get();
	}

	@Benchmark
	public int list_max_stream_unboxed() {
		return intList.stream().mapToInt(x -> x).max().getAsInt();
	}

	@Benchmark
	public int list_min_stream_unboxed() {
		return intList.stream().mapToInt(x -> x).min().getAsInt();
	}

}
