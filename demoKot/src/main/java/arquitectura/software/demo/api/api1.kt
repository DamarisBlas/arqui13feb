package arquitectura.software.demo.api

import arquitectura.software.demo.dto.dto
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder.build
import okhttp3.Request
import okhttp3.Request.Builder.addHeader
import okhttp3.Request.Builder.build
import okhttp3.Request.Builder.method
import okhttp3.Request.Builder.url
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException
import java.math.BigDecimal

@RestController
class api1 {
    @RequestMapping("/")
    @Throws(IOException::class)
    fun usarApi(): String {

        val de = "EUR"
        val a = "BOB"
        val c = BigDecimal.valueOf(10)
        val convertir = dto(c, de, a)
        if (convertir.cantidad == 0) {
            println("Invalid mount")
        } else {
            val client = OkHttpClient().newBuilder().build()
            val request: Request = Builder()
                    .url("https://api.apilayer.com/exchangerates_data/convert?to=" + convertir.a + "&from=" + convertir.de + "&amount=" + convertir.cantidad)
                    .addHeader("apikey", "vQmb7yPEHSM67OkA1O2Gzdt81JNnVY5Y")
                    .method("GET", null).build()
            val response = client.newCall(request).execute()
            println(response.body!!.string())
        }
        return "ConvierteDivisas"
    }
}