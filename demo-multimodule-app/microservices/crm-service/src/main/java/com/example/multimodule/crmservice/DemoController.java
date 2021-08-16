package com.example.multimodule.crmservice;

import com.example.multimodule.crmservice.service.CustomerService;
import com.example.multimodule.db.entity.Customer;
import com.example.multimodule.utils.AppUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crm")
public class DemoController {

    CustomerService service;

    @GetMapping
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return String.format("Hello %s!", name);
        return AppUtils.APP_DATA;
    }

    @PostMapping
    public Customer save(Customer customer){
        return service.save(customer);
    }


}
