package org.example;

class Main {
    public static void main(String [] args){
        ContactManager myContactManager = new ContactManager();
        Contact friendAvi = new Contact();
        friendAvi.name = "Avi";
        friendAvi.phoneNumber = "07458762435";
        Contact friendJoao = new Contact();
        friendJoao.name = "Joao";
        friendJoao.phoneNumber = "07257845454";

        myContactManager.addContact(friendAvi);
        myContactManager.addContact(friendJoao);
        Contact result = myContactManager.searchContact("Joao");
        System.out.println(result.phoneNumber);
    }
}