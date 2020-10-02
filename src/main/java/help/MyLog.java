package help;

import java.util.Arrays;

public final class MyLog {
	public static void p(Object arg) {
		System.out.print(arg);
	}
	
	public static void l(Object arg) {
		System.out.println(arg);
	}
	
	public static void l() {
		System.out.println("\n");
	}
	
	public static void lf(String format, Object... args) {
		System.out.printf(format + "\n", args);
	}
	
	public static void ats(Object[] arg) {
		System.out.println(Arrays.toString(arg));
	}
	
	public static void adts(Object[] arg) {
		System.out.println(Arrays.deepToString(arg));
	}
	public static void exit() {
		System.exit(0);
	}
}
