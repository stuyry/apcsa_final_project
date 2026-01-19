package Code.Points;


    public enum State { //this will be used to acheive the level
        LOW(25),
        MEDIUM(50), //UPDATE THESE VALUES AS A FRACTION OF HP
        MAX(100); //THIS SEEMS BALANCED

        private long actualValue;

        private State(long actualValue) {
            this.actualValue = actualValue;
        }

        public long getActualValue() {
            return actualValue;
        }
    }

