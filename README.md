Spring Boot dummy application to test kubernetes deployment with fabric8
 
Usage:
```
mvn package fabric8:build
```
--> builds docker image see 
```
docker images
```
```
mvn fabric8:resource fabric8:apply
```
--> deploys to kubernetes see
```
kubectl get pods
kubecrl get svc 
```
shows port to run query

```
curl http://localhost:{port} | jq
```

To debug:

```
mvn fabric8:debug
```

IntelliJ: Run --> Edit Configurations --> + --> Remote (port 5005)

Todo: 
Plugin configuration in pom.xml doesn't work:
```
				<configuration>
					<enricher>
						<config>
							<fmp-controller>
								<replicaCount>2</replicaCount>
							</fmp-controller>
						</config>
					</enricher>
				</configuration>
```
After 
```
mvn fabric8:resource fabric8:apply
```
generated configuration file

```
./target/classes/META-INF/fabric8/kubernetes/random-generator-deployment.yml 
```
still contains:
```
(...)
spec:
  replicas: 1
  revisionHistoryLimit: 2
  selector:
    matchLabels:
(...)
```