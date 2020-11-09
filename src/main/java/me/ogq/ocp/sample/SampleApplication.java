package me.ogq.ocp.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by kimyc. User: kim-yongchul Date: 2020/11/08 Time: 2:40 오후
 */
@SpringBootApplication(scanBasePackages = {"me.ogq.ocp.sample"})
public class SampleApplication {
  public static void main(String[] args){
    SpringApplication.run(SampleApplication.class, args);
  }
}
