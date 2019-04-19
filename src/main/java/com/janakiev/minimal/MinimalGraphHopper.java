package com.janakiev.minimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.graphhopper.json.geo.JsonFeatureCollection;
import com.graphhopper.reader.osm.GraphHopperOSM;
import com.graphhopper.routing.weighting.Weighting;
import com.graphhopper.routing.util.HintsMap;
import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.storage.Graph;
import com.janakiev.minimal.routing.MinimalFlagEncoderFactory;
import com.janakiev.minimal.routing.MinimalWeighting;


public class MinimalGraphHopper extends GraphHopperOSM {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public MinimalGraphHopper(JsonFeatureCollection landmarkSplittingFeatureCollection) {
		super(landmarkSplittingFeatureCollection);
		logger.info("Running MinimalGraphHopper");
	
		super.setFlagEncoderFactory(new MinimalFlagEncoderFactory());
	}

	@Override
	public Weighting createWeighting(HintsMap hintsMap, FlagEncoder encoder, Graph graph) {
		String weightingStr = hintsMap.getWeighting().toLowerCase();
		if ("minimal_shortest".equals(weightingStr)) {
			return new MinimalWeighting(encoder);
		} else {
			return super.createWeighting(hintsMap, encoder, graph);
		}
	}
}
