package Code;

    public enum State { //this will be used to acheive the level
        LOW(5),
        MEDIUM(8), //UPDATE THESE VALUES AS A FRACTION OF HP
        MAX(10); //THIS SEEMS BALANCED

        private long actualValue;

        private State(long actualValue) {
            this.actualValue = actualValue;
        }

        public long getActualValue() {
            return actualValue;
        }
         
    }

