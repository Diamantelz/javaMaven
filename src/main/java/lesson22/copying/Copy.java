package lesson22.copying;

import java.io.IOException;

public interface Copy {
    void copy(String from, String to) throws IOException;
}
