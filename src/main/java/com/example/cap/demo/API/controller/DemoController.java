
package com.example.cap.demo.API.controller;

import com.google.cloud.datastore.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.cloud.gcp.data.datastore.core.convert.DatastoreServiceObjectToKeyFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    private Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    private static final String ENTITY_KIND = "Customer";
    private final KeyFactory keyFactory = datastore.newKeyFactory().setKind(ENTITY_KIND);

    public Key createCustomer(Customers customer){
        Key key = datastore.allocateId(keyFactory.newKey());
        Entity customerEntity = Entity.newBuilder(key)
                .set(customer.CUSTOMER_ID, 05)
                .set(customer.FIRSTNAME, "Albert")
                .set(customer.LASTNAME, "Einstein")
                .build();
        datastore.put(customerEntity);
        return key;
    }
    @RequestMapping("/getCustomer/{id}")
    public Customers readCustomer(Key custid) {
    	  
    	    Entity custEntity =datastore.get(custid);
    	    return entityToCustomer(custEntity);
    	  
    	}
    
    @RequestMapping("/getCustomers")
    public List<Customers> getAllCustomer(){
        Query<Entity> query = Query.newEntityQueryBuilder()
                .setKind(ENTITY_KIND)
                .build();
        Iterator<Entity> entities = datastore.run(query);
        return buildCustomers(entities);
    }

    private List<Customers> buildCustomers(Iterator<Entity> entities){
        List<Customers> customers = new ArrayList<>();
        entities.forEachRemaining(entity-> customers.add(entityToCustomer(entity)));
        return customers;
    }

    private Customers entityToCustomer(Entity entity){
        return new Customers.Builder()
                .customerid(entity.getString(Customers.CUSTOMER_ID))
                .fname(entity.getString(Customers.FIRSTNAME))
                .lname(entity.getString(Customers.LASTNAME))
                .build();
    }
}