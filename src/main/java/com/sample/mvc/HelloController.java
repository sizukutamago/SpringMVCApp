package com.sample.mvc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    private int id;

    private List<String> names = new ArrayList<>();
    private List<String> mails = new ArrayList<>();

    public HelloController() {
        super();
        names.add("taro");
        names.add("hanako");
        names.add("sachiko");
        names.add("tuyano");
        names.add("mami");
        mails.add("taro@yamada");
        mails.add("hanako@flower");
        mails.add("sachiko@happy");
        mails.add("shoda@tuyano.com");
        mails.add("mami@mumemo");
    }

    @RequestMapping("/hello")
    public XmlData index() {
        XmlData obj = new XmlData(id, names.get(id), mails.get(id));
        id = ++id == names.size() ? 0 : id;
        return obj;
    }
}

@XmlRootElement(name = "xmldata")
@XmlAccessorType(XmlAccessType.NONE)
class XmlData {
    @XmlAttribute
    private Integer id;

    @XmlElement
    private String name;

    @XmlElement
    private String email;

    public XmlData() {
        super();
        this.id = 0;
        this.name = "noname";
        this.email = "no@mail";
    }

    public XmlData(Integer id, String name, String email) {
        this();
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
