package com.janakiev.minimal.routing;

import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.routing.util.DataFlagEncoder;
import com.graphhopper.routing.util.CarFlagEncoder;
import com.graphhopper.routing.util.Car4WDFlagEncoder;
import com.graphhopper.routing.util.BikeFlagEncoder;
import com.graphhopper.routing.util.Bike2WeightFlagEncoder;
import com.graphhopper.routing.util.RacingBikeFlagEncoder;
import com.graphhopper.routing.util.MountainBikeFlagEncoder;
import com.graphhopper.routing.util.FootFlagEncoder;
import com.graphhopper.routing.util.HikeFlagEncoder;
import com.graphhopper.routing.util.MotorcycleFlagEncoder;
import com.graphhopper.routing.util.FlagEncoderFactory;
import com.graphhopper.util.PMap;

public class MinimalFlagEncoderFactory implements FlagEncoderFactory {
    final String MINIMAL = "minimal";
	
	@Override
    public FlagEncoder createFlagEncoder(String name, PMap configuration) {
        if (name.equals(GENERIC))
            return new DataFlagEncoder(configuration);

        else if (name.equals(CAR))
            return new CarFlagEncoder(configuration);

        else if (name.equals(CAR4WD))
            return new Car4WDFlagEncoder(configuration);

        if (name.equals(BIKE))
            return new BikeFlagEncoder(configuration);

        if (name.equals(BIKE2))
            return new Bike2WeightFlagEncoder(configuration);

        if (name.equals(RACINGBIKE))
            return new RacingBikeFlagEncoder(configuration);

        if (name.equals(MOUNTAINBIKE))
            return new MountainBikeFlagEncoder(configuration);

        if (name.equals(FOOT))
            return new FootFlagEncoder(configuration);

        if (name.equals(HIKE))
            return new HikeFlagEncoder(configuration);

        if (name.equals(MOTORCYCLE))
            return new MotorcycleFlagEncoder(configuration);
        
        if (name.equals(MINIMAL))
        	return new MinimalFlagEncoder(configuration);

        throw new IllegalArgumentException("entry in encoder list not supported " + name);
    }
}