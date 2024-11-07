package org.example;


import org.example.crudServices.ClientCrudService;
import org.example.entity.Client;

public class MainClass {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        ClientCrudService clientCrudService = new ClientCrudService();
        Client client = new Client();

        clientCrudService.creatClient(client);
    }
}
