package programa;

public enum Color {
	BLANC() {

        @Override
        public int getDirection() {
            return -1;
        }
        @Override
        public boolean esBlanca(){
            return true;
        }
    },
	NEGRE(){

        @Override
        public int getDirection() {
            return 1;
        }
        @Override
        public boolean esBlanca(){
            return false;
        }
    } ;
    public abstract int getDirection();
    public abstract boolean esBlanca();

}
