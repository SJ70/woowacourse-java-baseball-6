package baseball.balls;

import java.util.List;

public class Balls {

    public static final int BALL_COUNT = 3;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validateValueDuplication(balls);
        validateIndexDuplication(balls);
        this.balls = balls;
    }

    private void validateValueDuplication(List<Ball> balls) {
        balls.forEach(ball -> {
            int sameValueCount = (int) balls.stream()
                    .filter(anotherBall -> anotherBall.hasSameValue(ball))
                    .count();
            if (sameValueCount > 1) {
                throw new IllegalArgumentException("값이 중복된 공이 존재합니다");
            }
        });
    }

    private void validateIndexDuplication(List<Ball> balls) {
        balls.forEach(ball -> {
            int sameIndexCount = (int) balls.stream()
                    .filter(anotherBall -> anotherBall.hasSameIndex(ball))
                    .count();
            if (sameIndexCount > 1) {
                throw new IllegalArgumentException("인덱스가 중복된 공이 존재합니다");
            }
        });
    }

}
