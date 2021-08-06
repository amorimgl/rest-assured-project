package project.common;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BodyRequest {

    private String path;
    private JSONObject bodyReturn;
    private JSONObject jsonObject;

    public BodyRequest(String path) {
        this.path = path;
    }

    public void readJsonFile() {

        JSONParser jsonParser = new JSONParser();

        try {
            jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
            bodyReturn = jsonObject;

        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        } catch (IOException e) {
            System.out.println("IO exception");

        } catch (ParseException e) {
            System.out.println("Parse Exception");
        }
    }

    public String displayBody() {

        return bodyReturn.toString();
    }
}
