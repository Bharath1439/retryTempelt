package retryProject.retryProject;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;


@Service
public class Serve  {

    @Autowired
    retryrepository retryrepository;

    @Autowired
    RetryTemplate retryTemplate;

    @Autowired
    DataSource dataSource;

    //using annotation.
    @Retryable(value = {ArithmeticException.class},maxAttempts = 5,backoff = @Backoff(delay = 2000))
    public String getMessage(retry retry) throws ArithmeticException  {
                  retryrepository.save(retry);
                  System.out.println("i am in service at getmessage before exception");
                  int a=1/0;
                  return "";
    }


    @Recover
    public String getRecoveryAfterRetry(){
        return "some thing went wrong with sql exception";
    }


    //using retry templet

//public void saveObjectWithRetry(retry retry,int n) {
//    RetryCallback<Void, ArithmeticException> retryCallback = new RetryCallback<Void, ArithmeticException>() {
//        @Override
//        public Void doWithRetry(RetryContext retryContext) {
//
//                     retryrepository.save(retry);
//                     System.out.println("I am inside service layer");
//                     int k = n / 0;
//                 return null;
//        }
//    };
//
//    retryTemplate.execute(retryCallback, context -> {
//        System.out.println("Arithmetic Exception hit here");
//        return null;
//    });
//}

}
