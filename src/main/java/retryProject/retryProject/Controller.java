package retryProject.retryProject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Serve serve;

    @PostMapping("getdata")
    public ResponseEntity<String> getMessage(@RequestBody retry retry){
        int n=5;
                  try {
                      serve.getMessage(retry);
                      return new ResponseEntity<>("Connection failed", HttpStatus.OK);
                  } catch (Exception e) {
                      System.out.print(e.toString());
                  }

       return new ResponseEntity<>("i am last statement", HttpStatus.OK);
    }
}
