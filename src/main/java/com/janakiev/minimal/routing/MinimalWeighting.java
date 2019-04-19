package com.janakiev.minimal.routing;

import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.util.EdgeIteratorState;
import com.graphhopper.routing.weighting.ShortestWeighting;


public class MinimalWeighting extends ShortestWeighting {
    public MinimalWeighting(FlagEncoder flagEncoder) {
        super(flagEncoder);
    }

	@Override
    public double getMinWeight(double currDistToGoal) {
        return currDistToGoal;
    }

    @Override
    public double calcWeight(EdgeIteratorState edgeState, boolean reverse, int prevOrNextEdgeId) {
        return edgeState.getDistance();
    }

    @Override
    public String getName() {
        return "minimal_shortest";
    }
}
