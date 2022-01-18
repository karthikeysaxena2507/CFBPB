package ConsumerFinancing.controller;

import ConsumerFinancing.model.customers.Customer;
import ConsumerFinancing.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = {"http://localhost:3000", "https://cf-brokerage.netlify.app/"})
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/redis")
    public String addCustomer(
            @RequestParam String hashKey,
            @RequestParam String key,
            @RequestBody Object value) {
        return customerService.addCustomerToRedis(hashKey, key, value);
    }

    @GetMapping("/redis")
    public Customer getCustomer(
            @RequestParam String hashKey,
            @RequestParam String key) {
        return customerService.getCustomerFromRedis(hashKey, key);
    }

}
