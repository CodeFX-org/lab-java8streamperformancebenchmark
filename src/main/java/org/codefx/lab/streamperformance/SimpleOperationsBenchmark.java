package org.codefx.lab.streamperformance;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;

/**
 * Defines benchmarks that execute very simple operations like comparison or addition.
 * <p>
 * These are similar to those in
 * <a href="https://jaxenter.com/java-performance-tutorial-how-fast-are-the-java-8-streams-118830.html">
 * Java performance tutorial – How fast are the Java 8 streams?</a>
 */
public class SimpleOperationsBenchmark extends AbstractIterationBenchmark {

	// array

	@Benchmark
	public int array_max_for() {
		int m = Integer.MIN_VALUE;
		for (int i = 0; i < intArray.length; i++)
			if (intArray[i] > m)
				m = intArray[i];
		return m;
	}

	@Benchmark
	public int array_max_stream() {
		return Arrays.stream(intArray).max().getAsInt();
	}

	@Benchmark
	public int array_sum_for() {
		int s = 0;
		for (int i = 0; i < intArray.length; i++)
			s += intArray[i];
		return s;
	}

	@Benchmark
	public int array_sum_stream() {
		return Arrays.stream(intArray).sum();
	}

	@Benchmark
	public double array_averageLong_for() {
		long s = 0;
		for (int i = 0; i < intArray.length; i++)
			s += intArray[i];
		return s / intArray.length;
	}

	@Benchmark
	public double array_averageDouble_for() {
		double s = 0;
		for (int i = 0; i < intArray.length; i++)
			s += intArray[i];
		return s / intArray.length;
	}

	@Benchmark
	public double array_average_stream() {
		return Arrays.stream(intArray).average().getAsDouble();
	}

	@Benchmark
	public void array_blackHole_for(Blackhole hole) {
		for (int i = 0; i < intArray.length; i++)
			hole.consume(intArray[i]);
	}

	@Benchmark
	public void array_blackHole_stream(Blackhole hole) {
		Arrays.stream(intArray).forEach(hole::consume);
	}

	// list

	@Benchmark
	public int list_max_for() {
		int m = Integer.MIN_VALUE;
		for (int i = 0; i < intList.size(); i++)
			if (intList.get(i) > m)
				m = intList.get(i);
		return m;
	}

	@Benchmark
	public int list_max_stream() {
		return intList.stream().max(Math::max).get();
	}

	@Benchmark
	public int list_sum_for() {
		int s = 0;
		for (int i = 0; i < intList.size(); i++)
			s += intList.get(i);
		return s;
	}

	@Benchmark
	public int list_sum_stream() {
		return intList.stream().reduce(Integer::sum).get();
	}

	@Benchmark
	public double list_averageLong_for() {
		long s = 0;
		for (int i = 0; i < intList.size(); i++)
			s += intList.get(i);
		return s / intList.size();
	}

	@Benchmark
	public double list_averageDouble_for() {
		double s = 0;
		for (int i = 0; i < intList.size(); i++)
			s += intList.get(i);
		return s / intList.size();
	}

	@Benchmark
	public double list_average_stream() {
		return intList.stream().reduce(Integer::sum).get() / (double) intList.size();
	}

	@Benchmark
	public void list_blackHole_for(Blackhole hole) {
		for (int i = 0; i < intList.size(); i++)
			hole.consume(intList.get(i));
	}

	@Benchmark
	public void list_blackHole_stream(Blackhole hole) {
		intList.stream().forEach(hole::consume);
	}

}
