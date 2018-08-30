package com.dyadic.playground.activemq.demo.implicitlyDeclared;


import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/send")
public class ProducerResource {

    private JmsTemplate jmstemplate;
    private Queue queue;

    public ProducerResource(JmsTemplate jmstemplate, Queue queue) {
        this.jmstemplate = jmstemplate;
        this.queue = queue;
    }

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") final String messsage  ){
         jmstemplate.convertAndSend(queue,messsage);
         return "Success";
    }
}
