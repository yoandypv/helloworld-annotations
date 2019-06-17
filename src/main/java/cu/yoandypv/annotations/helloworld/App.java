package cu.yoandypv.annotations.helloworld;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cu.yoandypv.annotations.helloworld.annotation.RunManyTimes;
import cu.yoandypv.annotations.helloworld.controller.HelloController;

/**
 * Hello world annotations sample
 */
public class App {
	public static void main(String[] args) {
		try {

			HelloController helloController = new HelloController();
			helloController.printHelloMessage();
			
			// Only for debug in runtime
			Method method = helloController.getClass().getMethod("printHelloMessage");
			invokeMethod(method, helloController);
			// ----
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// This function is only for debug.
	private static void invokeMethod(Method method, HelloController helloController)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final RunManyTimes runManyTimes = method.getAnnotation(RunManyTimes.class);

		if (runManyTimes != null) {
			final int timesToInvoke = runManyTimes.runTimes();

			for (int i = 0; i < timesToInvoke; i++) {
				method.invoke(helloController, (Object[]) null);
			}
		}

	}
}
