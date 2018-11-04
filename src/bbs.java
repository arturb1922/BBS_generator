public class bbs {
    private int p;
    private int q;
    private int M;
    private int seed;
    private int currentX;
    public bbs(int p, int q, int seed) {
        this.p = p;
        this.q = q;
        this.M = p*q;
        this.seed = seed;
        this.currentX = seed;
    }

    public int getrandom() {

        int r = currentX*currentX%M;
        currentX = r;
        return r;
    }


}
