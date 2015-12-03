package means.application;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import means.configuration.MeansConfiguration;
import means.solution.TestResource;
import means.trials.TryHashmap;
import means.trials.database;

/**
 * Main application class for Web Introduction presentation. Will start dropwizard application server.
 * @see <a href="http://www.dropwizard.io/getting-started.html">http://www.dropwizard.io/getting-started.html</a>
 *
 */
public class MeansApplication extends Application<MeansConfiguration>
{

    @Override
    public void run(MeansConfiguration configuration, Environment environment)
    {
        environment.jersey().register(new TestResource());
    }
    
    @Override
    public void initialize(Bootstrap<MeansConfiguration> bootstrap)
    {
        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }
    


    public static void main(String[] args) throws Exception
    {
    	new MeansApplication().run(args);
    	database.connect();
    	Object testnew = TryHashmap.tryHash();
    	System.out.println(testnew);
    }
    
}