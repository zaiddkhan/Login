package com.example.login

class model {
   lateinit  var email  : String
   lateinit var name  : String
   lateinit var password : String
constructor(){

}
    constructor(email: String, name: String, password: String) {
        this.email = email
        this.name = name
        this.password = password
    }

}