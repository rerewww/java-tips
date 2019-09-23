package utils;

/**
 * Created by son on 2019-09-23.
 */
public class StopWatch {
	private String name;
	private long startTime;

	private long resultTime;

	public StopWatch(final String name) {
		this.name = name;
	}

	public void start() {
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		resultTime = System.currentTimeMillis() - startTime;
	}

	public void print() {
		System.out.println(String.format("[%s] time: %sms", name, resultTime));
	}

	public void stopAndPrint() {
		stop();
		print();
	}
}
