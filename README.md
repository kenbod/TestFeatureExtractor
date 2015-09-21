# Using the Feature Extractor

Here is an example Scala program that attempts to make use of the
Feature Extractor.

You can compile the program this way:

    ./gradlew shadowJar

You can run the program this way:

    ./run.sh

The program in ./run.sh looks like this:

    scala -classpath build/libs/TestFeatureExtractor-1.0-SNAPSHOT-all.jar edu.colorado.cs.muse.Main src/main/java/Main.java

In other words, it uses the <q>uberjar</q> created by the shadow plug-in
and tells the main program to process a test source file that is stored in
`src/main/java/Main.java`.

Let me know if you have any questions!
