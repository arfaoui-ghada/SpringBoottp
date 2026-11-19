package com.example.demo.web.controller;
import com.example.demo.Client;
import com.example.demo.Services.IClientServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("client")
public class ClientController {
    private final IClientServices IClientServices;
    @PostMapping("add")
    public Client createClient (@RequestBody Client client){
        return IClientServices.addClient(client);
    }
}
