import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    //Metodo para consultar el cambio de moneda
    public Moneda ConsultaMoneda(String tipoDeCambio, double cantidad) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e9263505fe5ea7803b58cd56/pair/" + tipoDeCambio + cantidad);

        //conectando a la api por medio de httprequest
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        //recibimos la respuesa http
        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //retonamos un json que lo recibimos del response y lo trasnforma en pelicula
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {  //se colocan los dons dentro de catch ya que los dos lanzan la misma exception
            throw new RuntimeException("No se encuentra ese tipo de cambio" );
        }
    }
}
