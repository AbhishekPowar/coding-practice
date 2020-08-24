package design.usecase.rover.universe;

public enum Direction {
    N(0, 1) {
        @Override
        public Direction rotateLeft() {
            return W;
        }

        @Override
        public Direction rotateRight() {
            return E;
        }
    },
    S(0, -1) {
        @Override
        public Direction rotateLeft() {
            return E;
        }

        @Override
        public Direction rotateRight() {
            return W;
        }
    },
    E(1, 0) {
        @Override
        public Direction rotateLeft() {
            return N;
        }

        @Override
        public Direction rotateRight() {
            return S;
        }
    },
    W(-1, 0) {
        @Override
        public Direction rotateLeft() {
            return S;
        }

        @Override
        public Direction rotateRight() {
            return N;
        }
    };

    private final int stepSizeOnXAxis;
    private final int stepSizeOnYAxis;

    Direction(int stepSizeOnXAxis, int stepSizeOnYAxis) {
        this.stepSizeOnXAxis = stepSizeOnXAxis;
        this.stepSizeOnYAxis = stepSizeOnYAxis;
    }

    public abstract Direction rotateLeft();
    public abstract Direction rotateRight();

    public int getStepSizeOnXAxis() {
        return this.stepSizeOnXAxis;
    }
    public int getStepSizeOnYAxis() {
        return this.stepSizeOnYAxis;
    }
}
