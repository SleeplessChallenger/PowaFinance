package org.viable;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class KWICTest {

    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = new PrintStream(System.out);

    public static void main(String[] args) {
        KWIC builder = new KWIC(new DataRepository(
                Stream.of(new LocalDataSource(
                        Arrays.stream(TestUtils.TEST_STRING.split(" ")).iterator(),
                        false)).toList()), new HashSet<>(Arrays.asList(TestUtils.STOP_WORDS_SAMPLE)), 8);
        out.println(builder);
        out.println(builder.getFirst());
        out.println(builder.getAll());

    }
}

class TestUtils {
    final static String TEST_STRING = "Fiscal and monetary tools will have to be used more aggressively to revive trade and to restore consumer and business confidence";
    final static String[] STOP_WORDS_SAMPLE = {"will", "have", ""};
}

class KWIC {
    private final List<? extends CharSequence> data;
    private final Set<? extends CharSequence> stopWords;
    private int stopWordsLen = 3;
    private int window = 8;

    public KWIC(DataRepository dataRepository, Set<? extends CharSequence> stopWords, int window) {
        this.data = dataRepository.getDataSource();
        this.stopWords = stopWords;
        this.window = window;
    }

    /**
     * Returns the {@code List} of {@code window}-length sentences
     * A keyword (except for stop words) comes first
     *
     * @return the list of all permuted sentences
     */
    public List<String> getAll() {
        return IntStream
                .range(1, data.size())
                .mapToObj(index ->
                        Stream.concat(data.stream().skip(index), data.stream().limit(index)).toList())
                .filter(strings -> strings.get(0).length() > stopWordsLen && !stopWords.contains(strings.get(0)))
                .map(strings -> strings.stream().limit(window).toList().toString())
                .toList();
    }

    public String getFirst() {
        return Stream.concat(data.stream().skip(1), data.stream().limit(1)).toList().toString();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

abstract class DataSource {
    protected abstract List<? extends CharSequence> getDataSource();
}

class LocalDataSource extends DataSource {
    private final List<String> dataSource;

    public LocalDataSource(Iterator<String> sourceIterator, boolean isParallel) {
        Iterable<String> iterable = () -> sourceIterator;
        this.dataSource = StreamSupport.stream(iterable.spliterator(), isParallel).toList();
    }

    @Override
    protected List<String> getDataSource() {
        return dataSource;
    }
}

class DataRepository {
    private final List<? extends DataSource> sources;

    public DataRepository(List<? extends DataSource> sources) {
        this.sources = sources;
    }

    public List<String> getDataSource() {
        return sources
                .stream()
                .flatMap(dataSource -> dataSource.getDataSource().stream().map(Objects::toString))
                .toList();
    }
}
