/**
 * 
 */
package cl.soporteweb.cce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lfhernandez
 *
 */
@RestController
@RequestMapping("/api")
public class MainController {
	
	@GetMapping("/get")
    public ResponseEntity<Resource> downloadFormulario() {
				        
		try {
		      URL url = new URL("https://agregador.cce.com.pe:3013/ssv2/payment-api/v3.5.0");
		      URLConnection con = url.openConnection();

		      BufferedReader in = new BufferedReader(
		         new InputStreamReader(con.getInputStream()));

		      String linea;
		      while ((linea = in.readLine()) != null) {
		         System.out.println(linea);
		      }

			ByteArrayResource bar;
			return ResponseEntity.ok().build();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
    }

}
