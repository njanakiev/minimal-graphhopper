FILE='data/berlin-latest.osm.pbf'

# Maven build MinimalGraphHopper
if [ "$1" == 'BUILD' ]; then
	mvn clean compile assembly:single -U -e
fi

# Make data/ folder if not exists
mkdir -p data/

# Download data from Geofabrik
if [ ! -f "$FILE" ]; then
	wget http://download.geofabrik.de/europe/germany/berlin-latest.osm.pbf -O $FILE
fi

# Run server with configuration from config.yml
java -jar target/minimal-0.0.1-SNAPSHOT-jar-with-dependencies.jar server config.yml
