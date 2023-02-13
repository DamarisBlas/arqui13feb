package arquitectura.software.demo.api;

import java.io.*;
import java.math.BigDecimal;

import arquitectura.software.demo.dto.dto;
import okhttp3.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class api1 {

    @RequestMapping("/")
    public String usarApi() throws IOException {
        //System.setProperty("Server","8095");
          String de="EUR", a="BOB" ;
          BigDecimal c= BigDecimal.valueOf(10);
        dto convertir = new dto(c,de,a);
        if (convertir.getCantidad().equals(0)){
            System.out.println("Invalid mount");
        }
        else {
            OkHttpClient client = new OkHttpClient().newBuilder().build();

            Request request = new Request.Builder()
                    .url("https://api.apilayer.com/exchangerates_data/convert?to=" + convertir.getA() + "&from=" + convertir.getDe() + "&amount=" + convertir.getCantidad())
                    .addHeader("apikey", "vQmb7yPEHSM67OkA1O2Gzdt81JNnVY5Y")
                    .method("GET", null).build();
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        }
    return "ConvierteDivisas";
}
    }

