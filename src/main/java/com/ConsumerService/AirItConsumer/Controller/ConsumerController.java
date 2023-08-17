package com.ConsumerService.AirItConsumer.Controller;
import com.ConsumerService.AirItConsumer.Model.EmployeeDto;
import com.ConsumerService.AirItConsumer.Model.Financials;
import com.ConsumerService.AirItConsumer.Service.ConsumerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Financials")
public class ConsumerController
{

    private final ConsumerService consumerService;
    private static final Logger LOGGER = LogManager.getLogger(ConsumerController.class);
    @Autowired
    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

   @PostMapping("/add/{Employee_Id}")
    public Financials addSalary(@RequestBody Financials financials ,@PathVariable int Employee_Id)
   {
       try
       {
           return consumerService.addSalary(financials,Employee_Id);
       }
       catch(Exception e)
       {

           LOGGER.error("Error occurred while saving Financial");
           throw new RuntimeException("Error occurred while saving Financial" ,e);
       }
   }


   @GetMapping

    public ResponseEntity<List<EmployeeDto>> getEmployees()
   {
       try
       {

           return consumerService.getAllEmployees();
       }
       catch (Exception e)
       {
           LOGGER.error("Error occurred while retrieving Financials");
           throw new RuntimeException("Error occurred while retrieving Financials" ,e);
       }
   }


}
