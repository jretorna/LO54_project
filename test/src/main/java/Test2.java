public class Test2 {
	public static void main(String[] args) {
		while (true) {
			try {
				Thread.sleep(20000);
				System.out.println("Test 20s");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
