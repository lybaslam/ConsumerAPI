package com.ConsumerService.AirItConsumer.Service;
import com.ConsumerService.AirItConsumer.Model.EmployeeDto;
import com.ConsumerService.AirItConsumer.Model.Financials;
import com.ConsumerService.AirItConsumer.Model.StackDto;
import com.ConsumerService.AirItConsumer.Repository.ConsumerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ConsumerService
{
    private final ConsumerRepository consumerRepository;
    private final RestTemplate restTemplate;
    private static final Logger LOGGER = LogManager.getLogger(ConsumerService.class);
    @Autowired
    public ConsumerService(ConsumerRepository consumerRepository, RestTemplate restTemplate)
    {
        this.consumerRepository = consumerRepository;
        this.restTemplate = restTemplate;
    }
    @Transactional
    public Financials addSalary(Financials financials,int Employee_Id)
    {
        try
        {
            //create financial object to save in data base
            //get employee by id from myfirstproject services
            //get employees first stack

            String baseurl= "http://localhost:8090/api/employees/"+ Employee_Id;
            HashMap<String, Object> response= restTemplate.getForObject(baseurl,HashMap.class);
            List<HashMap<String, Object>> listOfStacks = (List<HashMap<String, Object>>) response.get("stackList");
            financials.setEmployee_Id(Employee_Id);
            financials.setEmployee_Name((String)response.get("Name"));
            financials.setEmployee_Designation((String)response.get("Designation"));
            financials.setCompany_Address("Model Town");
            financials.setCompany_Contact("0334-3432535");
            financials.setCompany_Email("airitlabs@gmail.com");
            if (listOfStacks != null && !listOfStacks.isEmpty())
            {
                HashMap<String, Object> firstStack = listOfStacks.get(0);
                financials.setEmployee_Stack((String) firstStack.get("Name"));
            }


            return consumerRepository.save(financials);
        }
        catch(Exception e)
        {
            LOGGER.error("Error occurred while saving Financial");
            throw new RuntimeException("Error occurred while saving Financial" ,e);
        }


    }

    public ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
        try
        {
            //url to access
            String URl= "http://localhost:8090/api/employees";
            //making response entity to hold the api endpoint reponse
            ResponseEntity<HashMap[]> response = restTemplate.getForEntity(URl,HashMap[].class);
            HashMap<String,Object>[] EmployeeArray= response.getBody();

            //Mapping Employee Object To EmployeeDTO
            List<EmployeeDto> EmployeeDtoList = Arrays.stream(EmployeeArray)
                                               .map(employee-> EmployeeToEmployeeDto(employee))
                                                .collect(Collectors.toList());
            // returning employeeDtoList response entity

            return new ResponseEntity<>(EmployeeDtoList, HttpStatus.OK);
        }
        catch (Exception e)
        {
           LOGGER.error("Error occurred while retrieving Financialss");

           throw new RuntimeException("Error occurred while retrieving Financials" ,e);
        }

    }

    public EmployeeDto EmployeeToEmployeeDto(Map<String,Object> employee)
    {

        try {
            // helper function to map employee to EmployeeDto
            EmployeeDto employeeDto = new EmployeeDto();
            //looping employees stack list to make Stack Dto's
            List<StackDto> stackDtoList = ((List<Map<String, Object>>) employee.get("stackList")).stream()
                    .map(stack -> {
                        StackDto stackDto = new StackDto();
                        stackDto.setName((String) stack.get("Name"));
                        stackDto.setTool((String) stack.get("Tool"));
                        return stackDto;
                    }).collect(Collectors.toList());
            employeeDto.setName((String) employee.get("Name"));
            employeeDto.setDesignation((String) employee.get("Designation"));
            employeeDto.setStacks(stackDtoList);
            return employeeDto;
        } catch (Exception e)
        {

            LOGGER.error("Error occurred while mapping Employee to EmployeeDto");
            throw new RuntimeException("Error occurred while mapping Employee to EmployeeDto " ,e);
        }

    }

}
