import console.Core;
import models.Write;

public class App {
    public static void main(String[] args) throws  IllegalMonitorStateException {
        Core core = new Core();
        Write write = new Write();
        write.write();
        core.userChoose();
    }
}
