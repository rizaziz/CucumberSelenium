package testdata;

import java.io.Serializable;

/**
 * Created by admin on 10/1/16.
 */
public interface TestDataGenerator {
    Iterable<Serializable> generate(int size);
}
