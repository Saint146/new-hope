package ru.newhope.importact;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.newhope.acceptactshow.AcceptActShowEntity;
import ru.newhope.acceptactshow.AcceptActShowRepository;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@Api(value = "Импорт акта")
public class ImportActController {
    @Autowired
    AcceptActShowRepository acceptActShowRepository;

    @GetMapping(value = "/accept_act_import/{accept_act_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity importAcceptAct(@PathVariable("accept_act_id") Integer id) {

        Optional<AcceptActShowEntity> actOpt =  acceptActShowRepository.findById(id);
        AcceptActShowEntity act = actOpt.get();

        deleteAllFilesFolder("C:/Program Files/apache-tomcat-9.0.54/webapps/food-platform/acts");
        //deleteAllFilesFolder("D:/users/ANMyasnikov/acts");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String actAsString = objectMapper.writeValueAsString(act);
            String newFileName = toFile(actAsString);


            final List<String> commands = new ArrayList<String>();
            commands.add("C:/Users/Administrator/Desktop/fs_app_imp/NewHopeFoodsharing.exe");
            commands.add("-accept");
            commands.add(newFileName);
//            commands.add("D:/users/ANMyasnikov/fs_app_imp/NewHopeFoodsharing.exe");
//            commands.add("-accept");
//            commands.add(newFileName);

            ProcessBuilder pb = new ProcessBuilder(commands);
            Process process = pb.start();

            //System.out.println(process.exitValue());

            //String newFileNamePdf = newFileName.replace(".json",".pdf");
            String newFileNamePdf = "acceptAct.pdf";

            return new ResponseEntity<>("http://vm2888336.33ssd.had.wf:8585/food-platform/acts/" + newFileNamePdf, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }


    public static String toFile(String data) throws IOException
    {
        //String fileName = java.util.UUID.randomUUID().toString().replaceAll("-", "");
        String fileName = "acceptAct";
        fileName = "C:/Program Files/apache-tomcat-9.0.54/webapps/food-platform/acts/" + fileName + ".json";
        //fileName = "D:/users/ANMyasnikov/acts/" + fileName + ".json";

        try
        {
            OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream(fileName), Charset.forName("UTF-8").newEncoder());
            streamWriter.write(data);
            streamWriter.close();
        }
        catch(IOException ex)
        {
            throw ex;
        }

        return fileName;
    }


    public static void deleteAllFilesFolder(String path) {
        for (File myFile : new File(path).listFiles())
            if (myFile.isFile()) myFile.delete();
    }


}
