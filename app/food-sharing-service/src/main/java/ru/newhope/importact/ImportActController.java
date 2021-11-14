package ru.newhope.importact;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@RestController
@Api(value = "Импорт акта")
public class ImportActController {
    @GetMapping(value = "/accept_act_import/{accept_act_id}")
    @ResponseBody
    public String importAcceptAct(@PathVariable("accept_act_id") Integer id) {

        deleteAllFilesFolder("C:/Users/Administrator/Desktop/fs_buf");

        try {
            String data = "{\n" +
                    "\t\"agreementDate\": \"29.02.2020\",\n" +
                    "\t\"agreementNumber\": \"146\",\n" +
                    "\t\"locality\": \"г. Москва\",\n" +
                    "\t\"acceptanceDate\": \"13.11.2021\",\n" +
                    "\t\"organizationName\": \"ООО «Шестёрочка»\",\n" +
                    "\t\"organizationRepresenter\": \"Пупкин Иван Иванович\",\n" +
                    "\t\"organizationRepresenterGen\": \"Пупкина Ивана Ивановича\",\n" +
                    "\t\"organizationRepresenterAccordance\": \"ч. 1 ст. 182 ГК РФ (полномочия, вытекающие из окружающей обстановки)\",\n" +
                    "\t\"volunteerName\": \"Петрова Владислава Васильевна\",\n" +
                    "\t\"actItems\": [\n" +
                    "\t\t{\n" +
                    "\t\t\t\"productName\": \"Хлеб дарницкий\",\n" +
                    "\t\t\t\"amount\": 1.0,\n" +
                    "\t\t\t\"price\": 19.9,\n" +
                    "\t\t\t\"expirationDate\": \"2021-11-14T19:00:00.000+00:00\",\n" +
                    "\t\t\t\"note\": \"Примечание к позиции 1\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"productName\": \"Батон нарезной\",\n" +
                    "\t\t\t\"amount\": 5.0,\n" +
                    "\t\t\t\"price\": 40.9,\n" +
                    "\t\t\t\"expirationDate\": \"2021-11-15T19:00:00.000+00:00\",\n" +
                    "\t\t\t\"note\": \"Вот!\"\n" +
                    "\t\t},\n" +
                    "\t\t{\n" +
                    "\t\t\t\"productName\": \"Булочка\",\n" +
                    "\t\t\t\"amount\": 1.0,\n" +
                    "\t\t\t\"price\": 250.9,\n" +
                    "\t\t\t\"expirationDate\": \"2021-11-18T19:00:00.000+00:00\",\n" +
                    "\t\t\t\"note\": \"\"\n" +
                    "\t\t}\n" +
                    "\t]\n" +
                    "}";
            toFile(data);

            final List<String> commands = new ArrayList<String>();


            commands.add("C:/Users/Administrator/Desktop/fs_app_imp/NewHopeFoodsharing.exe");
            commands.add("-accept");
            commands.add("C:/Users/Administrator/Desktop/fs_buf/buf.txt");

            ProcessBuilder pb = new ProcessBuilder(commands);
            Process process = pb.start();

            System.out.println(process.exitValue());


            File file = new File("C:/Users/Administrator/Desktop/fs_buf/buf.pdf");

            try {
                if (file.exists() == true) {
                    moveFile("C:/Users/Administrator/Desktop/fs_buf/buf.pdf", "C:/Users/Administrator/Desktop/buf.pdf");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }

        return "Start importing act with id=" + id;
    }

    public static void toFile(String data) throws IOException {

        try(FileWriter writer = new FileWriter("C:/Users/Administrator/Desktop/fs_buf/buf.txt", false))
        {
            writer.write(data);
            writer.flush();
        }
        catch(IOException ex){
            throw ex;
        }
    }

    private static void moveFile(String src, String dest ) {
        Path result = null;
        try {
            result =  Files.move(Paths.get(src), Paths.get(dest));
        } catch (IOException e) {
            System.out.println("Exception while moving file: " + e.getMessage());
        }
        if(result != null) {
            System.out.println("File moved successfully.");
        }else{
            System.out.println("File movement failed.");
        }
    }

    public static void deleteAllFilesFolder(String path) {
        for (File myFile : new File(path).listFiles())
            if (myFile.isFile()) myFile.delete();
    }
}
