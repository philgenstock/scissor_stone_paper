package de.philgenstock.ssp;

public enum Shape {
    STONE,
    SCISSOR,
    PAPER;

    private boolean winChecker(Shape shape) {
        return switch (this) {
            case STONE -> shape == SCISSOR;
            case SCISSOR -> shape == PAPER;
            case PAPER -> shape == STONE;
        };
    }

    public Result calculateResultAgainst(Shape shape) {
        if(shape == this) return Result.TIE;
        return winChecker(shape)? Result.WIN: Result.LOOSE;
    }


}
