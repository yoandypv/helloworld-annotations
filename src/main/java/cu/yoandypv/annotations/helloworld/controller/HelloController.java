package cu.yoandypv.annotations.helloworld.controller;

import cu.yoandypv.annotations.helloworld.annotation.RunManyTimes;

public class HelloController {
	
	private final static String helloMessage = "Hello world ";

	public HelloController() {
		
	}
	
	@RunManyTimes(runTimes = 5)
	public void printHelloMessage() {		
		System.out.println(this.helloMessage);
	}
	
	

}
