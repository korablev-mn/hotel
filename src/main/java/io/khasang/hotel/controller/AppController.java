package io.khasang.hotel.controller;

import io.khasang.hotel.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
    private final CreateTable createTable;
    private final Message message;
    private final SelectTable selectTable;
    private final InsertTable insertTable;
    private final UpdateTable updateTable;
    private final DeleteTable deleteTable;
    private final JoinTable joinTable;
    private final CaseTable caseTable;

    @Autowired
    public AppController(Message message, CreateTable createTable, SelectTable selectTable, InsertTable insertTable, UpdateTable updateTable, DeleteTable deleteTable, JoinTable joinTable, CaseTable caseTable){
        this.createTable = createTable;
        this.message = message;
        this.selectTable = selectTable;
        this.insertTable = insertTable;
        this.updateTable = updateTable;
        this.deleteTable = deleteTable;
        this.caseTable = caseTable;
        this.joinTable = joinTable;
    }

    // http://localhost:8080/
    @RequestMapping("/")
    public String helloPage(Model model){
        model.addAttribute("name", message.getNameInfo("Jack Vorobei"));
        return "hello";
    }
    @RequestMapping("/create")
    public String tableCreationInfo(Model model){
        model.addAttribute("status", createTable.createTableStatus());
        model.addAttribute("insert", insertTable.insertTableStatus());
        model.addAttribute("select", selectTable.selectTableStatus());
        model.addAttribute("update", updateTable.updateTableStatus());
        model.addAttribute("case", caseTable.caseTableStatus());
        model.addAttribute("join", joinTable.joinTableStatus());
        model.addAttribute("delete", deleteTable.deleteTableStatus());
        return "status";
    }
    @ResponseBody
    @RequestMapping("/user")
    public String userPage(){
        return "user";
    }
    @ResponseBody
    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }
}
