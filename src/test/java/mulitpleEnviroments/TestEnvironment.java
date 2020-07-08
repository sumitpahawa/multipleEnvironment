/*
 * package mulitpleEnviroments;
 * 
 * import org.testng.annotations.Test; import org.aeonbits.owner.ConfigFactory;
 * import org.testng.annotations.BeforeTest; import
 * org.testng.annotations.Parameters;
 * 
 * public class TestEnvironment { Environment TestEnv;
 * 
 * @BeforeTest
 * 
 * @Parameters({ "environment" }) public void beforeTst(String environment) {
 * ConfigFactory.setProperty("env", environment); TestEnv =
 * ConfigFactory.create(Environment.class);
 * 
 * }
 * 
 * @Test public void functionalTest() { System.out.println(TestEnv.getURL());
 * System.out.println(TestEnv.getDBHostname());
 * System.out.println(TestEnv.getDBPassword()); }
 * 
 * }
 */