class HelloWorld {
    private int n;
    public HelloWorld( int n){
        this.n = n;
    }
    public void hello() throws InterruptedException{
        synchronized (this){
            for (int i = 0; i < n; i++) {
                System.out.print("Hello");
                this.notify();
                try{
                    this.wait();
                    if (i+1==n){
                        this.notifyAll();
                        break;
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void world() throws InterruptedException{
        synchronized (this){
            for (int i = 0; i < n; i++) {
                System.out.println("World!");
                this.notify();
                try{
                    this.wait();
                    if (i+1==n){
                        this.notifyAll();
                        break;
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

}