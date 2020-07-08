package mulitpleEnviroments;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:${env}.properties"})
public interface Environment extends Config {
	@Key("url")
	String getURL();

	@Key("username")
	String getUsename();

	@Key("password")
	String getPassword();

	@Key("db.hostname")
	String getDBHostname();

	@Key("db.port")
	String getDBPort();

	@Key("db.password")
	String getDBPassword();

}
