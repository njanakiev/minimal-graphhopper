package com.janakiev.minimal.http;

import com.graphhopper.http.GraphHopperServerConfiguration;

import io.dropwizard.Application;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.graphhopper.http.cli.ImportCommand;
import com.graphhopper.http.resources.RootResource;
import com.graphhopper.http.CORSFilter;
import com.graphhopper.http.IPFilter;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public final class MinimalGraphHopperApplication extends Application<GraphHopperServerConfiguration> {

    public static void main(String[] args) throws Exception {
        new MinimalGraphHopperApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<GraphHopperServerConfiguration> bootstrap) {
        //bootstrap.addBundle(new GraphHopperBundle());
    	bootstrap.addBundle(new MinimalGraphHopperBundle());
        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/maps/", "index.html"));
        bootstrap.addCommand(new ImportCommand(bootstrap.getObjectMapper()));
    }

    @Override
    public void run(GraphHopperServerConfiguration configuration, Environment environment) {
        environment.jersey().register(new RootResource());
        environment.servlets().addFilter("cors", CORSFilter.class).addMappingForUrlPatterns(
        		EnumSet.allOf(DispatcherType.class), false, "*");
        environment.servlets().addFilter("ipfilter", new IPFilter(
        		configuration.getGraphHopperConfiguration().get("jetty.whiteips", ""), 
        		configuration.getGraphHopperConfiguration().get("jetty.blackips", ""))).addMappingForUrlPatterns(
        				EnumSet.allOf(DispatcherType.class), false, "*");
    }
}
