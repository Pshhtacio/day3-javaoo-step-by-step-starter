package ooss;

import java.util.Objects;

public class Klass {

    private final int number;

    public Klass(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Klass)) return false;
        Klass klass = (Klass) o;
        return number == klass.number;
    }
}
