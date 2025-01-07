import com.google.gson.Gson;
import dto.Moeda;
import service.Dispatcher;

public class main {

    public static void main(String[] args) {

        Dispatcher dispatcher = new Dispatcher();

        System.out.println(dispatcher.sendRequest("usd"));
    }

}
