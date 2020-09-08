package uptc.edu.logica;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author xcheko51x
 */
public class Json {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("viajes.json"));
			JSONObject jsonObject = (JSONObject) obj;
			System.out.println("JSON LEIDO: " + jsonObject);

			JSONArray array = (JSONArray) jsonObject.get("Ciudades");

			for (int i = 0; i < array.size(); i++) {

				Iterator<JSONObject> iterator = array.listIterator(i);
				JSONArray array2 = (JSONArray) iterator.next().get("targets");

				JSONObject jsonObject1 = (JSONObject) array.get(i);
				System.out.println("\n" + (i + 1) + ".Ciudad de Salida : " + jsonObject1.get("source"));

				for (int j = 0; j < array2.size(); j++) {
					JSONObject jsonObject2 = (JSONObject) array2.get(j);
					System.out.println("\nCiudad de LLegada :" + jsonObject2.get("target"));
					System.out.println("Distancia : " + jsonObject2.get("distance"));
					System.out.println("Valor : " + jsonObject2.get("value"));

				}

			}

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ParseException e) {
		}

	}

}
