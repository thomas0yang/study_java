package com.thomas.products.akka.rpc.example;

import java.io.Serializable;

public interface ExampleInterface extends Serializable{

	public String sayHello(String name);
}