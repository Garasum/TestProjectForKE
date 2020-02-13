package temp.exeptino;

import java.io.FileNotFoundException;
import java.io.IOException;

//ExeptionInherritance - We can only narrow down exeption\method during inherritance
public class ExeptionInherritance {
}

class SuperClass {
    public void start() throws IOException {
        throw new IOException("Not able to open file");
    }
}

class SubClass extends SuperClass {

    public void start() throws FileNotFoundException {
        // FileNotFoundException - наследник IOException
        throw new FileNotFoundException("Not able to start");
    }
}