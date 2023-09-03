# spring-cloud-demo
spring cloud demo

# How to run
just use dev_tool.sh

# How to run docker
- modify docker config
```
$ sudo vim /etc/docker/daemon.json
{
  "registry-mirrors": ["https://rbqc1q4r.mirror.aliyuncs.com"]
}
```
- use run_docker.sh

# How to request rabbitmq management page
localhost:15672 (admin/admin)

# How to view rancher password
docker logs <container id> 2>&1 | grep "Bootstrap Password:"

# How to use rancher server
rancher password: admin/OtFTCuRRWRqTCGhl
localhost:8443
