package com.sbt.examples.jitgc;

import jitgc.src.main.java.com.sbt.examples.jitgc.conf.ConfigureJMH;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.RunnerException;


@State(Scope.Benchmark)
public class JitMain extends ConfigureJMH {

    private double value= Math.random() * Integer.MAX_VALUE;
    private float f = (float) value;

    @Benchmark
    public double doubleSqrt() {
        for (int i = 0; i < 1_000_000; i++);
        return Math.sqrt(value);
    }

    @Benchmark
    public double floatSqrt() {
        for (int i = 0; i < 1_000_000; i++);
        return (float) Math.sqrt(f);
    }

    public static void main(String[] args) throws RunnerException {
        run_JIT_vs_Interpreter(JitMain.class);
    }
}
