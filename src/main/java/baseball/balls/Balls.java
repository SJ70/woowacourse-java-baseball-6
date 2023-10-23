package baseball.balls;

import baseball.validators.ListValidators;
import java.util.List;

public class Balls {

    private static final int BALL_COUNT = 3;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validateSize();
        validateDistinctValue();
        validateDistinctIndex();
        this.balls = balls;
    }

    private void validateSize() {
        ListValidators.validateSize(balls, BALL_COUNT);
    }

    private void validateDistinctValue() {
        ListValidators.validateDistinct(
                balls.stream()
                        .map(Ball::getValue)
                        .toList()
        );
    }

    private void validateDistinctIndex() {
        ListValidators.validateDistinct(
                balls.stream()
                        .map(Ball::getIndex)
                        .toList());
    }

    public boolean hasSameValueBall(Ball anotherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.hasSameValue(anotherBall));
    }

    public boolean hasSameBall(Ball anotherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.equals(anotherBall));
    }

    public List<Ball> getBalls() {
        return balls;
    }

}
