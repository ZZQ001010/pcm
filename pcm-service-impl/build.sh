mvn clean install -Dmaven.test.skip=true;
cd target;
tar -czf pcm-service-impl.tar.gz *.jar *-dependency/;
cp pcm-service-impl.tar.gz ../;
rm -rf *;
cp ../pcm-service-impl.tar.gz ./;

