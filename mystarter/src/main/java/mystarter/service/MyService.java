package mystarter.service;


import org.springframework.context.annotation.Configuration;


public class MyService {

    private Myproperties myproperties;

    public void SayHello(){
        System.out.println(myproperties.getMessage());
    }

    public Myproperties getMyproperties() {
        return myproperties;
    }

    public void setMyproperties(Myproperties myproperties) {
        this.myproperties = myproperties;
    }
}
