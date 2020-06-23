## Kubernetes and Kafka Estimator
Three different manifests are provided as templates based on different uses cases (It will differ based on the needs) for a Kafka cluster in kubernetes(K8s).

### Production Readiness
- It provides 5 servers with a disruption budget of 1 planned disruption. This cluster will tolerate 1 planned and 1 unplanned failure.
- Each server will consume 12 GiB of memory, 2 Gib of which will be dedicated to the ZooKeeper JVM heap.
- Each server will consume 4 CPUs.
- Each server will consume 1 Persistent Volume with 250 GiB of storage.
- You can tune the parameters as necessary to suite the needs of your deployment.
- ***The total footprint is 5 Nodes, 20 CPUs, 60 GiB memory, 1250 GiB disk.***

### Dev, QA, Stage(Pre-Prod) Readiness
- It provides 3 servers with a disruption budget of 1 planned disruption. This ensemble will not tolerate any concurrent unplanned failures during a planned disruption.
- Each server will consume 1 GiB of memory, 512 MiB of which will be dedicated to the ZooKeeper JVM heap.
- Each server will consume 0.5 CPUs.
- Each server will consume 1 Persistent Volume with 10 GiB of storage.
You can tune this infrastructure setup to your specific needs.
- ***The total footprint is 3 Nodes, 1.5 CPUs, 3 GiB memory, 30 GiB disk.***

### Local Development, Demos Readiness
- It provides 1 server with no disruption budget.
- The server will consume 1 GiB of memory, 512 Mib of which will be dedicated to the Kafka JVM heap.
- The server will consume 0.5 CPUs.
- The server will consume 1 persistent volume with 10 GiB of storage.
- ***The total footprint is 1 Node, 0.5 CPUs, 1 GiB memory, 10 GiB disk.***
