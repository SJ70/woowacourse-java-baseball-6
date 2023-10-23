package baseball.validators;

import java.util.List;

public final class ListValidators {

    public static <T> void validateDistinct(List<T> objects) {
        int entireSize = objects.size();
        int distinctSize = (int) objects.stream()
                .distinct()
                .count();

        if (entireSize != distinctSize) {
            throw new IllegalArgumentException("중복된 값이 존재합니다");
        }
    }

}
