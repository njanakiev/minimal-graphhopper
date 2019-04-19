if [ "$1" == 'BUILD' ]; then
	mvn clean compile assembly:single -U -e
fi

FILE='data/berlin-latest.osm.pbf'

if [ ! -f "$FILE" ]; then
	wget http://download.geofabrik.de/europe/germany/berlin-latest.osm.pbf -O $FILE
fi

java -jar target/minimal-0.0.1-SNAPSHOT-jar-with-dependencies.jar server config.yml
