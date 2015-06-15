import junit.framework.TestCase;
import fr.utbm.core.service.impl.ReleveService;

public class AppTest extends TestCase {
	public void testTemperature() throws Exception {
		ReleveService rs = new ReleveService();
		assertEquals(true, rs.isCorrectTemperature(20, -50, 100));
	}
}
