package com.janakiev.minimal.routing;

import com.graphhopper.routing.profiles.EncodedValue;
import com.graphhopper.routing.util.CarFlagEncoder;
import com.graphhopper.util.PMap;

import java.util.List;

public class MinimalFlagEncoder extends CarFlagEncoder {

	public MinimalFlagEncoder() {
        this(5, 5, 0);
    }
	
	public MinimalFlagEncoder(int speedBits, double speedFactor, int maxTurnCosts) {
		super(speedBits, speedFactor, maxTurnCosts);
	}
	
	public MinimalFlagEncoder(PMap properties) {
		super(properties);
	}

	@Override
    public void createEncodedValues(List<EncodedValue> registerNewEncodedValue, String prefix, int index) {
        // first two bits are reserved for route handling in superclass
        super.createEncodedValues(registerNewEncodedValue, prefix, index);
    }
	
	@Override
	public String toString() {
		return "minimal";
	}
}