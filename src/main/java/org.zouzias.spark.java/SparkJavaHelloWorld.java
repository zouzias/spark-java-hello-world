package org.zouzias.spark.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.zouzias.spark.lucenerdd.api.java.LuceneJavaRDD;

import java.util.Arrays;
import java.util.Iterator;

public class SparkJavaHelloWorld {

    public static void main(String[] argsc) {

        // Setup Spark Configuration
        SparkConf sparkConf = new SparkConf()
                .setAppName("SparkJavaHelloWorld")
                .setMaster("local[*]");

        // Define Java Spark Context
        JavaSparkContext ctx = new JavaSparkContext(sparkConf);

        // Perform the read. Filename specified in-line
        JavaRDD<String> lines = ctx.textFile("./data/amazon.csv", 1);

        LuceneJavaRDD<String> luceneRDD = LuceneJavaRDD.fromRDD(lines);

        // Lets do something different, do a word count
        JavaRDD<String> words = lines.flatMap( (s) -> Arrays.asList(s.split(" ")).iterator());

        // Display results
        System.out.println("Read " + lines.count() + " row(s) with " + words.count() + " words");

        ctx.stop();

    }

}